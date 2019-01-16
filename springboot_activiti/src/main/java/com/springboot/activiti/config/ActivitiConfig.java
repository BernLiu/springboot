package com.springboot.activiti.config;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.activiti.listener.GlobalActivitiEventListener;


@Component
public class ActivitiConfig implements ProcessEngineConfigurationConfigurer  {
	
	@Autowired
	private GlobalActivitiEventListener globalActivitiEventListener;

	@Override
	public void configure(SpringProcessEngineConfiguration processEngineConfiguration) {
			List<ActivitiEventListener> activitiEventListener = new ArrayList<ActivitiEventListener>();
			activitiEventListener.add(globalActivitiEventListener);
			processEngineConfiguration.setEventListeners(activitiEventListener);
	}

}
