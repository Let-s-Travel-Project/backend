package com.letsTravel.LetsTravel.security.config;

import com.letsTravel.LetsTravel.security.jwt.JwtTokenFilter;
import com.letsTravel.LetsTravel.domain.profile.entity.UserRole;
import com.letsTravel.LetsTravel.security.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final ProfileService profileService;

    @Value("${jwt.secret-key}")
    private String secretKey;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .httpBasic(httpBasic -> httpBasic.disable())
                .formLogin((formLogin) -> formLogin.disable())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new JwtTokenFilter(profileService, secretKey), LogoutFilter.class)
                .authorizeHttpRequests(auth ->
                        auth.requestMatchers("/**").permitAll()
//                        auth.requestMatchers("/login/signup", "/login", "test").permitAll()
                .requestMatchers("/login/admin/**").hasAuthority(UserRole.ROLE_ADMIN.name()).anyRequest().authenticated())

                .build();
    }

}