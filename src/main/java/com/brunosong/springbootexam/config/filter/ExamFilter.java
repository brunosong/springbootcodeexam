package com.brunosong.springbootexam.config.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/exam/*")
@Slf4j
public class ExamFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("EXAM FILTER START");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("EXAM FILTER END");
    }

}
