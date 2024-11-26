package com.letsTravel.LetsTravel.service;

import com.letsTravel.LetsTravel.client.TestClient;
import com.letsTravel.LetsTravel.domain.test.TokenResponse;
import com.letsTravel.LetsTravel.security.model.SimpleMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestClient testClient;

    public TokenResponse getAppleMapToken() {

        return testClient.getAppleMapToken();

    }

    public SimpleMessageDto getGeocodeAnAddress(
            String query,
            String token
    ) {

        return testClient.getGeocodeAnAddress(query, token);

    }


}
