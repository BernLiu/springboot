package com.springboot.token.build;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.springboot.bean.UserEntity;

@Component
public class TokenService {

	public String getToken(UserEntity user) {
		String token ="";
		token = JWT.create().withAudience(String.valueOf(user.getId()))
				    .sign(Algorithm.HMAC256(user.getPassword()));
		return token;
	}
}
