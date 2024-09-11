package com.example.moviecatalogs.controller;

import com.example.moviecatalogs.entity.MovieInfo;
import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import com.example.moviecatalogs.service.MovieInfoService;
import com.example.moviecatalogs.service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieInfoController {

    private final MovieInfoService movieInfoService;
    private final ThirdPartyService thirdPartyService;

    @Autowired
    public MovieInfoController(MovieInfoService movieInfoService,
                               ThirdPartyService thirdPartyService) {
        this.movieInfoService = movieInfoService;
        this.thirdPartyService = thirdPartyService;
    }


    @GetMapping("/movies/list")
    public List<MovieInfo> fetchAll() {
        return movieInfoService.fetchAll();
    }


    @GetMapping("/movies-external/list")
    public ThirdPartyApiResponse fetchExternal() {
        return thirdPartyService.fetchData();
    }

    @PostMapping("/movie-info/save")
    public void saveMovieInfo(@RequestBody List<MovieInfo> movieInfo) {
        movieInfoService.saveAll(movieInfo);

    }


    @GetMapping("/movie-info/list/{movieId}")
    public String fetchById(@PathVariable Long movieId) {
        MovieInfo movieInfo = movieInfoService.findById(movieId);
        if (movieInfo == null) {
            throw new RuntimeException("Movie not found");
        }
        return movieInfo.getPath();
    }
}
