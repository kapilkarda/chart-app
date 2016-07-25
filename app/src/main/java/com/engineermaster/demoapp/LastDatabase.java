package com.engineermaster.demoapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.engineermaster.demoapp.Logintest2.LoginActivity2;
import com.engineermaster.demoapp.Utility.Utility;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by Gopal on 18-07-2016.
 */
public class LastDatabase extends AppCompatActivity {

    TextView darkredtxt,lightredtxt,orengetxt,bluetxt,greentxt,darkviolettxt,lightviolettxt,yellowtxt,userdata,news,email_id,date_n_time;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.last_database);

        date_n_time=(TextView)findViewById(R.id.date_n_time);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        // textView is the TextView view that should display it
        date_n_time.setText(currentDateTimeString);


        userdata=(TextView)findViewById(R.id.userdata);
        news=(TextView)findViewById(R.id.news);
        email_id=(TextView)findViewById(R.id.email_id);

      //  String chk_user=Utility.getStringPreferences(LastDatabase.this,"usedata");

        userdata.setText(LoginActivity2.use_data);
        Log.d("chk_database","a"+LoginActivity2.use_data);
        //String chk_news=Utility.getStringPreferences(LastDatabase.this,"news");
        news.setText(LoginActivity2.news);
        Log.d("chk_database","b"+LoginActivity2.news);

        email_id.setText(LoginActivity2.login_email);

        darkredtxt=(TextView)findViewById(R.id.dark_red_txt);
        lightredtxt=(TextView)findViewById(R.id.light_red_txt);
        orengetxt=(TextView)findViewById(R.id.orange_txt);
        yellowtxt=(TextView)findViewById(R.id.yellow_txt);
        greentxt=(TextView)findViewById(R.id.green_txt);
        bluetxt=(TextView)findViewById(R.id.blue_txt);
        lightviolettxt=(TextView)findViewById(R.id.light_violet_txt);
        darkviolettxt=(TextView)findViewById(R.id.dark_violet_txt);

        darkredtxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"Red")));
        lightredtxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"lightred")));
        orengetxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"orange")));
        yellowtxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"yellow")));
        greentxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"green")));
        bluetxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"blue")));
        lightviolettxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"lightviolet")));
        darkviolettxt.setText(String.valueOf(Utility.getIntegerPreferences(LastDatabase.this,"darkviolet")));


    }
}
