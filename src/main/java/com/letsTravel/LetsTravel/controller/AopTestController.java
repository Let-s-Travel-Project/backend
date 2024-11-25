package com.letsTravel.LetsTravel.controller;

import com.letsTravel.LetsTravel.domain.test.AopTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aop")
public class AopTestController {

    @PostMapping("/test")
    public String testController(
            @RequestBody AopTest aopTest
    ){
        return "test1: " + aopTest.test1 + "test2: " + aopTest.test2 + "\n";
    }
}