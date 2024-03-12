package com.brunosong.springbootexam.examms.controller;


import com.brunosong.springbootexam.examms.contorller.ControllerBasicExam1;
import com.brunosong.springbootexam.examms.service.ServiceBasicExam1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ControllerBasicExam2_2Test {

    MockMvc mockMvc;

    @Mock
    private ServiceBasicExam1 service;

    @Test
    void mockMvcBuildersStandaloneSetupTest() throws Exception {

        this.mockMvc = MockMvcBuilders.standaloneSetup(new ControllerBasicExam1(service))
                                                        .defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
                                                        .setMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
                                                        .build();

        System.out.println(mockMvc);

        when(service.addHelloMessage(any())).thenReturn("BrunoSong Hello");

        mockMvc.perform(
                        get("/exam/method-get-no-argument")
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
        .andDo(print());

    }

}
