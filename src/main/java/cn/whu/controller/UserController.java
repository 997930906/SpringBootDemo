package cn.whu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.whu.entity.User;
import cn.whu.service.UserService;

@Controller
public class UserController {
	@Autowired
	 UserService userService;
	@ResponseBody
	@RequestMapping("/findByUserName")
	public User findByUserName(String username) {
		
		return userService.findByUserName(username);
	}
	
}
