package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JavaExpressionActivitiListenner {
	
	private Logger logger = LoggerFactory.getLogger(JavaExpressionActivitiListenner.class);

	public void expression(DelegateExecution execution) throws Exception {
		logger.info("executionId >>>>>>> {}  ActivitiListenner>>>>>>>>>>{}"+execution.getId()+execution.getEventName());
	}
}
