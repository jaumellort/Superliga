package com.superliga.jllort.bencosuperleague;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.superliga.jllort.bencosuperleague.users.UserDetailActivity;
import com.superliga.jllort.bencosuperleague.users.UserListActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button mShowUsersList = (Button) findViewById(R.id.user_list_button);
        mShowUsersList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent userListIntent = new Intent(MainActivity.this, UserListActivity.class);
                startActivity(userListIntent);
            }
        });
    }


}
