package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class JavaExpressionActivitiListenner {

	public void expression(DelegateExecution execution) throws Exception {
		System.out.println("executionId：" + execution.getId() + " ActivitiListenner" + this.toString());
	}
}
