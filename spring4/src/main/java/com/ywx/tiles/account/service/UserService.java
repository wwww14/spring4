package com.ywx.tiles.account.service;

import java.util.List;
import com.ywx.tiles.account.entity.User;

public interface UserService {

	/**
	 * 获取所有用户.
	 * 
	 * @return
	 */
	List<User> getUserList();

}
