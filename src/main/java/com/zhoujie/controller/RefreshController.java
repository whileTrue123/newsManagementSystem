package com.zhoujie.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhoujie.model.News;
import com.zhoujie.model.NewsType;
import com.zhoujie.service.NewsService;
import com.zhoujie.service.NewsTypeService;
import com.zhoujie.utils.ResponseUtil;

import net.sf.json.JSONObject;

/** 
* @author zhoujie
*/
@Controller
public class RefreshController {
	
	@Resource
	private NewsService newsService;
	@Resource
	private NewsTypeService newsTypeService;
	
	@RequestMapping(value = "/refreshSystem")
	public void refreshSystem(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		ServletContext application=session.getServletContext();
		List<NewsType> newsTypeList=newsTypeService.getTypeList();
		application.setAttribute("newsTypeList", newsTypeList);
		List<News> newestNewsList=newsService.newestNewsList();
		application.setAttribute("newestNewsList", newestNewsList);
		
		List<News> hotNewsList=newsService.hotNewsList();
		application.setAttribute("hotNewsList", hotNewsList);
		JSONObject result=new JSONObject();
		result.put("success", true);
		try {
			ResponseUtil.write(result, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
