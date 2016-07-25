package com.engineermaster.demoapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.engineermaster.demoapp.DBHelper.MchartDBAdapter;
import com.engineermaster.demoapp.MessageHelper.MessageH;
import com.engineermaster.demoapp.Utility.Utility;
import com.engineermaster.demoapp.database.OpenHelper;
import com.engineermaster.demoapp.listener.CustomOnItemSelectedListener;
import com.github.channguyen.rsv.RangeSliderView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gopal on 03-06-2016.
 */
public class GreenActivity extends AppCompatActivity{

    int chk_slider_green=0;

    TextView textview;
    Button green_next_btn,green_back_btn;

    String item;
    String colorcode ="#5B967D";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.green_page);

        textview = (TextView) findViewById(R.id.textview1_green);
        green_next_btn = (Button)findViewById(R.id.green_next_btn);
        green_back_btn = (Button)findViewById(R.id.green_back_btn);


        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_green);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {

                chk_slider_green=1;

                Utility.setIntegerPreferences(getApplicationContext(),"green",index);
                Utility.setStringPreferences(getApplicationContext(),"greencolorcode",colorcode);

            }
        };

        largeSlider.setOnSlideListener(listener);


        textview.setText("Partner, partner , husband, wife , family and friends are often the only person with whom you show your true colors , and you can just be yourself. It is with them you can look back and understand it with them celebrating their smaller and more successful .\n" +
                "\n" +
                "\n" +
                "Do you wonder sometimes on this , on what basis you are building your relationship ? What you give to the relationship , and what you take from it ?\n" +
                "\n" +
                "\n" +
                "In this area, pay attention to : partnership , family relationships , partnerships , relationships , love, openness, honesty , trust, empathy , gratitude , sensitivity, forgiveness , gentleness , emotionality , inner harmony , forgiveness and answer the question :\n" +

                "\n"+
                "\n"+

                "What is ( on a scale of 1 to 10) is your level of satisfaction in this area of life ?");


        green_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_green==0){
                    Utility.setIntegerPreferences(getApplicationContext(),"green",0);
                }
                Intent i=new Intent(GreenActivity.this,BlueActivity.class);
                startActivity(i);
            }
        });
        green_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(GreenActivity.this,YellowActivity.class);
                startActivity(i);

                finish();
            }
        });

    }

}