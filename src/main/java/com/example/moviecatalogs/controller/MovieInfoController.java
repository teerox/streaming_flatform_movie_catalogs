package com.example.moviecatalogs.controller;

import com.example.moviecatalogs.entity.MovieEntity;
import com.example.moviecatalogs.entity.MovieInfo;
import com.example.moviecatalogs.model.ApiResponse;
import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import com.example.moviecatalogs.service.MovieInfoService;
import com.example.moviecatalogs.service.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieInfoController {

    private final MovieInfoService movieInfoService;

    @Autowired
    public MovieInfoController(MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @GetMapping("/movies/list")
    public List<MovieEntity> fetchAll() {
        return movieInfoService.fetchAll();
    }


    @GetMapping("/movies/all")
    public ApiResponse fetchExternal(@RequestParam(defaultValue = "1") int pageValue) {
        Page<MovieEntity>  result = movieInfoService.getPaginatedMovies(pageValue);

        List<MovieEntity> movieEntities =result.getContent();
        int totalPages = result.getTotalPages();
        long totalResults = result.getTotalElements();
        int page = result.getNumber();

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setContent(movieEntities);
        apiResponse.setTotalPages(totalPages);
        apiResponse.setTotalResults(totalResults);
        apiResponse.setPage(page);

        return apiResponse;
    }

    @PostMapping("/movies/save")
    public void saveMovieInfo(@RequestBody List<MovieInfo> movieInfo) {
        movieInfoService.saveAll(movieInfo);

    }


    @GetMapping("/movies/{movieId}")
    public MovieEntity fetchById(@PathVariable Long movieId) {
        MovieEntity movieInfo = movieInfoService.findById(movieId);
        if (movieInfo == null) {
            throw new RuntimeException("Movie not found");
        }
        return movieInfo;
    }

    @GetMapping("/movies/video/{movieId}")
    public String fetchVideoPathById(@PathVariable Long movieId) {
        MovieEntity movieInfo = movieInfoService.findById(movieId);
        if (movieInfo == null) {
            throw new RuntimeException("Movie not found");
        }
        return movieInfo.getMovie_path();
    }
}
