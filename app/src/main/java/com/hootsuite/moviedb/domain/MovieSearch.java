package com.hootsuite.moviedb.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieSearch implements Parcelable {
  private final String title;

  public MovieSearch(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.title);
  }

  protected MovieSearch(Parcel in) {
    this.title = in.readString();
  }

  public static final Parcelable.Creator<MovieSearch> CREATOR =
      new Parcelable.Creator<MovieSearch>() {
        @Override public MovieSearch createFromParcel(Parcel source) {
          return new MovieSearch(source);
        }

        @Override public MovieSearch[] newArray(int size) {
          return new MovieSearch[size];
        }
      };
}
