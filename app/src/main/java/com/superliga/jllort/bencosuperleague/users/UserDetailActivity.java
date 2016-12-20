package com.superliga.jllort.bencosuperleague.users;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;

import com.superliga.jllort.bencosuperleague.R;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        rating.setRating(4.35f);
    }
}
