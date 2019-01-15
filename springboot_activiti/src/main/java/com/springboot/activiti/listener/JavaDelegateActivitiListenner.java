package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.activiti.service.ActivitiService;


@Service
public class JavaDelegateActivitiListenner implements JavaDelegate{

	@Autowired
	private ActivitiService activitiService;
	@Override
	public void execute(DelegateExecution execution) {
		// TODO Auto-generated method stub
		
	}

}
