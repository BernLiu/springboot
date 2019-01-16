package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;

public class ActivitiExecutionListener implements ExecutionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void notify(DelegateExecution execution) {
		System.out.println("ActivitiExecutionListener >>>>>>>>>>"+execution.getCurrentActivityId());
		System.out.println("#####################################################################");
		 // 工作流对象
        ExecutionEntity event = (ExecutionEntity)execution;
	}

}
