package com.letsTravel.LetsTravel.security.controller;

import com.letsTravel.LetsTravel.domain.profile.Profile;
import com.letsTravel.LetsTravel.domain.profile.UserRole;
import com.letsTravel.LetsTravel.security.jwt.JwtTokenUtil;
import com.letsTravel.LetsTravel.security.model.SimpleMessageDto;
import com.letsTravel.LetsTravel.security.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequiredArgsConstructor
public class SecurityTestController {

    private final ProfileRepository profileRepository;
    @Value("${jwt.secret-key}")
    private String secret_key;

    @GetMapping("/test") // jwt 필요 x
    public ResponseEntity<SimpleMessageDto> test() throws ParseException {
        String dateString = "2024-11-28";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format.parse(dateString);
        profileRepository.save(Profile.builder()
                .username("test")
                .password("test")
                .nickname("test")
                .birth(date)
                .sex((byte) 1)
                .firstName("te").lastName("st")
                        .status(true)
                .role(UserRole.ROLE_USER.name()).build()
        );
        String token = JwtTokenUtil.createToken("test", secret_key, 60*60*1000L);

        return ResponseEntity.ok(SimpleMessageDto.builder().message(token).build());
    }

    @GetMapping("test1") // jwt 필요
    public String test1() {
        return "test1";
    }

}
