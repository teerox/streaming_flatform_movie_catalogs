package com.example.moviecatalogs.controller;

import com.example.moviecatalogs.entity.MovieInfo;
import com.example.moviecatalogs.service.MovieInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieInfoController {

    private final MovieInfoService movieInfoService;

    public MovieInfoController(MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @PostMapping("/movie-info/save")
    public void saveMovieInfo(@RequestBody List<MovieInfo> movieInfo) {
        movieInfoService.saveAll(movieInfo);

    }

    @GetMapping("/movie-info/list")
    public List<MovieInfo> fetchAll() {
        return movieInfoService.fetchAll();
    }
}
