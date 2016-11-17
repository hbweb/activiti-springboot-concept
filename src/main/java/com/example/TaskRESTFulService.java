package com.example;

import java.util.Collections;
import java.util.Map;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class TaskRESTFulService{
	@Autowired
	private RuntimeService runtimeService;
	
	@Autowired
    private TaskRepository taskRepository;
	
	@ResponseStatus(value = HttpStatus.OK)
	@RequestMapping(value= "/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	
	
	public void startMyProcess(@RequestBody Map<String, String> data){
		
		Task taskObj = new Task(data.get("name"), data.get("description"));
		taskRepository.save(taskObj);
		
		
		Map<String, Object> vars = Collections.<String, Object>singletonMap("task", taskObj);
	    runtimeService.startProcessInstanceByKey("CreateTask", vars);
		
		System.out.println("My current process " + runtimeService.createProcessInstanceQuery().count());
	}
}