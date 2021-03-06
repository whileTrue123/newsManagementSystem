package com.zhoujie.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhoujie.dao.UserDao;
import com.zhoujie.model.User;
import com.zhoujie.service.UserService;

/** 
* @author zhoujie
*/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	@Override
	public User getUserById(int id) {
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public User userLogin(User user) {
		return userDao.loginByIdAndPass(user);
	}

}
