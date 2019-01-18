package com.springboot.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.devtools.remote.server.HandlerMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.springboot.bean.UserEntity;
import com.springboot.service.UserService;
import com.springboot.token.aiinterface.PassToken;
import com.springboot.token.aiinterface.UserLoginToken;




public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String token = request.getHeader("token");
		// 不过不是映射方法,直接通过
		if (!(handler instanceof HandlerMapper)) {
			return true;
		}
		HandlerMethod handletMethod = (HandlerMethod) handler;

		Method method = handletMethod.getMethod();
		// 检查是否有passtoken注释,有则直接跳过验证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		// 检查有没有需要用户权限的注解
		if (method.isAnnotationPresent(UserLoginToken.class)) {
			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
			if (userLoginToken.required()) {
				// 执行认证
				if (token == null) {
					throw new RuntimeException("无Token,请重新登陆");
				}
				// 获取token中的id Integer id;
				String userId;
				try {
					userId = JWT.decode(token).getAudience().get(0);
				} catch (JWTDecodeException j) {
					throw new RuntimeException("401");
				}
				UserEntity userEntity = userService.findUserById(Integer.valueOf(userId));
				if (userEntity == null) {
					throw new RuntimeException("用户不存在,请重新登陆");
				}
				// 验证token
				JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(userEntity.getPassword())).build();
				try {
					jwtVerifier.verify(token);
				} catch (JWTDecodeException j) {
					throw new RuntimeException("401");
				}
				return true;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
