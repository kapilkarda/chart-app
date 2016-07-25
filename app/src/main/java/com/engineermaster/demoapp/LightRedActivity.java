package com.engineermaster.demoapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
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
 * Created by Gopal on 02-06-2016.
 */
public class LightRedActivity extends AppCompatActivity{

    TextView textview;
    Button light_red_next_btn,light_red_back_btn;

    String item;
    String colorcode = "#E33537";

    int chk_slider_var_light_red=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.light_red_page);
        TextView textView = (TextView) findViewById(R.id.textview_light_red);

        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_lightred);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {

                chk_slider_var_light_red=1;

                Utility.setIntegerPreferences(getApplicationContext(),"lightred",index);
                Utility.setStringPreferences(getApplicationContext(),"lightredcolor",colorcode);

            }
        };

        largeSlider.setOnSlideListener(listener);

        textView.setText("Man does not live in a vacuum environment is an element which operates on a daily basis. The immediate environment directly affects the life activity of man. Environment understood as people and objects around you can have a stimulating your character development and pushing you toward better, or inhibitory in nature in such a way that you can easily build a better themselves.\n" +
                "\n"+
                "\n"+

                "Developing a friendly environment will grow faster and with greater awareness. Of course, you are responsible for your life! So wake up and look around! What subjects and what people you have in your environment?\n" +

                "\n"+
                "\n"+

                "The money reportedly does not bring happiness, but to live without them can not be! It depends on you how the standard of living you want to achieve. Organizing this sphere of life gives a sense of security and comfort.\n" +
                "\n"+
                "\n"+

                "In this area, pay attention to: the conditions of your development: the home environment, the organization of life, technical conditions, safety, finances, stability, surround you objects around you and the people and animals and answer the question:\n" +

                "\n"+
                "\n"+

                "What is (on a scale of 1 to 10) is your level of satisfaction in this area of \u200B\u200Blife?");



        textview = (TextView) findViewById(R.id.textview_light_red);
        light_red_next_btn = (Button) findViewById(R.id.light_red_next_btn);
        light_red_back_btn = (Button) findViewById(R.id.light_red_back_btn);

        light_red_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_var_light_red==0){
                    Utility.setIntegerPreferences(getApplicationContext(),"lightred",0);
                }


                Intent i=new Intent(LightRedActivity.this,OrangeActivity.class);
                startActivity(i);
            }
        });


        light_red_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent i=new Intent(LightRedActivity.this,DarkRedActivity.class);
                startActivity(i);

                finish();
            }
        });
    }
}