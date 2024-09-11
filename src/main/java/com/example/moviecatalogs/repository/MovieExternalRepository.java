package com.example.moviecatalogs.repository;

import com.example.moviecatalogs.entity.MovieEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieExternalRepository extends JpaRepository<MovieEntity, Long> {
    Page<MovieEntity> findAll(Pageable pageable);

}
