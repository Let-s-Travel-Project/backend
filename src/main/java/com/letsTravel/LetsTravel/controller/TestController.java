package com.letsTravel.LetsTravel.controller;

import com.letsTravel.LetsTravel.domain.test.AopTest;
import com.letsTravel.LetsTravel.domain.test.TokenRequestDto;
import com.letsTravel.LetsTravel.domain.test.TokenResponse;
import com.letsTravel.LetsTravel.security.model.SimpleMessageDto;
import com.letsTravel.LetsTravel.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testService;

    @PostMapping("/aop/test")
    public String testController(
            @RequestBody AopTest aopTest
    ){
        return "test1: " + aopTest.test1 + "test2: " + aopTest.test2 + "\n";
    }

    @GetMapping("token")
    public ResponseEntity<TokenResponse> getAppleMapToken() {

        TokenResponse result = testService.getAppleMapToken();

        return ResponseEntity.ok(result);
    }

    @GetMapping("geocode")
    public ResponseEntity<SimpleMessageDto> getGeocodeAnAddress(
        @RequestParam String q,
        @RequestBody TokenRequestDto tokenRequestDto
    ) {
        SimpleMessageDto result = testService.getGeocodeAnAddress(q, tokenRequestDto.token);

        return ResponseEntity.ok(result);
    }
}