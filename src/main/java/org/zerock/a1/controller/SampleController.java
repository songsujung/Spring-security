package org.zerock.a1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.val;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/sample")
public class SampleController {

    @PreAuthorize("permitAll") // premitAll : 모든 사용자에게 공개
    @GetMapping("/all")
    public void doAll(){

        log.info("doAll...........");
    }

    @PreAuthorize("hasRole('USER')") // USER의 권한이 있는 사람만 들어올 수 있음
    @GetMapping("/user")
    public void doUser(){

    }

    @PreAuthorize("hasRole('G1')") // G1의 권한이 있는 사람만 들어올 수 있음
    @GetMapping("/g1")
    public void doG1(){

        log.info("doG1...........");
    }
    
}
