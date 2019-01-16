package com.springboot.activiti.listener;

import java.io.Serializable;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.springframework.stereotype.Component;

@Component
public class GlobalActivitiEventListener implements ActivitiEventListener,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void onEvent(ActivitiEvent event) {
		System.out.println("event  >>>>>>"+event.getProcessInstanceId());
		
	}

	@Override
	public boolean isFailOnException() {

		return false;
	}

}
