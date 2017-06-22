package com.hootsuite.moviedb.domain;

import com.squareup.moshi.Json;
import java.util.List;

public class SearchResponse {
  @Json(name = "results")
  private final List<Movie> movies;
  private final int totalResults;

  public SearchResponse(List<Movie> movies, int totalResults) {
    this.movies = movies;
    this.totalResults = totalResults;
  }

  public List<Movie> getMovies() {
    return movies;
  }

  public int getTotalResults() {
    return totalResults;
  }
}
