package com.engineermaster.demoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.engineermaster.demoapp.Logintest2.LoginActivity2;

import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    Button next;
    TextView textView;
    private FButton f_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=(Button)findViewById(R.id.title_page_btn);
        textView=(TextView)findViewById(R.id.title_page_txt);

        textView.setText("\n" +
                "Wheel of Life is a great exercise coaching facilitating a holistic view of your whole life,consisting of multiple areas. Adoption you a broad perspective perfectly build awareness of your current life situation on the day of measurement.In general, people begin to wonder what is really important in their lives when they become for life bend or struggling with severe life experiences. Reflect on their own life is not worth postponed because the time for it is precisely now, when we can still make a difference! Wheel Life is the first step in the search for life balance! Living areas placed on NATURAL WHEEL OF LIFE, and their colors are proposals under the ancient concept of human energy centers - chakras, because the subtle energy of the chakras different areas of your life. permeates all aspects of our lives. The exercise is to assess on a scale of 1 to level 10 your contentment and satisfaction Life is a journey! I invite you to journey into yourself!");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(MainActivity.this,LoginActivity2.class);
                startActivity(i);

                finish();
            }
        });

    }
}
