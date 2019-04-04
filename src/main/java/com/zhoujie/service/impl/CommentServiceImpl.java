package com.zhoujie.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhoujie.dao.CommentDao;
import com.zhoujie.model.Comment;
import com.zhoujie.service.CommentService;

/** 
* @author zhoujie
*/
@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource
	private CommentDao commentDao; 
	@Override
	public int CommentCounts(Integer newsid, String aDate, String bDate) {
		return commentDao.CommentCounts(newsid, aDate, bDate);
	}

	@Override
	public List<Comment> CommentList(Integer newsid, int start, int pageSize, String bDate, String aDate) {
		return commentDao.CommentList(newsid, start, pageSize, bDate, aDate);
	}

	@Override
	public int commentDelete(String commentIds) {
		return commentDao.commentDelete(commentIds);
	}

	@Override
	public int insert(Comment record) {
		return commentDao.insert(record);
	}

}
