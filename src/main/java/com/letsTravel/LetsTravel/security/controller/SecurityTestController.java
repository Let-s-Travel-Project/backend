package com.letsTravel.LetsTravel.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    @GetMapping("/test")
    public String test() {
        return "테스트 성공";
    }

    public String test1() {
        return "test1";
    }

}
