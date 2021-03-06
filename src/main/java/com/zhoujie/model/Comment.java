package com.zhoujie.model;

import java.util.Date;

public class Comment {
    public Comment(Integer newsid, String content, String userip, Date commentdate) {
		super();
		this.newsid = newsid;
		this.content = content;
		this.userip = userip;
		this.commentdate = commentdate;
	}

	/**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_comment.commentId
     *
     * @mbggenerated
     */
    private Integer commentid;
    private Integer newsid = -1;
    private String content;
    private String userip;
    private Date commentdate;
    private String newsTitle;

    public Comment(int newsId, String content, String userIP) {
		super();
		this.newsid = newsId;
		this.content = content;
		this.userip = userIP;
	}
    
    
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	/**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.commentId
     *
     * @return the value of t_comment.commentId
     *
     * @mbggenerated
     */
    public Integer getCommentid() {
        return commentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.commentId
     *
     * @param commentid the value for t_comment.commentId
     *
     * @mbggenerated
     */
    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.newsId
     *
     * @return the value of t_comment.newsId
     *
     * @mbggenerated
     */
    public Integer getNewsid() {
        return newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.newsId
     *
     * @param newsid the value for t_comment.newsId
     *
     * @mbggenerated
     */
    public void setNewsid(Integer newsid) {
        this.newsid = newsid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.content
     *
     * @return the value of t_comment.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.content
     *
     * @param content the value for t_comment.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.userIP
     *
     * @return the value of t_comment.userIP
     *
     * @mbggenerated
     */
    public String getUserip() {
        return userip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.userIP
     *
     * @param userip the value for t_comment.userIP
     *
     * @mbggenerated
     */
    public void setUserip(String userip) {
        this.userip = userip == null ? null : userip.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_comment.commentDate
     *
     * @return the value of t_comment.commentDate
     *
     * @mbggenerated
     */
    public Date getCommentdate() {
        return commentdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_comment.commentDate
     *
     * @param commentdate the value for t_comment.commentDate
     *
     * @mbggenerated
     */
    public void setCommentdate(Date commentdate) {
        this.commentdate = commentdate;
    }
}