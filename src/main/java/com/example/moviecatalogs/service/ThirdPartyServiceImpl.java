package com.example.moviecatalogs.service;

import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ThirdPartyServiceImpl implements ThirdPartyService {

    public static final String THIRD_PARTY_SERVICE = "http://movie-third-party-service";

    private final RestTemplate restTemplate;

    ThirdPartyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ThirdPartyApiResponse fetchData() {
        return restTemplate
                .getForEntity(THIRD_PARTY_SERVICE, ThirdPartyApiResponse.class)
                .getBody();
    }
}