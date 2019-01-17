package com.springboot.activiti.listener;

import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.activiti.dao.Delegate;
import com.springboot.activiti.util.ReflectionUtils;
import com.springboot.activiti.vo.WorkItemVO;


@Component
public class JavaDelegateActivitiListenner implements JavaDelegate{
	
	private Expression clazz;
	
	private static Map<String,Delegate> instances = new HashMap<>();
	
	private Logger logger = LoggerFactory.getLogger(JavaDelegateActivitiListenner.class);
	
	@Autowired
	private RepositoryService repositoryService;
	
	
	@Override
	public void execute(DelegateExecution execution) {
		String processDefinitionId = execution.getProcessDefinitionId();
		String clazzParam = (String) clazz.getValue(execution);
		logger.info("JavaDelegateActivitiListenner : clazzParam >>>>>>>>>>>>>>{}"+clazzParam);	
		try {
			Class<?> clazzInstance = ReflectionUtils.forName(clazzParam);
			if(Delegate.class.isAssignableFrom(clazzInstance)) {
				Delegate delegate = (Delegate) clazzInstance.newInstance();
				delegate.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
		processDefinitionQuery.processDefinitionId(processDefinitionId);
		ProcessDefinition processDefinition = processDefinitionQuery.singleResult();
		WorkItemVO wv = new WorkItemVO();
		wv.setWorkflowDefName(processDefinition.getKey());
		wv.setWorkflowInstName(processDefinition.getName());
		wv.setWorkItemName(execution.getCurrentActivityId());
		wv.setWorkItemId(Long.valueOf(execution.getCurrentActivityId()));
		Map<String, Object> variables = execution.getVariables();
		wv.setVariables(variables);
		}

	private Delegate getInstance(String clazz) {
		synchronized (instances) {
			return instances.get(clazz);
		}
	}
	
	private void setInstance(String clazz,Delegate delegate) {
		synchronized(instances) {
			instances.put(clazz, delegate);
		}
	}
}
