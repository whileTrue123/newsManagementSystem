package com.zhoujie.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.zhoujie.model.News;
import com.zhoujie.model.NewsType;
import com.zhoujie.service.NewsService;
import com.zhoujie.service.NewsTypeService;
import com.zhoujie.utils.NavUtil;
import com.zhoujie.utils.ResponseUtil;
import com.zhoujie.utils.StringUtil;

import net.sf.json.JSONObject;
import newsManagementSystem.test;

/**
 * @author zhoujie
 */
@Controller
public class NewsTypeController {

	@Resource
	private NewsTypeService newsTypeService;
	@Resource
	private NewsService newsService;
	
	private static Logger logger = Logger.getLogger(test.class);

	/**
	 * ���������Ӻ��޸�
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/preSave")
	public String newsTypePreSave(HttpServletRequest request, HttpServletResponse response, Model model) {
		logger.info("start...preSave.action");
		String typeId = request.getParameter("newstypeid");
		if (StringUtil.isNotEmpty(typeId)) {
			int newstypeid = Integer.parseInt(typeId);
			if (newstypeid != 0) {
				NewsType newsType = newsTypeService.selectByPrimaryKey(newstypeid);
				request.setAttribute("newsType", newsType);
				request.setAttribute("navCode", NavUtil.genNewsManageNavigation("����������", "��������޸�"));
			} else {
				request.setAttribute("navCode", NavUtil.genNewsManageNavigation("����������", "����������"));
			}
		}

		request.setAttribute("mainPage", "/background/newsType/newsTypeSave.jsp");
		return "/background/mainTemp";
	}
	
	/**
	 * ȷ�����
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/save")
	public String newsTypeSave(HttpServletRequest request, HttpServletResponse response){
		logger.info("start...save.action");
		String typeName=request.getParameter("typeName");
		String newstypeid=request.getParameter("newstypeid");
		NewsType newsType=new NewsType(typeName);
		
		if(StringUtil.isNotEmpty(newstypeid)){//����
			newsType.setNewstypeid(Integer.parseInt(newstypeid));
			newsTypeService.updateByPrimaryKey(newsType);
		}else{
			newsTypeService.insertSelective(newsType);//���
		}
		
		//�����ɺ���ʾ��������б�
		return "redirect:/backList.action";
	}
	
	/**
	 * ��ʾ��������б�
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/backList")
	public String newsTypeBackList(HttpServletRequest request, HttpServletResponse response){
		logger.info("start...backList.action");
		List<NewsType> typeList = newsTypeService.getTypeList();
		logger.info(JSON.toJSONString(typeList));	
		request.setAttribute("newsTypeBackList", typeList);
		request.setAttribute("navCode", NavUtil.genNewsManageNavigation("����������", "�������ά��"));
		request.setAttribute("mainPage", "/background/newsType/newsTypeList.jsp");
		return "/background/mainTemp";
	}
	
	@RequestMapping(value = "/delete" , method = RequestMethod.POST)
	public void newsTypeDelete(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String newstypeid = request.getParameter("newstypeid");
		JSONObject result=new JSONObject();
		int parseInt = Integer.parseInt(newstypeid);
		if(StringUtil.isNotEmpty(newstypeid)){
			List<News> selectByTypeId = newsService.selectByTypeId(parseInt);
			if(selectByTypeId != null){
				result.put("errorMsg", "����������������ţ�����ɾ�����������");
			}else{
				int delNums = newsTypeService.deleteByPrimaryKey(parseInt);
				if(delNums>0){
					result.put("success", true);
				}else{
					result.put("errorMsg", "ɾ��ʧ��");
				}
			}
			ResponseUtil.write(result, response);
		}
	}
}
