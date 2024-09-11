package com.example.moviecatalogs.service;

import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

//@Service
public class DailyUpdateService {

    private final MovieInfoService internalDatabaseService;

    public DailyUpdateService(MovieInfoService internalDatabaseService) {
        this.internalDatabaseService = internalDatabaseService;
    }

    // Schedule this method to run once a day at midnight (adjust the cron expression as needed)
    //@Scheduled(cron = "0 0 0 * * ?") // Every day at midnight
    public void updateDatabaseDaily(int page) {
        internalDatabaseService.getPaginatedMovies(page);
    }
}
