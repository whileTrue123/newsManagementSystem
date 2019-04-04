package com.zhoujie.service;

import java.util.List;

import com.zhoujie.model.NewsType;

/** 
* @author zhoujie
*/
public interface NewsTypeService {
	public NewsType selectByPrimaryKey(int newstypeid);
	public int updateByPrimaryKey(NewsType record);
	public int insertSelective(NewsType record);
	public List<NewsType> getTypeList();
	public int deleteByPrimaryKey(int newstypeid);
}
