package com.zhoujie.dao;

import com.zhoujie.model.NewsType;

public interface NewsTypeDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_newstype
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer newstypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_newstype
     *
     * @mbggenerated
     */
    int insert(NewsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_newstype
     *
     * @mbggenerated
     */
    int insertSelective(NewsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_newstype
     *
     * @mbggenerated
     */
    NewsType selectByPrimaryKey(Integer newstypeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_newstype
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(NewsType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_newstype
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(NewsType record);
}