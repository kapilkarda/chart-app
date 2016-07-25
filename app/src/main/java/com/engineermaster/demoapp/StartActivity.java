package com.engineermaster.demoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import info.hoang8f.widget.FButton;

/**
 * Created by Gopal on 02-06-2016.
 */
public class StartActivity extends AppCompatActivity {

    Button start_btn;
    private FButton start;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startbtnpage);

        start_btn=(Button)findViewById(R.id.start_btn);

        start  = (FButton) findViewById(R.id.f_start_btn);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(StartActivity.this,DarkRedActivity.class);
                startActivity(i);

                finish();
            }
        });

       /* start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(StartActivity.this,DarkRedActivity.class);
                startActivity(i);
            }
        });*/
    }
}
