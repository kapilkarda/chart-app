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
public class BlueActivity extends AppCompatActivity {

int chk_slider_blue=0;

    TextView textview;
    Button blue_next_btn,blue_back_btn;

    String item;
 //   String colorcode ="#5C7496";

    String colorcode ="#00B8D4";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blue_page);


        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_blue);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {

                chk_slider_blue=1;
                Utility.setIntegerPreferences(getApplicationContext(),"blue",index);
                Utility.setStringPreferences(getApplicationContext(),"bluecolorcode",colorcode);

            }
        };

        largeSlider.setOnSlideListener(listener);



        textview = (TextView) findViewById(R.id.textview1_blue);
        blue_next_btn = (Button)findViewById(R.id.blue_next_btn);
        blue_back_btn = (Button)findViewById(R.id.blue_back_btn);


        textview.setText(
                "The work is an integral part of life ! Whether you 're working a full-time , contract , run your own business , whether full-time driving home and bringing up children - constantly need to grow !\n" +
                        "\n"+
                        "\n"+
                "However, if what you are doing at the moment does not meet your expectations , consider what you want to do? What are you good at? Determine the way to the place where you want to be , determine the risks and benefits , determine time frame and create a plan of action !\n" +
                        "\n"+
                        "\n"+
                        "In this area, note the openness , professional development , work environment , mental development ,communication , delegation of tasks , organization of work and answer the question :\n" +

                        "\n"+
                        "\n"+

                "What is ( on a scale of 1 to 10) is your level of satisfaction in this area of life ?");

        blue_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        if(chk_slider_blue==0){
            Utility.setIntegerPreferences(getApplicationContext(),"blue",0);
        }
                Intent i=new Intent(BlueActivity.this,LightVilotActivity.class);
                startActivity(i);
            }
        });

        blue_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(BlueActivity.this,GreenActivity.class);
                startActivity(i);

                finish();
            }
        });



    }


}
