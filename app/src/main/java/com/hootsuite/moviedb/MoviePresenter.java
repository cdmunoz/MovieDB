package com.hootsuite.moviedb;

import android.support.v4.util.ArrayMap;
import com.hootsuite.moviedb.api.MovieService;
import com.hootsuite.moviedb.domain.Movie;
import com.hootsuite.moviedb.domain.MovieSearch;
import com.hootsuite.moviedb.domain.SearchResponse;
import java.util.Map;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MoviePresenter {

  private final MovieView view;
  private final Map<String, Movie> movieCache = new ArrayMap<>();

  public MoviePresenter(MovieView view) {
    this.view = view;
  }

  void search(MovieSearch movieSearch) {
    // Search movies
    MovieService.INSTANCE.search(movieSearch.getTitle())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<SearchResponse>() {
          @Override public void onCompleted() {

          }

          @Override public void onError(Throwable e) {
            view.showError(e);
          }

          @Override public void onNext(SearchResponse searchResponse) {
            view.showMovies(searchResponse.getMovies());
          }
        });
  }
}
