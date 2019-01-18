package com.springboot.dao;

import com.springboot.bean.UserEntity;

public interface UserMapper {

	UserEntity userLogin(UserEntity userEntity);

	UserEntity findOne(Integer id);

	UserEntity selectByName(String username);
}
