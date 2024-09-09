package com.example.moviecatalogs.repository;

import com.example.moviecatalogs.entity.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieInfoRepository extends JpaRepository<MovieInfo, Long> {
}
