package com.example.todoapi;

import org.springframework.stereotype.Service;


@Service("FakeTodoService")
public class FakeTodoService implements TodoService{

    @TimeMonitor
    @Override
    public String doSomething() {

        for(long i = 0; i < 10000000000L; i++) {}
        return "Something";
    }
}
