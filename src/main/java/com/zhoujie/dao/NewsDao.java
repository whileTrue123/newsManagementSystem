package com.zhoujie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhoujie.model.News;
import com.zhoujie.model.PageBean;

public interface NewsDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer newsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    int insert(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    int insertSelective(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    News selectByPrimaryKey(Integer newsid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(News record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_news
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(News record);
    
    List<News> selectByTypeId(Integer newstypeid);

	int newsCounts(@Param("newstypeid")Integer newstypeid, @Param("title")String title , @Param("aDate")String aDate, @Param("bDate")String bDate);
	
	List<News> newsList(@Param("newstypeid")Integer newstypeid, @Param("title")String title , @Param("pageStart")int pageStart , @Param("pageSize")int pageSize , @Param("bDate")String bDate , @Param("aDate")String aDate);
	
	List<News> newestNewsList();
	
	List<News> hotNewsList();
}