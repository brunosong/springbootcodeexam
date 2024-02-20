package com.brunosong.springbootexam.controller.example;


import com.brunosong.springbootexam.service.example.ServiceBasicExam1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@SpringBootTest
public class ControllerBasicExam2_1Test {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext context;

    @Autowired
    private ServiceBasicExam1 serviceBasicExam1;


    @Test
    void mockMvcBuildersStandaloneSetupTest() throws Exception {

        this.mockMvc = MockMvcBuilders.standaloneSetup(new ControllerBasicExam1(serviceBasicExam1))
                                                        .defaultResponseCharacterEncoding(StandardCharsets.UTF_8)
                                                        .setMessageConverters(new StringHttpMessageConverter(StandardCharsets.UTF_8))
                                                        .build();

        mockMvc.perform(
                        get("/exam/method-get-no-argument")
        ).andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
        .andDo(print());

    }


    @Test
    void mockMvcBuildersWebAppContextSetupTest() throws Exception {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        log.info("MOCK MVC : {}" , mockMvc);

        mockMvc.perform(
                        get("/exam/method-get-no-argument")
                ).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("text/plain;charset=UTF-8")))
                .andDo(print());
    }

}
