package com.example.moviecatalogs.service;

import com.example.moviecatalogs.entity.MovieInfo;
import com.example.moviecatalogs.repository.MovieInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService{


    private final MovieInfoRepository movieInfoRepository;

    public MovieInfoServiceImpl(MovieInfoRepository movieInfoRepository) {
        this.movieInfoRepository = movieInfoRepository;
    }

    @Override
    public List<MovieInfo> fetchAll() {
        return movieInfoRepository.findAll();
    }

    @Override
    public MovieInfo findById(Long theId) {
        return movieInfoRepository.findById(theId).orElse(null);
    }

    @Override
    public void save(MovieInfo movieInfo) {
        movieInfoRepository.save(movieInfo);
    }

    @Override
    public void saveAll(List<MovieInfo> movieInfo) {
        movieInfoRepository.saveAll(movieInfo);
    }
}
