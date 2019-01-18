package com.springboot.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.bean.UserEntity;
import com.springboot.service.UserService;
import com.springboot.token.build.TokenService;
import com.springboot.util.RedisUtil;

@RestController
@RequestMapping("/api/sys")
public class UserWeb {

	@Autowired
	private UserService userService;
	@Autowired
	private TokenService tokenService;
	@Autowired
	private RedisUtil redisUtil;
	@Autowired
	private HttpServletResponse response;
	
	/**
	  *   登陆不需要验证token
	 * @param jsonObject
	 * @return
	 */
	@GetMapping("/login")
	private Map<String, Object> doLogin(HttpServletRequest request) {
		Map<String, Object> map =new HashMap<String, Object>();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserEntity loginUser = userService.login(username, password);
		if(loginUser == null) {
			map.put("SUCCESS", false);
			map.put("MESSAGE", "登录失败,用户名或者密码错误");
			return map;
		}else {
			 String token = tokenService.getToken(loginUser);
			 redisUtil.set("token", token,1000*60*10);
			 redisUtil.set("loginEntity", loginUser,1000*60*10);
			 response.setHeader("Access-Control-Expose-Headers","Cache-Control,Content-Type,Expires,Pragma,Content-Language,Last-Modified,token");
			 response.setHeader("token", token); //设置响应头	
			 map.put("SUCCESS", true);		
			 return map;
		}
	}
	
	@RequestMapping("/getMessage")
    private Map<String, Object> getMessage(HttpServletRequest request){
		Map<String, Object> map =new HashMap<String, Object>();
		String redisToken = String.valueOf(redisUtil.get("token"));
		String token = request.getHeader("X_token");
		if(redisToken==null || "".equals(redisToken) || token==null || "".equals(token)) {
			map.put("SUCCESS", false);
			map.put("MESSAGE", "请求超时,请重新登陆");
			 return map;
		}
		if(redisToken.equals(token)) {
			String parameter = request.getParameter("message");
			map.put("SUCCESS", true);
			map.put("MESSAGE", parameter);
	        return map;
		}
		map.put("SUCCESS", false);
		map.put("MESSAGE", "请求失败");
		return map;
    }
    
    @RequestMapping("/logout")
    private Map<String, Object> logout(HttpServletRequest request){
    	Map<String, Object> map =new HashMap<String, Object>();
    	boolean hasKey = redisUtil.hasKey("token");
    	if(hasKey) {
    		redisUtil.del("token");
    	}
    	map.put("SUCCESS", true);
		map.put("MESSAGE", "成功退出");
		return map;
    }
}
