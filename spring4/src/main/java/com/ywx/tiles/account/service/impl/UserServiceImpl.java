package com.ywx.tiles.account.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ywx.tiles.account.dao.UserDao;
import com.ywx.tiles.account.entity.User;
import com.ywx.tiles.account.service.UserService;

@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	public List<User> getUserList(){
		return userDao.getAll(); 
	}
	
}
