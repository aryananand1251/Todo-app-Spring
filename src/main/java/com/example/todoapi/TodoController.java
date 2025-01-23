package com.example.todoapi;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/todos")
    public  List<Todo> getTodos(){
        return  todolist;
    }


        @PostMapping("/todos")
        @ResponseStatus(HttpStatus.CREATED)
        public Todo createTodo(@RequestBody Todo newTodo){
        todolist.add(newTodo);
        return newTodo;
        }
}
