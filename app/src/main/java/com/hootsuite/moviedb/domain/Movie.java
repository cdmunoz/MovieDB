package com.hootsuite.moviedb.domain;

import com.squareup.moshi.Json;

public class Movie {
  @Json(name = "id") private final String id;
  @Json(name = "title") private final String title;
  @Json(name = "poster_path") private final String posterPath;
  @Json(name = "backdrop_path") private final String backdropPath;
  @Json(name = "overview") private final String overview;
  @Json(name = "release_date") private final String releaseDate;

  public Movie(String id, String title, String posterPath, String backdropPath, String overview,
      String releaseDate) {
    this.id = id;
    this.title = title;
    this.posterPath = posterPath;
    this.backdropPath = backdropPath;
    this.overview = overview;
    this.releaseDate = releaseDate;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getPosterPath() {
    return posterPath;
  }

  public String getBackdropPath() {
    return backdropPath;
  }

  public String getOverview() {
    return overview;
  }

  public String getReleaseDate() {
    return releaseDate;
  }
}
