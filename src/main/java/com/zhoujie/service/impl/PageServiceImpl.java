package com.zhoujie.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zhoujie.model.News;
import com.zhoujie.service.PageService;

/** 
* @author zhoujie
*/
@Service("pageService")
public class PageServiceImpl implements PageService {

	@Override
	public String genUpAndDownPageCode(List<News> upAndDownPage) {
		News upNews=upAndDownPage.get(0);
		News downNews=upAndDownPage.get(1);
		StringBuffer pageCode=new StringBuffer();
		if(upNews.getNewsid()==-1){
			pageCode.append("<p>上一篇：没有了</p>");
		}else{
			pageCode.append("<p>上一篇：<a href='newsShow.action?newsId="+upNews.getNewsid()+"'>"+upNews.getTitle()+"</a></p>");
		}
		if(downNews.getNewsid()==-1){
			pageCode.append("<p>下一篇：没有了</p>");
		}else{
			pageCode.append("<p>下一篇：<a href='newsShow.action?newsId="+downNews.getNewsid()+"'>"+downNews.getTitle()+"</a></p>");
		}
		System.out.println(pageCode.toString());
		return pageCode.toString();
	}

}
