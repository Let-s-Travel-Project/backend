package com.letsTravel.LetsTravel.security.jwt;

import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import com.letsTravel.LetsTravel.security.service.ProfileService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final ProfileService profileService;
    private final String secretKey;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(authorizationHeader == null) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("안비었음");
        if(!authorizationHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("bearer 맞음");
        String token = authorizationHeader.split(" ")[1];

        if(JwtTokenUtil.isExpired(token, secretKey)) {
            filterChain.doFilter(request, response);
            return;
        }
        System.out.println("유효함");
        String username = JwtTokenUtil.getUsername(token, secretKey);
        System.out.println("username: " + username);
        Profile profile = profileService.getUserByUsername(username);
        System.out.println("user: " + profile);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                profile.getUsername(), null, List.of(new SimpleGrantedAuthority(profile.getRole()))
        );
        System.out.println("authenticationToken: " + authenticationToken);
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);
    }
}
