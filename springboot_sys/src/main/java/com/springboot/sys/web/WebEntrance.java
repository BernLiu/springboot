package com.springboot.sys.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.sys.service.SysMenuService;


@Controller
@RequestMapping("/api/sys")
public class WebEntrance {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@GetMapping("/gologin")
	private String goLogin() {
		return "/login";
	}
	
	@GetMapping("")
	private String getViewPathByReqUrl(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		String params = request.getParameter("reqUrlParam");
		String viewPathByReqUrl = sysMenuService.getViewPathByReqUrl(requestURI+"/getView/"+params);
		return viewPathByReqUrl;
	}
}
