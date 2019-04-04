package com.zhoujie.service;

import java.util.List;

import com.zhoujie.model.Comment;

/** 
* @author zhoujie
*/
public interface CommentService {
	public int insert(Comment record);
	
	public int CommentCounts(Integer newsid, String aDate, String bDate);

	public List<Comment> CommentList(Integer newsid, int start, int pageSize, String bDate, String aDate);

	public int commentDelete(String commentIds);

}
