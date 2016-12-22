package com.superliga.jllort.bencosuperleague.users;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.superliga.jllort.bencosuperleague.R;
import com.superliga.jllort.bencosuperleague.dto.Constants;
import com.superliga.jllort.bencosuperleague.dto.User;
import com.superliga.jllort.bencosuperleague.users.dummy.DummyContent;
import com.superliga.jllort.bencosuperleague.webservicesclient.UsersWS;

import org.xmlpull.v1.XmlPullParser;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    private ProgressDialog pd;

    public final static String USER_ID = "com.superliga.jllort.bencosuperleague.users.USER_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // new DownloadTask().execute(new String[]{XmlPullParser.NO_NAMESPACE});
       // this.pd = ProgressDialog.show(this, "Por favor espere", "Recuperando Numero de Garantias Emitidas", true, false);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onListFragmentInteraction(User item) {

        Intent detailIntent = new Intent(UserListActivity.this, UserDetailActivity.class);
        detailIntent.putExtra(USER_ID, item.getId().toString());
        startActivity(detailIntent);
    }

    //public void showResult(String response) {
    //    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    //    builder.setMessage("El numero de garantias es: " + response).setTitle("Estadisticas Gescaucion").setCancelable(false).setNeutralButton("Aceptar",  new DialogInterface.OnClickListener() {
     //       public void onClick(DialogInterface d, int i) {

     //           d.cancel();

      //      }
     //   });
     //   builder.create().show();
    //}


//private class DownloadTask extends AsyncTask<String, Void, Object> {
 //   List<User> response;

  //  private DownloadTask() {
 //   }

  //  protected Integer doInBackground(String... args) {
 //       this.response = new UsersWS().getAllActiveUsers();

  //      return Integer.valueOf(1);
  //  }

  //  protected void onPostExecute(Object result) {
   //     UserListActivity.this.pd.dismiss();
    //    super.onPostExecute(result);
    //    UserListActivity.this.use
    //    UserListActivity.this.showResult(this.response.toString());
   // }
//}

}
