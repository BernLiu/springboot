package com.springboot.activiti.listener;

import java.io.Serializable;
import java.util.List;

import org.activiti.engine.delegate.event.ActivitiEvent;
import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.impl.ActivitiEntityEventImpl;
import org.activiti.engine.impl.persistence.entity.TaskEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.springboot.activiti.dao.EventListener;
import com.springboot.activiti.enums.EventType;
import com.springboot.activiti.eventlistener.EventListenerManager;

@Component
public class GlobalActivitiEventListener implements ActivitiEventListener, Serializable {

	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(GlobalActivitiEventListener.class);

	@Override
	public void onEvent(ActivitiEvent event) {
		
		List<EventListener> eventListeners = EventListenerManager.getInstance().getEventListeners(EventType.TASK_CREATED);
		if(!CollectionUtils.isEmpty(eventListeners)) {
			 ActivitiEntityEventImpl enitiyEventImpl = (ActivitiEntityEventImpl)event;
			 TaskEntity entity = (TaskEntity)enitiyEventImpl.getEntity();
			 String processInstanceId = event.getProcessInstanceId();
			 String processDefinitionId = event.getProcessDefinitionId();
			 logger.info("processInstanceId >>>>>>>>>>>> {}"+processInstanceId);
			 logger.info("processDefinitionId>>>>>>>>>>>>{}"+processDefinitionId);
		} 
	}

	@Override
	public boolean isFailOnException() {

		return false;
	}

}
