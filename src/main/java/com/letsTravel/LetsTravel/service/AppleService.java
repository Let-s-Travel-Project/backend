package com.letsTravel.LetsTravel.service;

import com.letsTravel.LetsTravel.client.AppleClient;
import com.letsTravel.LetsTravel.domain.profile.entity.Profile;
import com.letsTravel.LetsTravel.domain.test.TokenResponse;
import com.letsTravel.LetsTravel.security.model.SimpleMessageDto;
import com.letsTravel.LetsTravel.security.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppleService {

    private final AppleClient appleClient;
    private final ProfileRepository profileRepository;

    public TokenResponse getAppleMapToken(String username) {
        TokenResponse token = appleClient.getAppleMapToken();
        Profile profile = profileRepository.findByUsername(username);
        profile.updateAppleToken(token.accessToken);
        profileRepository.save(profile);

        return token;
    }

    public SimpleMessageDto getGeocodeAnAddress(
            String query,
            String username
    ) {
        Profile profile = profileRepository.findByUsername(username);
        return appleClient.getGeocodeAnAddress(query, profile.getAppleToken());
    }


}
