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
public class OrangeActivity extends AppCompatActivity  {


    TextView textview;
    Button orange_red_next_btn,orange_red_back_btn;

    String item;
    String colorcode_orange="#E54020";

    int chk_slider_orange=0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.orange_page);

        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_orange);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {


                chk_slider_orange=1;

                Utility.setIntegerPreferences(getApplicationContext(),"orange",index);
                Utility.setStringPreferences(getApplicationContext(),"orangecolorcode",colorcode_orange);

                String  orangecolorcode=Utility.getStringPreferences(getApplicationContext(),"orangecolorcode");

                Log.d("orangecolorcode",""+orangecolorcode);


            }
        };

        largeSlider.setOnSlideListener(listener);

        textview = (TextView) findViewById(R.id.textview_orange);
        orange_red_next_btn = (Button) findViewById(R.id.orange_red_next_btn);
        orange_red_back_btn = (Button) findViewById(R.id.orange_red_back_btn);



        textview.setText(
                "Pleasure is an integral and very important part of life, a feeling of pleasure is a signal showing that you are where you should be! No pleasure is a signal showing that the time to look inside themselves and reflect on their needs, dreams, aspirations and find a way of being fully ourselves!\n" +

                        "\n"+
                        "\n"+

                        "Feeling pleasure is one of the life skills! With the feeling of pleasure increasing vital energy. Also important are the internal beliefs and attitudes in relation to achieving pleasure. If you believe that enjoying life is a sin, or is accompanied by those of the Because of guilt, then it will be difficult to achieve happiness.\n" +

                        "\n"+
                        "\n"+

                        "In this area, pay attention to: relaxation, leisure, fun, food, art, tourism, contentment and joy, sexual energy, self-attractiveness, freedom of expression external creative creative energy, your inner child and answer the question:\n" +

                        "\n"+
                        "\n"+

                        "What is (on a scale of 1 to 10) is your level of satisfaction in this area of \u200B\u200Blife?");


        orange_red_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_orange==0){
                    Utility.setIntegerPreferences(getApplicationContext(),"orange",0);
                }

                Intent i=new Intent(OrangeActivity.this,YellowActivity.class);
                startActivity(i);
            }

        });

        orange_red_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(OrangeActivity.this,LightRedActivity.class);
                startActivity(i);

                finish();
            }
        });

    }

}