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
public class YellowActivity extends AppCompatActivity{

int chk_slider_yellow=0;

    TextView textview;
    Button yellow_next_btn,yellow_back_btn;

    String item;
    String colorcode ="#FFAD05";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yellow_page);



        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_yellow);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {

                chk_slider_yellow=1;

                Utility.setIntegerPreferences(getApplicationContext(),"yellow",index);
                Utility.setStringPreferences(getApplicationContext(),"yellowcolorcode",colorcode);

            }
        };

        largeSlider.setOnSlideListener(listener);

        textview = (TextView) findViewById(R.id.textview1_yellow);
        yellow_next_btn = (Button)findViewById(R.id.yellow_next_btn);
        yellow_back_btn = (Button)findViewById(R.id.yellow_back_btn);

        textview.setText("Remember that in your life have the time and attention just for yourself ! Self-esteem comes from the contact with himself. Self-esteem is conditioned by your trials and errors, successes and failures . With the will, initiative and self-discipline you can improve and implement their potential!\n" +

                "\n"+
                "\n"+

                "Will is the deliberate transmission of a particular direction , thanks to the strong will introduce changes resist a desire , we get rid of habits and addictions. The greater the will , the greater Internal power .\n" +

                "\n"+
                "\n"+

                "In this area, pay attention to : healthy selfishness , self-esteem , will and personal power , self-realization , achieving success , sprawczość , initiative and ability to function , efficiency, independence and answer the question :\n" +

                "\n"+
                "\n"+

                "What is ( on a scale of 1 to 10) is your level of satisfaction in this area of life ?");

        yellow_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_yellow==0){
                    Utility.setIntegerPreferences(getApplicationContext(),"yellow",0);
                }

                Intent i=new Intent(YellowActivity.this,GreenActivity.class);
                startActivity(i);
            }
        });
        yellow_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(YellowActivity.this,OrangeActivity.class);
                startActivity(i);

                finish();
            }
        });

    }


}