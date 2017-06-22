package com.hootsuite.moviedb;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.hootsuite.moviedb.domain.MovieSearch;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions public class MainActivity extends AppCompatActivity {

  @BindView(R.id.titleText) EditText titleView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @NeedsPermission(Manifest.permission.INTERNET) @OnClick(R.id.search_button) void search() {
    MovieSearch movieSearch = new MovieSearch(titleView.getText().toString());
    Intent intent = MovieListActivity.getIntent(this, movieSearch);
    startActivity(intent);
  }
}
