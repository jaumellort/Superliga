package com.superliga.jllort.bencosuperleague.users;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.superliga.jllort.bencosuperleague.R;
import com.superliga.jllort.bencosuperleague.dto.Constants;
import com.superliga.jllort.bencosuperleague.dto.User;
import com.superliga.jllort.bencosuperleague.webservicesclient.UsersWS;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;

public class UserDetailActivity extends AppCompatActivity {

    private ProgressDialog pd;

   // private User user;

    private int userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        int userId = Integer.parseInt(getIntent().getStringExtra(UserListActivity.USER_ID));
        this.userId = userId;

        new UserDetailActivity.DownloadTask().execute(new String[]{XmlPullParser.NO_NAMESPACE});

        this.pd = ProgressDialog.show(this, "Por favor espere", "Recuperando datos de usuario", true, false);

    }

    private void populateScreen(User user){

        TextView userName = (TextView) findViewById(R.id.username_user_detail);
        userName.setText(user.getName());

        TextView gamertag = (TextView) findViewById(R.id.gamertag_user_detail);
        gamertag.setText(user.getGamerTag());

        TextView currentteam = (TextView) findViewById(R.id.current_team_user_detail);
        currentteam.setText("En construccion");

        RatingBar rating = (RatingBar) findViewById(R.id.ratingBar);
        rating.setRating(3.35f);
    }


    private class DownloadTask extends AsyncTask<String, Void, Object> {
        User response;

        private DownloadTask() {
        }

        protected Integer doInBackground(String... args) {
            this.response = new UsersWS().getUserById(UserDetailActivity.this.userId);
            //UserDetailActivity.this.user = response;
            return 1;
        }

        protected void onPostExecute(Object result) {
           // UserDetailActivity.this.user = (User)response;
            UserDetailActivity.this.pd.dismiss();
            super.onPostExecute(result);
            UserDetailActivity.this.populateScreen(this.response);

        }
    }
}
