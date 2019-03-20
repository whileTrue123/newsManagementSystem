package com.zhoujie.service;

import com.zhoujie.dao.UserDao;
import com.zhoujie.model.User;

/** 
* @author zhoujie
*/

public class UserService implements UserServiceImpl {

	public UserDao userDao;
	
	public User getUserById(int id) {
		User user = userDao.selectByPrimaryKey(id);
		return user;
	}

}
