package com.brunosong.springbootexam.service.example;

import org.springframework.stereotype.Service;

@Service
public class ServiceBasicExam1 {

    public String addHelloMessage(String message) {
        return message + " Hello";
    }

}
