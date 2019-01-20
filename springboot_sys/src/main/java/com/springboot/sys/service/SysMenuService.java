package com.springboot.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.sys.mapper.SysMenuMapper;

@Service("SysMenuService")
public class SysMenuService{
	
	@Autowired
	private SysMenuMapper sysMenuRepository;

	public String getViewPathByReqUrl(String reqUrl) {
		
		return sysMenuRepository.getViewPathByReqUrl(reqUrl);
	}

}
