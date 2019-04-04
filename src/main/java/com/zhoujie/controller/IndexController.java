package com.zhoujie.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhoujie.model.News;
import com.zhoujie.model.NewsType;
import com.zhoujie.service.NewsService;
import com.zhoujie.service.NewsTypeService;
import com.zhoujie.utils.StringUtil;

/** 
* @author zhoujie
*/
@Controller
public class IndexController {
	@Resource
	private NewsService newsService;
	@Resource
	private NewsTypeService newstypeService;
	
	@RequestMapping(value = "/index")
	public String Index(HttpServletRequest request, HttpServletResponse response){
		List<News> imageNewsList=newsService.imageNewsList();
		request.setAttribute("imageNewsList", imageNewsList);
		
		List<News> headNewsList=newsService.headNewsList();
		News headNews=headNewsList.get(0);
		headNews.setContent(StringUtil.Html2Text(headNews.getContent()));
		request.setAttribute("headNews", headNews);
		
		List<News> newestNewsList = newsService.newestNewsList();
		request.setAttribute("newestNewsList", newestNewsList);
		
		List<News> hotSpotNewsList=newsService.hotSpotNewsList();
		request.setAttribute("hotSpotNewsList", hotSpotNewsList);
		
		List<List<News>> allIndexNewsList=new ArrayList<List<News>>();
		List<NewsType> newsTypeList=newstypeService.getTypeList();
		if(newsTypeList!=null && newsTypeList.size()!=0){
			for(int i=0;i<newsTypeList.size();i++){
				NewsType newsType=newsTypeList.get(i);
				List<News> oneSubList=newsService.oneSubList(newsType.getNewstypeid());
				allIndexNewsList.add(oneSubList);
			}
		}
		request.setAttribute("allIndexNewsList", allIndexNewsList);
		return "index";
	}
}
