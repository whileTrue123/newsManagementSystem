package com.zhoujie.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhoujie.model.News;

/** 
* @author zhoujie
*/
public interface NewsService {
	public int deleteByPrimaryKey(int id);
	public int insert(News record);
	public int insertSelective(News record);
	public News selectByPrimaryKey(int newsid);
	public int updateByPrimaryKeySelective(News record);
	public int updateByPrimaryKeyWithBLOBs(News record);
	public int updateByPrimaryKey(News record);
	public List<News> selectByTypeId(int newstypeid);
	public int newsCounts(int newstypeid, String title , @Param("aDate")String aDate, @Param("bDate")String bDate);
	public List<News> newsList(int newstypeid, String title, int pageStart , int pageSize , @Param("bDate")String bDate , @Param("aDate")String aDate);
	public List<News> newestNewsList();
	public List<News> hotNewsList();//通过点击量来查看新闻
	public List<News> imageNewsList();//查找带图的新闻
	public List<News> headNewsList();//查找头条新闻
	public List<News> hotSpotNewsList();//查找热点新闻
	public List<News> oneSubList(Integer newstypeid);
	public void newsClickCount(Integer newsId);//获得点击次数
	public List<News> getUpAndDownPageId(Integer newsId);
}
