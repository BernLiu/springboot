package com.springboot.activiti.web;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.activiti.service.ActivitiService;

public class MyController {

	@Autowired
	private ActivitiService myService;

	@RequestMapping(value = "/startprocess/{message}")
	public String startProcessInstance(@PathVariable("message") String message, @RequestParam String assignee) {
		return myService.startProcess(message, assignee);
	}

	@RequestMapping(value = "/tasks/{assignee}")
	public String getTasks(@PathVariable("assignee") String assignee) {
		List<Task> tasks = myService.getTasks(assignee);
		return tasks.toString();
	}

	@RequestMapping(value = "/completetask")
	public String completeTask(@RequestParam String id) {
		myService.completeTask(id);
		return "Task with id " + id + " has been completed!";
	}
}
