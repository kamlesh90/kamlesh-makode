package com.flowable.flowboot.integ.service;

import java.util.List;

import javax.transaction.Transactional;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OneTaskService {
	
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	
	@Transactional
	public void startProcess() {
		runtimeService.startProcessInstanceByKey("oneTask");
		System.out.println("process started...");
	}
	@Transactional
	public List<Task> getTasks(String assignee){
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}
}
