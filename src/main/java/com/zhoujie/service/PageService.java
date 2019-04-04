package com.zhoujie.service;

import java.util.List;

import com.zhoujie.model.News;

/** 
* @author zhoujie
*/
public interface PageService {
	public String genUpAndDownPageCode(List<News> upAndDownPage);
}
