package com.example.moviecatalogs.service;

import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


public interface ThirdPartyService {
    public ThirdPartyApiResponse fetchData(Long page);
}
