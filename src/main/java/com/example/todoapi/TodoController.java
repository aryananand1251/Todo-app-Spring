package com.example.todoapi;


import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {

    private static List<Todo> todolist;

    public TodoController(){
        todolist= new ArrayList<>();
        todolist.add(new Todo(1,false,"Todo 1",1));
        todolist.add(new Todo(2,true,"Todo 2",2));
    }

}
