package com.flowable.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowable.demo.model.Person;
import com.flowable.demo.repository.PersonRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PersonService {
	
	@Autowired(required = true)
	private RuntimeService runtimeService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private PersonRepository personRepository;
	
	public void startProcess(String assignee) {
		Person person = personRepository.findByUserName(assignee);
		Map<String, Object> variables = new HashMap<>();
		variables.put("person", person);
		//start the process runtimeService.startProcessInstanceByKey(processDefinitionKey, variables);processDefinitionKey key of process definition, cannot be null.variables the variables to pass, can be null.
		runtimeService.startProcessInstanceByKey("", variables);
	}
	
	public List<Task> getTasks(String assignee){
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}
	
	public void createUser() {
		if(personRepository.findAll().size()==0) {
			personRepository.save(new Person("ajaysharma", "ajay", "sharma", new Date()));
			personRepository.save(new Person("abcxyz", "abc", "xyz", new Date())); 
		}
	}
	
}
