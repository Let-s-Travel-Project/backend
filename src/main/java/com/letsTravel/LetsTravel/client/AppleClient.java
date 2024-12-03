package com.letsTravel.LetsTravel.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.letsTravel.LetsTravel.domain.test.TokenResponse;
import com.letsTravel.LetsTravel.security.model.SimpleMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@RequiredArgsConstructor
@Component
public class AppleClient {

    private final HttpClient appleMapClient;
    private final ObjectMapper objectMapper;
    @Value("${apple.token}")
    private String token;
    private final String baseUrl = "https://maps-api.apple.com/v1";

    public TokenResponse getAppleMapToken() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/token"))
                    .timeout(Duration.ofSeconds(30))
                    .setHeader("Content-Type", "application/json;charset=UTF-8")
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> result = appleMapClient.send(request, HttpResponse.BodyHandlers.ofString());

            return objectMapper.readValue(result.body(), TokenResponse.class);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to get Apple Map token", e);
        }
    }

    public SimpleMessageDto getGeocodeAnAddress(
            String query,
            String token
    ) {
        try {
            String encodedAddress = URLEncoder.encode(query, StandardCharsets.UTF_8);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(baseUrl + "/geocode?q=" + encodedAddress))
                    .timeout(Duration.ofSeconds(30))
                    .setHeader("Content-Type", "application/json;charset=UTF-8")
                    .setHeader("Authorization", "Bearer " + token)
                    .GET()
                    .build();

            HttpResponse<String> result = appleMapClient.send(request, HttpResponse.BodyHandlers.ofString());

            return SimpleMessageDto.builder().message(result.body()).build();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Failed to get Apple Map token", e);
        }
    }


}
