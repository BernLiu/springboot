package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.activiti.service.ActivitiService;

public class ActivitiListenner implements TaskListener,ExecutionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ActivitiService activitiService;

	@Override
	public void notify(DelegateExecution execution) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notify(DelegateTask delegateTask) {
		// TODO Auto-generated method stub
		
	}

}
