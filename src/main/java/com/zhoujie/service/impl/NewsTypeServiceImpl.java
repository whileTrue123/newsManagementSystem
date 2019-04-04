package com.zhoujie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhoujie.dao.NewsTypeDao;
import com.zhoujie.model.NewsType;
import com.zhoujie.service.NewsTypeService;

/** 
* @author zhoujie
*/
@Service("newsTypeService")
public class NewsTypeServiceImpl implements NewsTypeService {

	@Resource
	private NewsTypeDao newsTypeDao;
	@Override
	public NewsType selectByPrimaryKey(int newstypeid) {
		return newsTypeDao.selectByPrimaryKey(newstypeid);
	}

	@Override
	public int updateByPrimaryKey(NewsType record) {
		return newsTypeDao.updateByPrimaryKey(record);
	}

	@Override
	public int insertSelective(NewsType record) {
		return newsTypeDao.insertSelective(record);
	}

	@Override
	public List<NewsType> getTypeList() {
		return newsTypeDao.getTypeList();
	}

	@Override
	public int deleteByPrimaryKey(int newstypeid) {
		return newsTypeDao.deleteByPrimaryKey(newstypeid);
	}

}
