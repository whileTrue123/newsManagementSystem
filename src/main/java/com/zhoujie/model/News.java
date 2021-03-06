package com.zhoujie.model;

import java.util.Date;

public class News {
    /**
     * This field was generated by MyBatis Generator.
     *
     * @mbggenerated
     */
    private Integer newsid;
    private String title;
    private Date publishdate;
    private String author;
    private Integer typeid = -1;
    private Integer click;
    private int ishead;
    private int isimage;
    private String imagename;
    private int ishot;
    private String content;
    
    private String typeName;
    
    
    public News(int newsid, String title) {
		super();
		this.newsid = newsid;
		this.title = title;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}

    public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.newsId
     *
     * @return the value of t_news.newsId
     *
     * @mbggenerated
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.newsId
     *
     * @param newsid the value for t_news.newsId
     *
     * @mbggenerated
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.title
     *
     * @return the value of t_news.title
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.title
     *
     * @param title the value for t_news.title
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.publishDate
     *
     * @return the value of t_news.publishDate
     *
     * @mbggenerated
     */
    public Date getPublishdate() {
        return publishdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.publishDate
     *
     * @param publishdate the value for t_news.publishDate
     *
     * @mbggenerated
     */
    public void setPublishdate(Date publishdate) {
        this.publishdate = publishdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.author
     *
     * @return the value of t_news.author
     *
     * @mbggenerated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.author
     *
     * @param author the value for t_news.author
     *
     * @mbggenerated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.typeId
     *
     * @return the value of t_news.typeId
     *
     * @mbggenerated
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.typeId
     *
     * @param typeid the value for t_news.typeId
     *
     * @mbggenerated
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.click
     *
     * @return the value of t_news.click
     *
     * @mbggenerated
     */
    public Integer getClick() {
        return click;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.click
     *
     * @param click the value for t_news.click
     *
     * @mbggenerated
     */
    public void setClick(Integer click) {
        this.click = click;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.isHead
     *
     * @return the value of t_news.isHead
     *
     * @mbggenerated
     */
    public int getIshead() {
        return ishead;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.isHead
     *
     * @param i the value for t_news.isHead
     *
     * @mbggenerated
     */
    public void setIshead(int i) {
        this.ishead = i;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.isImage
     *
     * @return the value of t_news.isImage
     *
     * @mbggenerated
     */
    public int getIsimage() {
        return isimage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.isImage
     *
     * @param isimage the value for t_news.isImage
     *
     * @mbggenerated
     */
    public void setIsimage(int isimage) {
        this.isimage = isimage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.imageName
     *
     * @return the value of t_news.imageName
     *
     * @mbggenerated
     */
    public String getImagename() {
        return imagename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.imageName
     *
     * @param imagename the value for t_news.imageName
     *
     * @mbggenerated
     */
    public void setImagename(String imagename) {
        this.imagename = imagename == null ? null : imagename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.isHot
     *
     * @return the value of t_news.isHot
     *
     * @mbggenerated
     */
    public int getIshot() {
        return ishot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.isHot
     *
     * @param ishot the value for t_news.isHot
     *
     * @mbggenerated
     */
    public void setIshot(int ishot) {
        this.ishot = ishot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_news.content
     *
     * @return the value of t_news.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_news.content
     *
     * @param content the value for t_news.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}