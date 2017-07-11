package com.ywx.tiles.account.dao.impl;

import org.springframework.stereotype.Component;

import com.ywx.core.orm.hibernate.HibernateDao;
import com.ywx.tiles.account.dao.UserDao;
import com.ywx.tiles.account.entity.User;

@Component
public class UserDaoImpl extends HibernateDao<User> implements UserDao{
	
}
