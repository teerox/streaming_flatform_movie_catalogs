package com.example.moviecatalogs.model;

import java.util.List;

public class ThirdPartyApiResponse {
    private long page;
    private List<ThirdPartyApiResultResponse> results;
    private long totalPages;
    private long totalResults;

    // Getters and Setters
    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public List<ThirdPartyApiResultResponse> getResults() {
        return results;
    }

    public void setResults(List<ThirdPartyApiResultResponse> results) {
        this.results = results;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(long totalResults) {
        this.totalResults = totalResults;
    }
}