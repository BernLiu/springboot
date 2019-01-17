package com.springboot.activiti.listener;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ActivitiTaskListener implements TaskListener{

	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(GlobalActivitiEventListener.class);


	@Override
	public void notify(DelegateTask delegateTask) {
		String eventName = delegateTask.getEventName();
		if ("create".endsWith(eventName)) {
			logger.info("ActivitiTaskListener >>>>>>> delegateTask >>>>>>>>>>>>create ");
		}else if ("assignment".endsWith(eventName)) {
			logger.info("ActivitiTaskListener >>>>>>> delegateTask >>>>>>>>>>>>assignment ");
		}else if ("complete".endsWith(eventName)) {
			logger.info("ActivitiTaskListener >>>>>>> delegateTask >>>>>>>>>>>>complete ");
		}else if ("delete".endsWith(eventName)) {
			logger.info("ActivitiTaskListener >>>>>>> delegateTask >>>>>>>>>>>>delete ");
		}
	}

}
