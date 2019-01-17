package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class ActivitiTaskListener implements TaskListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		String eventName = delegateTask.getEventName();
		if ("create".endsWith(eventName)) {
		System.out.println("create=========");
		}else if ("assignment".endsWith(eventName)) {
		System.out.println("assignment========");
		}else if ("complete".endsWith(eventName)) {
		System.out.println("complete===========");
		}else if ("delete".endsWith(eventName)) {
		System.out.println("delete=============");
		}
	}

}
