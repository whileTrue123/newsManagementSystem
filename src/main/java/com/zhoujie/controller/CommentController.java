package com.zhoujie.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zhoujie.model.Comment;
import com.zhoujie.model.PageBean;
import com.zhoujie.service.CommentService;
import com.zhoujie.utils.NavUtil;
import com.zhoujie.utils.PageUtil;
import com.zhoujie.utils.ResponseUtil;
import com.zhoujie.utils.StringUtil;

import net.sf.json.JSONObject;

/** 
* @author zhoujie
*/
@Controller
public class CommentController {
	
	@Resource
	private CommentService commentService;
	
	@RequestMapping(value = "/commentBackList")
	public String commentBackList(HttpServletRequest request , HttpServletResponse response , Model model){
		String bDate=request.getParameter("s_bCommentDate");
		String aDate=request.getParameter("s_aCommentDate");
		String page=request.getParameter("page");
		System.out.println(page);
		HttpSession session=request.getSession();
		if(StringUtil.isEmpty(page)){
			page="1";
			session.setAttribute("s_bCommentDate", bDate);
			session.setAttribute("s_aCommentDate", aDate);
		}else{
			bDate=(String) session.getAttribute("s_bCommentDate");
			aDate=(String) session.getAttribute("s_aCommentDate");
		}
		Comment comm=new Comment();
		int total = 0 ;
		total = commentService.CommentCounts(comm.getNewsid() , aDate, bDate);
		System.out.println(total);
		String pageCode=PageUtil.getPagation(request.getContextPath()+"/commentBackList.action", total, Integer.parseInt(page), 10);
		PageBean pageBean=new PageBean(Integer.parseInt(page),10);
		List<Comment> CommentBackList=commentService.CommentList(comm.getNewsid() , pageBean.getStart() ,pageBean.getPageSize(),bDate,aDate);
		request.setAttribute("pageCode", pageCode);
		request.setAttribute("CommentBackList", CommentBackList);
		request.setAttribute("navCode", NavUtil.genNewsManageNavigation("评论管理", "评论维护"));
		request.setAttribute("mainPage", "/background/comment/commentList.jsp");
		return "/background/mainTemp";
	}
	
	@RequestMapping(value = "/commentDelete")
	public void commentDelete(HttpServletRequest request , HttpServletResponse response , Model model) throws Exception{
		String commentIds=request.getParameter("commentIds");
		JSONObject result=new JSONObject();
		int delNums=commentService.commentDelete(commentIds);
		if(delNums>0){
			result.put("success", true);
			result.put("delNums", delNums);
		}else{
			result.put("errorMsg", "删除失败");
		}
		ResponseUtil.write(result, response);
	}
	
	@RequestMapping(value = "/commentSave" , method = RequestMethod.POST)
	public String commentSave(HttpServletRequest request , HttpServletResponse response , RedirectAttributes redirectAttributes) throws NumberFormatException, ParseException{
		String newsId=request.getParameter("newsId");
		String content=request.getParameter("content");
		String userIP=request.getRemoteAddr();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		Comment comment=new Comment(Integer.parseInt(newsId), content, userIP, format.parse(date));
		commentService.insert(comment);
		redirectAttributes.addAttribute("newsId",newsId);
		return "redirect:/newsShow.action";
	}
}
