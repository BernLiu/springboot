package com.springboot.activiti.demo;

import com.springboot.activiti.dao.Delegate;

public class DemoListener implements Delegate{

	@Override
	public void execute() {
		System.out.println("DemoListener >>>>>>>>> ");
	}

}
