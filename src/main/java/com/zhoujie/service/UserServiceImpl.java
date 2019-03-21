package com.zhoujie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhoujie.dao.UserDao;
import com.zhoujie.model.User;

/** 
* @author zhoujie
*/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired(required =false)
	public UserDao userDao;
	
	public User getUserById(int id) {
		return userDao.selectByPrimaryKey(id);
	}

}
