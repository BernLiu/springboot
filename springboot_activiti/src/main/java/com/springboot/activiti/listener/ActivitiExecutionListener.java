package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivitiExecutionListener implements ExecutionListener{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(GlobalActivitiEventListener.class);

	
	private Expression clazz;
	
	@Override
	public void notify(DelegateExecution execution) {
        String value = (String) clazz.getValue(execution);
        logger.info("ActivitiExecutionListener>>>>>>>>>>>>>{}"+value);
	}

}
