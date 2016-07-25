package com.engineermaster.demoapp;

import android.content.Intent;
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
public class DarkVilotActivity extends AppCompatActivity{

    int chk_slider_darkviolet=0;

    TextView textview;
    Button dark_violet_next_btn,dark_violet_back_btn;

    String item;
    String colorcode ="#965C89";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dark_vilot_page);
        RangeSliderView largeSlider = (RangeSliderView) findViewById(R.id.seekBar_darkviolet);
        final RangeSliderView.OnSlideListener listener = new RangeSliderView.OnSlideListener() {
            @Override
            public void onSlide(int index) {
                chk_slider_darkviolet=1;
                Utility.setIntegerPreferences(getApplicationContext(),"darkviolet",index);
                Utility.setStringPreferences(getApplicationContext(),"darkvioletcolorcode",colorcode);
            }
        };

        largeSlider.setOnSlideListener(listener);

        textview = (TextView) findViewById(R.id.textview1_dark_violet);
        dark_violet_next_btn = (Button)findViewById(R.id.dark_violet_next_btn);
        dark_violet_back_btn = (Button)findViewById(R.id.dark_violet_back_btn);


        textview.setText("Knowing your values \u200B\u200Band follow them gives us strength, a sense of fulfillment and meaning. The hierarchy of values \u200B\u200Bis a signpost of the choices made, we follow the path with which people build relationships, engage in every time and energię. Przykładowe values \u200B\u200Bare: love, happiness, peace,harmony, faith, independence, success, health, safety, family. The values \u200B\u200Bof great activities to motivate and inspire life.\n" +
                "\n" +
                "\n" +
                "Each of us believes in something. For some, this is a God, for others the universe, philosophy of life, certain values \u200B\u200Bor principles of life. Haven for a moment and look deeply into each other. Ask yourself - in I believe in life? How much live in harmony with their faith, philosophy, values? How it helps me? Values, philosophy of life and faith is the basis of our beliefs, and these again initiate any actions.\n" +
                "\n" +
                "\n" +
                "In this area, pay attention to: the principles, values, inner spark, faith, religion, spirituality, philosophy, mission life, the meaning of life and answer the question:\n" +
                "\n" +
                "\n" +
                "What is (on a scale of 1 to 10) is your level of satisfaction in this area of \u200B\u200Blife?");



        dark_violet_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chk_slider_darkviolet==0){
                    Utility.setIntegerPreferences(getApplicationContext(),"darkviolet",0);
                }

                Intent i=new Intent(DarkVilotActivity.this,RoseChartActivity.class);
                startActivity(i);
            }
        });

        dark_violet_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DarkVilotActivity.this,LightVilotActivity.class);
                startActivity(i);
                finish();
            }
        });


    }


}
