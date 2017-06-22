package com.hootsuite.moviedb.api;

import com.hootsuite.moviedb.domain.SearchResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface MovieDbApi {
  @GET("search/movie") Observable<SearchResponse> search(@Query("query") String titleSearch,
      @Query("api_key") String type, @Query("page") int page);
}
