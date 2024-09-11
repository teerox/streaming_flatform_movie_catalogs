package com.example.moviecatalogs.model;


import com.example.moviecatalogs.entity.MovieEntity;

import java.util.List;

public class ApiResponse {

    private List<MovieEntity> result;    // List of MovieEntity objects
    private int totalPages;               // Total number of pages
    private long totalResults;            // Total number of results
    private int page;                     // Current page number

    // Getters and Setters

    public List<MovieEntity> getContent() {
        return result;
    }

    public void setContent(List<MovieEntity> content) {
        this.result = content;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

