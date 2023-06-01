package com.flowable.flowboot.integ.controller;

import java.util.ArrayList;
import java.util.List;

import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.flowboot.integ.dtos.TaskDto;
import com.flowable.flowboot.integ.service.OneTaskService;

@RestController
public class OneTaskController {
	
	@Autowired
	private OneTaskService oneTaskService;
	
	@PostMapping("/process")
	public void startProcessInstance() {
		oneTaskService.startProcess();
	}
	
	@GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TaskDto> getTasks(@RequestParam String assignee) {
		List<Task> tasks = oneTaskService.getTasks(assignee);
		tasks.stream().forEach(System.out::println);
		List<TaskDto> taskDtos = new ArrayList<>();
		
		//taskDtos =  (List<TaskDto>) tasks.stream().map(Task -> mapToTaskDtos(Task));
		for(Task task : tasks) {
			taskDtos.add(new TaskDto(task.getId(), task.getName())); 
		}
		return taskDtos;
	}
/*
	private TaskDto mapToTaskDtos(Task task) { 
		TaskDto taskDto = new TaskDto();
		taskDto.setId(task.getId());
		taskDto.setName(task.getName()); 
		
		return taskDto;
	}
*/	
}
