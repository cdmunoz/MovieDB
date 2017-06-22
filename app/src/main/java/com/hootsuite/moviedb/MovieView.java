package com.hootsuite.moviedb;

import com.hootsuite.moviedb.domain.Movie;
import java.util.List;


public interface MovieView {
  /**
   * Show the movies in the view
   * @param movies List of <code>Movie</code>
   */
  void showMovies(List<Movie> movies);

  /**
   * Show the given exception on the view
   * @param exception Exception to show
   */
  void showError(Throwable exception);
}
