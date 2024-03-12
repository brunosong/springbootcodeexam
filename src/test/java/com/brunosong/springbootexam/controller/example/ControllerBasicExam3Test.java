package com.brunosong.springbootexam.controller.example;


import com.brunosong.springbootexam.examms.service.ServiceBasicExam1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerBasicExam3Test {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ServiceBasicExam1 serviceBasicExam1;

    @Test
    void autoConfigureMockMvcTest() throws Exception {

        given(serviceBasicExam1.addHelloMessage(any()))
                .willReturn("BrunoSong Hello");

        mockMvc.perform(
                        get("/exam/method-get-no-argument")
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
        .andExpect(content().string("BrunoSong Hello"))
        .andDo(print());

    }

}
