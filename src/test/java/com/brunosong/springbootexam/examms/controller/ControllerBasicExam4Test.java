package com.brunosong.springbootexam.examms.controller;


import com.brunosong.springbootexam.common.config.WebMvcConfig;
import com.brunosong.springbootexam.examms.contorller.ControllerBasicExam1;
import com.brunosong.springbootexam.examms.service.ServiceBasicExam1;
import jakarta.servlet.Filter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(
        value = ControllerBasicExam1.class,
        excludeFilters = {
                @ComponentScan.Filter( type = FilterType.ASSIGNABLE_TYPE, classes ={ WebMvcConfig.class } ),
                @ComponentScan.Filter( type = FilterType.ASSIGNABLE_TYPE, classes ={ Filter.class } )
})
//@WebMvcTest(controllers = ControllerBasicExam1.class, excludeAutoConfiguration = {SecurityAutoConfiguration.class}) //  AutoConfiguration 도 사용을 할 수 있다
public class ControllerBasicExam4Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ServiceBasicExam1 serviceBasicExam1;

    @Test
    void webMvcTestTest() throws Exception {

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
