package com.example.todoapi;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    private static List<Todo> todolist;
    private static final String TODO_NOT_FOUND = "Todo not found";

    public TodoController(){
        todolist= new ArrayList<>();
        todolist.add(new Todo(1,false,"Todo 1",1));
        todolist.add(new Todo(2,true,"Todo 2",2));
        System.out.println("Exexuted");
    }

    @GetMapping
    public  List<Todo> getTodos(){
        return  todolist;
    }


        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public Todo createTodo(@RequestBody Todo newTodo){
        todolist.add(newTodo);
        return newTodo;
        }

        @GetMapping("/{todoId}")
        public ResponseEntity<?> getTodoById(@PathVariable Long todoId){
         for(Todo todo : todolist){
             if(todo.getId()==todoId){
                 return ResponseEntity.ok(todo);
             }
         }
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
        }

        @DeleteMapping("/{todoId}")
        public ResponseEntity<?> deleteById(@PathVariable Long todoId)
        {
            Todo todoToRemove=null;
            for(Todo todo: todolist){
                if(todo.getId()==todoId)
                {
                    todoToRemove=todo;
                    break;
                }
            }
            if(todoToRemove!=null) {
                todolist.remove(todoToRemove);
                String deleteSuccessMessage = "Todo deleted Successfully";
                return ResponseEntity.status(HttpStatus.OK).body(deleteSuccessMessage);
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(TODO_NOT_FOUND);
            }
        }


}
