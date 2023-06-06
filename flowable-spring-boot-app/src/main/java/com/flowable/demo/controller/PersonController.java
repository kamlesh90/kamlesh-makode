package com.flowable.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flowable.demo.dto.TaskDto;
import com.flowable.demo.payloads.StartProcessRepresentation;
import com.flowable.demo.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@PostMapping(value = "/process")
	public void startProcessInstance(@RequestBody StartProcessRepresentation startProcess) {
		personService.startProcess(startProcess.getAssignee());
	}
	
	@GetMapping(value = "/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<TaskDto> getAllTasks(@RequestParam String assingee){
		
		List<Task> tasks = personService.getTasks(assingee);
		
		List<TaskDto> taskList = new ArrayList<>(); 
		
		for(Task task : tasks) {
			taskList.add(new TaskDto(task.getId(), task.getAssignee())); 
		}
		
		return taskList;
	}


}
