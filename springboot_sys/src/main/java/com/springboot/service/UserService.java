package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.bean.UserEntity;
import com.springboot.dao.UserMapper;

public class UserService {
	
	@Autowired
	private UserMapper userMapper;

	public UserEntity login(String username, String password) {
		UserEntity ueEntity = new UserEntity();
		ueEntity.setUsername(username);
		ueEntity.setPassword(password);
		return userMapper.userLogin(ueEntity);
	}

	
	public UserEntity findUserById(Integer id) {

		return userMapper.findOne(id);
	}
}
