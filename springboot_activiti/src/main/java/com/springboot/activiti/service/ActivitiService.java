package com.springboot.activiti.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivitiService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	public String startProcess(String message, String assignee) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", message);
		variables.put("person", assignee);

		runtimeService.startProcessInstanceByMessage(message, variables);

		return "Process started";
	}
	
	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

}
