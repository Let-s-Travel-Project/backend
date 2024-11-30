package com.letsTravel.LetsTravel.security.service;

import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import com.letsTravel.LetsTravel.domain.profile.entity.UserRole;
import com.letsTravel.LetsTravel.security.jwt.JwtTokenUtil;
import com.letsTravel.LetsTravel.security.model.*;
import com.letsTravel.LetsTravel.security.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    @Value("${jwt.secret-key}")
    private String secret_key;
    private final BCryptPasswordEncoder passwordEncoder;
    private final ProfileRepository profileRepository;

    public SimpleMessageDto login(LoginDto loginDto) {

        Profile profile = profileRepository.findByUsername(loginDto.getUsername());

        if (profile == null) {
            return SimpleMessageDto.builder().message("존재하지 않는 사용자이거나 비밀번호가 잘못되었습니다.").build();
        } else {
            if (!passwordEncoder.matches(loginDto.getPassword(), profile.getPassword())) {
                return SimpleMessageDto.builder().message("존재하지 않는 사용자이거나 비밀번호가 잘못되었습니다.").build();
            }
            String token = JwtTokenUtil.createToken(profile.getUsername(), secret_key, 60*60*1000L);
            profile.updateLoginTime();
            profileRepository.save(profile);
            return SimpleMessageDto.builder().message(token).build();
        }
    }

    public SimpleMessageDto signup(SignupDto signupDto) {

        Profile profile = profileRepository.findByUsername(signupDto.getUsername());

        if (profile != null) {
            return SimpleMessageDto.builder().message("존재하는 아이디입니다.").build();
        } else {
            if (signupDto.getPassword().length() > 15) {
                return SimpleMessageDto.builder().message("비밀번호가 너무 깁니다.").build();
            } else if (signupDto.getUsername().length() > 60) {
                return SimpleMessageDto.builder().message("아이디가 너무 깁니다.").build();
            }
            profileRepository.save(Profile.builder()
                    .username(signupDto.getUsername())
                    .password(passwordEncoder.encode(signupDto.getPassword()))
                    .role(UserRole.ROLE_USER.name())
                    .nickname(signupDto.getNickname())
                    .firstName(signupDto.getFirstName())
                    .lastName(signupDto.getLastName())
                    .birth(signupDto.getBirth())
                    .sex(signupDto.getSex())
                    .status(signupDto.isStatus())
                    .build()
            );
            return SimpleMessageDto.builder().message("로그인 성공").build();
        }
    }

    public Profile getUserByUsername(String username) {
        return profileRepository.findByUsername(username);
    }



}
