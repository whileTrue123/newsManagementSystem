package com.zhoujie.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhoujie.dao.NewsDao;
import com.zhoujie.model.News;
import com.zhoujie.service.NewsService;

/** 
* @author zhoujie
*/
@Service("newsService")
public class NewsServiceImpl implements NewsService {
	
	@Resource
	private NewsDao newsDao;

	@Override
	public int deleteByPrimaryKey(int id) {
		return newsDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(News record) {
		return newsDao.insert(record);
	}

	@Override
	public int insertSelective(News record) {
		return newsDao.insertSelective(record);
	}

	@Override
	public News selectByPrimaryKey(int newsid) {
		return newsDao.selectByPrimaryKey(newsid);
	}

	@Override
	public int updateByPrimaryKeySelective(News record) {
		return newsDao.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeyWithBLOBs(News record) {
		return newsDao.updateByPrimaryKeyWithBLOBs(record);
	}

	@Override
	public int updateByPrimaryKey(News record) {
		return newsDao.updateByPrimaryKey(record);
	}

	@Override
	public List<News> selectByTypeId(int newstypeid) {
		return newsDao.selectByTypeId(newstypeid);
	}

	@Override
	public int newsCounts(int newstypeid, String title , String aDate, String bDate) {
		return newsDao.newsCounts(newstypeid , title , aDate, bDate);
	}

	@Override
	public List<News> newsList(int newstypeid, String title , int pageStart , int pageSize, String bDate, String aDate) {
		return newsDao.newsList(newstypeid , title , pageStart , pageSize, bDate, aDate);
	}

	@Override
	public List<News> newestNewsList() {
		return newsDao.newestNewsList();
	}

	@Override
	public List<News> hotNewsList() {
		return newsDao.hotNewsList();
	}

	@Override
	public List<News> imageNewsList() {
		return newsDao.imageNewsList();
	}

	@Override
	public List<News> headNewsList() {
		return newsDao.headNewsList();
	}

	@Override
	public List<News> hotSpotNewsList() {
		return newsDao.hotSpotNewsList();
	}

	@Override
	public List<News> oneSubList(Integer newstypeid) {
		return newsDao.oneSubList(newstypeid);
	}

	@Override
	public void newsClickCount(Integer newsId) {
		newsDao.newsClickCount(newsId);
	}

	@Override
	public List<News> getUpAndDownPageId(Integer newsId) {
		List<News> upAndDownPage=new ArrayList<News>();
		News downPageId = newsDao.getDownPageId(newsId);
		if(downPageId != null){
			upAndDownPage.add(new News(downPageId.getNewsid(),downPageId.getTitle()));
		}else{
			upAndDownPage.add(new News(-1,""));
		}
		News upPageId = newsDao.getUpPageId(newsId);
		if(upPageId != null){
			upAndDownPage.add(new News(upPageId.getNewsid(),upPageId.getTitle()));
		}else{
			upAndDownPage.add(new News(-1,""));
		}
		return upAndDownPage;
	}

}
