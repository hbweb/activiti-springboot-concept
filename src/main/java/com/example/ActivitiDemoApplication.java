package com.example;


import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class ActivitiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitiDemoApplication.class, args);
	}
	
	@RestController
	
	public static class MyRestController{
		@Autowired
		private RuntimeService runtimeService;
		
//		@RequestMapping(value= "/start-process", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//		
//		
//		public void startMyProcess(){
//			runtimeService.startProcessInstanceByKey("CreateTask");
//			System.out.println("My current process " + runtimeService.createProcessInstanceQuery().count());
//		}
		
		/* Start Process by Submitting a New Task */
		@RequestMapping(value= "/start", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		
		
		public void startMyProcess(){
			runtimeService.startProcessInstanceByKey("CreateTask");
			System.out.println("My current process " + runtimeService.createProcessInstanceQuery().count());
		}
	}
}
