package com.brunosong.springbootexam.examms.controller;


import com.brunosong.springbootexam.examms.service.ServiceBasicExam1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerBasicExam1Test {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ServiceBasicExam1 service;

    //@Test : @MockBean으로 인해 null 발생
    void methodGetNoArgumentTest() {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/exam/method-get-no-argument",
                String.class)).contains("Hi Hello");
    }


    @Test
    void methodGetNoArgumentMockBeanTest() {

        given(service.addHelloMessage(any()))
                .willReturn("BrunoSong Hello");

        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/exam/method-get-no-argument",
                String.class)).contains("BrunoSong Hello");

    }

}
