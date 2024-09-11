package com.example.moviecatalogs.service;

import com.example.moviecatalogs.entity.MovieEntity;
import com.example.moviecatalogs.entity.MovieInfo;
import com.example.moviecatalogs.model.ThirdPartyApiResponse;
import com.example.moviecatalogs.model.ThirdPartyApiResultResponse;
import com.example.moviecatalogs.repository.MovieExternalRepository;
import com.example.moviecatalogs.repository.MovieInfoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieInfoServiceImpl implements MovieInfoService{


    private final MovieInfoRepository movieInfoRepository;
    private final MovieExternalRepository movieExternalRepository;

    private final ThirdPartyService thirdPartyService;

    @Autowired
    public MovieInfoServiceImpl(MovieInfoRepository movieInfoRepository,
                                MovieExternalRepository movieExternalRepository,
                                ThirdPartyService thirdPartyService) {
        this.movieInfoRepository = movieInfoRepository;
        this.movieExternalRepository = movieExternalRepository;
        this.thirdPartyService = thirdPartyService;
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

    @Transactional
    public Page<MovieEntity> getPaginatedMovies(int page) {
        Pageable pageable = PageRequest.of(page, 20);
        Page<MovieEntity> db_result = movieExternalRepository.findAll(pageable);

        if (db_result.isEmpty()) {
            // Fetch from external API and update database
            ThirdPartyApiResponse apiResponse1 = thirdPartyService.fetchData((long) page);
            List<ThirdPartyApiResultResponse> results = apiResponse1.getResults();

            for (ThirdPartyApiResultResponse result : results) {
                // Check if the movie with the same external_id already exists
                if (!movieExternalRepository.existsById(result.getId())) {
                    MovieEntity entity = setMovieEntity(result);
                    movieExternalRepository.save(entity);
                }
            }

            // Retrieve the updated results after fetching and saving to the database
            db_result = movieExternalRepository.findAll(pageable);
        }

        return db_result;
    }

    private static MovieEntity setMovieEntity(ThirdPartyApiResultResponse result) {
        MovieEntity entity = new MovieEntity();
        entity.setId(result.getId());
        entity.setExternal_id(result.getId());
        entity.setBackdrop_path(result.getBackdrop_path());
        entity.setTitle(result.getTitle());
        entity.setOriginal_title(result.getOriginal_title());
        entity.setOverview(result.getOverview());
        entity.setPoster_path(result.getPoster_path());
        entity.setMedia_type(result.getMedia_type());
        entity.setAdult(result.isAdult());
        entity.setOriginal_language(result.getOriginal_language());
        entity.setPopularity(result.getPopularity());
        entity.setRelease_date(result.getRelease_date());
        entity.setVote_average(result.getVote_average());
        entity.setVote_count(result.getVote_count());
        return entity;
    }
}
