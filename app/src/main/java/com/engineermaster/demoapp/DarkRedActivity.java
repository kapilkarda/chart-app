package com.engineermaster.demoapp;

import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import android.widget.AdapterView.OnItemSelectedListener;

import com.engineermaster.demoapp.DBHelper.MchartDBAdapter;
import com.engineermaster.demoapp.MessageHelper.MessageH;
import com.engineermaster.demoapp.Utility.Utility;
import com.engineermaster.demoapp.database.OpenHelper;
import com.engineermaster.demoapp.listener.CustomOnItemSelectedListener;
import com.github.channguyen.rsv.RangeSliderView;

/**
 * Created by Gopal on 02-06-2016.
 */
public class DarkRedActivity extends AppCompatActivity  {

    Button dark_red_btn;

    String item;
    String colorcode = "#B32637";
    private RangeSliderView largeSlider;

    int chk_slider_var=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_2);

        RangeSliderView  largeSlider = (RangeSliderView) findViewById(R.id.seekBar);

        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {

                chk_slider_var=1;

                Utility.setIntegerPreferences(getApplicationContext(),"Red",index);
                Utility.setStringPreferences(getApplicationContext(),"darkred",colorcode);

                int chk=Utility.getIntegerPreferences(getApplicationContext(),"Red");

                Log.d("chkit_vlaue", String.valueOf(chk));
            }
        };

        largeSlider.setOnSlideListener(listener);

        TextView textView = (TextView) findViewById(R.id.textview2);
        Button dark_red_next_btn=(Button)findViewById(R.id.dark_red_next_btn);

        Button dark_red_back_btn=(Button)findViewById(R.id.dark_red_back_btn);

        textView.setText("Your body is a machine driving your intellect , because the physical body motivates your body Mental positive thinking ! Your physical body is a machine driving your spirit , because in a healthy body, healthy mind !\n"+

                "\n"+
                "\n"+

                "It is important to take care about what you feed your body what you give him and how to treat them - otherwise body refuses to obey you . The situation with the physical body can be compared to football : When One of the players receives a red card then the whole team is weakened . Weakened team focuses on the attack or counterattack and focused on defense ( treatment).\n"+

                "\n"+
                "\n"+

                "In this area, pay attention to the health, physical body , physical body acceptance , fulfillment physiological needs , vital energy , diet and nutrition, sport , exercise , power, relationship with nature and answer the question :\n"+

                "\n"+
                "\n"+

                "What is ( on a scale of 1 to 10) is your level of satisfaction in this area of life ?");

        dark_red_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_var==0) {

                    Utility.setIntegerPreferences(getApplicationContext(),"Red",0);

                    Log.d("sliderchk", ""+String.valueOf(chk_slider_var));
                }
                    Intent i = new Intent(DarkRedActivity.this, LightRedActivity.class);
                    startActivity(i);



            }
        });

        dark_red_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(DarkRedActivity.this,StartActivity.class);
                startActivity(i);

                finish();

            }
        });

    }
}