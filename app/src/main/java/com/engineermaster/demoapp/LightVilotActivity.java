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
public class LightVilotActivity extends AppCompatActivity {

int chk_slider_lightviloet=0;
    TextView textview;
    Button light_violet_next_btn,light_violet_back_btn;

    String item;
    String colorcode ="#765C96";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_vilot_page);


        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_lightviolet);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {

                chk_slider_lightviloet=1;

                Utility.setIntegerPreferences(getApplicationContext(),"lightviolet",index);
                Utility.setStringPreferences(getApplicationContext(),"lightvioletcolorcode",colorcode);

            }
        };

        largeSlider.setOnSlideListener(listener);

        textview = (TextView) findViewById(R.id.textview1_light_violet);
        light_violet_next_btn = (Button)findViewById(R.id.light_violet_next_btn);
        light_violet_back_btn = (Button)findViewById(R.id.light_violet_back_btn);




        textview.setText("Man learns throughout life ! Important is the development in the area of \u200B\u200Bprofessional life , but also in Under your own development. Personal development is a field that is constantly evolving thanks development of personal gain new knowledge , skills and experience.\n" +

                "\n"+
                "\n"+
                "Thanks to the personal development world recognize from the inside , you can easily odnajdywać source bothering you things and overcome them . Through personal development enrich their potential and open up new possibilities and options .\n" +

                "\n"+
                "\n"+

                "In this area, pay attention to : your interests and hobbies , traveling , reading , educate themselves ,education , participation in training courses, workshops and meetings of interest groups , and answer question:\n" +
                "\n" +
                "\n" +
                "What is ( on a scale of 1 to 10) is your level of satisfaction in this area of life ?");



        light_violet_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_lightviloet==0){
                    Utility.setIntegerPreferences(getApplicationContext(),"lightviolet",0);
                }
                Intent i=new Intent(LightVilotActivity.this,DarkVilotActivity.class);
                startActivity(i);
            }
        });

        light_violet_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(LightVilotActivity.this,BlueActivity.class);
                startActivity(i);
                finish();
            }
        });


    }


}
