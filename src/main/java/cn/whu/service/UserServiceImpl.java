package cn.whu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.whu.entity.User;
import cn.whu.mapper.UserMapper;

@Service("UserserviceImpl")
public class UserServiceImpl implements UserService{

	/*@Autowired
	 UserMapper userMapper;
	public User findByUserName(String username) {
		return userMapper.findByName(username);
	}*/

	public void setting(){

		System.out.println("setting......service1111111");
	}

}
