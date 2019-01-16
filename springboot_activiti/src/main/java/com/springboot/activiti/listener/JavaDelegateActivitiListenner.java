package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;


@Component
public class JavaDelegateActivitiListenner implements JavaDelegate{
	
	private Expression clazz;
	
	@Override
	public void execute(DelegateExecution execution) {
		System.out.println("JavaDelegateActivitiListenner >>>>>>>>"+execution.getEventName());
		Object variable = execution.getVariable("clazz");
		System.out.println("variable>>>>>>>>>"+variable);
	}

}
