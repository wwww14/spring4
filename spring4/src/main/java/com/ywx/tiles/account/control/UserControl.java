package com.ywx.tiles.account.control;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ywx.tiles.account.entity.User;
import com.ywx.tiles.account.service.UserService;
import com.ywx.tiles.common.support.CrudBaseSupport;

@Controller
@RequestMapping("/user")
public class UserControl extends CrudBaseSupport {

	/** 模块前缀 **/
	private static final String PREFIX = "user/";

	@Autowired
	private UserService userService;

	@RequestMapping("/userList")
	public String list(Map<String, Object> map) {
		List<User> userList = userService.getUserList();
		map.put("user", userList);
		return PREFIX + LIST;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(User user, Map<String, Object> map) {
//		System.out.println("用户登录。。。" + user.getLoginName());
//		List<User> userList = userService.getUserList();
//		map.put("user", userList);
		System.out.println("---登录---");
		return "frame/" + "index";
	}

}
