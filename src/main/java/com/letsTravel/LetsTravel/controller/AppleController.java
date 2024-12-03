package com.letsTravel.LetsTravel.controller;

import com.letsTravel.LetsTravel.domain.test.TokenRequestDto;
import com.letsTravel.LetsTravel.domain.test.TokenResponse;
import com.letsTravel.LetsTravel.security.model.SimpleMessageDto;
import com.letsTravel.LetsTravel.service.AppleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AppleController {

    private final AppleService appleService;

    @GetMapping("token")
    public ResponseEntity<TokenResponse> getAppleMapToken(
            Authentication authentication
    ) {
        TokenResponse result = appleService.getAppleMapToken(authentication.getName());

        return ResponseEntity.ok(result);
    }

    @GetMapping("geocode")
    public ResponseEntity<SimpleMessageDto> getGeocodeAnAddress(
        @RequestParam("q") String q,
        @RequestBody TokenRequestDto tokenRequestDto
    ) {
        SimpleMessageDto result = appleService.getGeocodeAnAddress(q, tokenRequestDto.token);

        return ResponseEntity.ok(result);
    }
}