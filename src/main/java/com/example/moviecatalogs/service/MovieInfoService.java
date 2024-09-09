package com.example.moviecatalogs.service;

import com.example.moviecatalogs.entity.MovieInfo;
import java.util.List;

public interface MovieInfoService {


    List<MovieInfo> fetchAll();

    MovieInfo findById(Long theId);

    void save(MovieInfo movieInfo);

    void saveAll(List<MovieInfo> movieInfo);
}
