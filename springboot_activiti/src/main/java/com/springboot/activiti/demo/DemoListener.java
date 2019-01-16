package com.springboot.activiti.demo;

import com.springboot.activiti.dao.Delegate;

public class DemoListener implements Delegate{

	@Override
	public String execute() {
		System.out.println("DemoListener >>>>>>>>> ");
		return "DemoListener 调用成功";
	}

}
