package com.zhoujie.service;

import com.zhoujie.model.User;

/** 
* @author zhoujie
*/
public interface UserService {
	public User getUserById(int id);
	public User userLogin(String userName , String password); //ÓÃ»§µÇÂ¼
}
