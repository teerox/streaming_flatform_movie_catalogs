package com.example.moviecatalogs.service;

import com.example.moviecatalogs.entity.MovieEntity;
import com.example.moviecatalogs.entity.MovieInfo;
import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieInfoService {


    List<MovieInfo> fetchAll();

    MovieInfo findById(Long theId);

    void save(MovieInfo movieInfo);

    void saveAll(List<MovieInfo> movieInfo);

    public Page<MovieEntity> getPaginatedMovies(int page);

}
