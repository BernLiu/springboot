package com.springboot.sys.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.sys.bean.UserEntity;
import com.springboot.sys.service.UserService;

@RestController
@RequestMapping("/apr/sys")
public class UserController {

	@Autowired
	private UserService<UserEntity> userService;
	
	
	
	@RequestMapping("/queryAll")
	public Map<String,Object> queryAll(){
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId("2");
		userEntity.setUsername("admin123");
		HashMap<String, Object> query = userService.queryForObject(userEntity);
		return query;
	}
}
