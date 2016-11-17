package com.example;


import org.springframework.stereotype.Component;

@Component
public class TaskService {

    public void createATask() {
        System.out.println("User submit 'create a new task' form  ...");
    }

}
