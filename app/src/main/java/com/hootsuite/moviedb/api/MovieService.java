package com.hootsuite.moviedb.api;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.hootsuite.moviedb.BuildConfig;
import com.hootsuite.moviedb.Constants;
import com.hootsuite.moviedb.domain.SearchResponse;
import com.squareup.moshi.Moshi;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;
import rx.Observable;

public enum MovieService {

  INSTANCE;
  public static final int DEFAULT_PAGE_SIZE = 10;
  private final MovieDbApi movieDbApi;

  MovieService() {
    OkHttpClient okHttpClient =
        new OkHttpClient.Builder().addNetworkInterceptor(new StethoInterceptor()).build();

    Moshi moshi = new Moshi.Builder().build();

    Retrofit retrofit = new Retrofit.Builder().baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .build();

    movieDbApi = retrofit.create(MovieDbApi.class);
  }

  public Observable<SearchResponse> search(String titleSearch) {
    return search(titleSearch, Constants.API_KEY, 1);
  }

  public Observable<SearchResponse> search(String titleSearch, String apiKey, int page) {
    return movieDbApi.search(titleSearch, apiKey, page);
  }
}
