package com.zhoujie.dao;

import com.zhoujie.model.News;

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
}