package com.zhoujie.model;

public class NewsType {
    public NewsType() {
		super();
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_newstype.newsTypeId
     *
     * @mbggenerated
     */
    private Integer newstypeid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_newstype.typeName
     *
     * @mbggenerated
     */
    private String typename;
    
    

    public NewsType(String typename) {
		super();
		this.typename = typename;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_newstype.newsTypeId
     *
     * @return the value of t_newstype.newsTypeId
     *
     * @mbggenerated
     */
    public Integer getNewstypeid() {
        return newstypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_newstype.newsTypeId
     *
     * @param newstypeid the value for t_newstype.newsTypeId
     *
     * @mbggenerated
     */
    public void setNewstypeid(Integer newstypeid) {
        this.newstypeid = newstypeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_newstype.typeName
     *
     * @return the value of t_newstype.typeName
     *
     * @mbggenerated
     */
    public String getTypename() {
        return typename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_newstype.typeName
     *
     * @param typename the value for t_newstype.typeName
     *
     * @mbggenerated
     */
    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

	@Override
	public String toString() {
		return "NewsType [newstypeid=" + newstypeid + ", typename=" + typename + "]";
	}
    
    
}