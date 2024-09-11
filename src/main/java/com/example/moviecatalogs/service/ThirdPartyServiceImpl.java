package com.example.moviecatalogs.service;

import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ThirdPartyServiceImpl implements ThirdPartyService {

    public static final String THIRD_PARTY_SERVICE = "http://movie-third-party-service/movies-external/list";

    private final RestTemplate restTemplate;

    ThirdPartyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ThirdPartyApiResponse fetchData(Long page) {
        // Construct the URL with the page parameter
        String url = THIRD_PARTY_SERVICE + "?page=" + page;
        System.out.println("URL: " + url);
        return restTemplate
                .getForEntity(url, ThirdPartyApiResponse.class)
                .getBody();
    }

}