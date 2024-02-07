package com.brunosong.springbootexam.controller.example;

import com.brunosong.springbootexam.service.example.ServiceBasicExam1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ControllerBasicExam1 {

    private final ServiceBasicExam1 service;


    @GetMapping("/exam/method-get-no-argument")
    public @ResponseBody String methodGetNoArgument() {

        String message = service.addHelloMessage("Hi");
        log.info("healthcheck : {}" , message );

        return message;
    }

}
