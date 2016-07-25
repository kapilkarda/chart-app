/*
 * RoseChartActivity.java
 * Android-Charts Demo
 *
 * Created by limc on 2014/04/29.
 *
 * Copyright 2014 limc.cn All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.engineermaster.demoapp;

        import java.util.ArrayList;
        import java.util.List;

        import android.content.Intent;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.app.Activity;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;

        import com.engineermaster.demoapp.DBHelper.MchartDBAdapter;
        import com.engineermaster.demoapp.Utility.Utility;
        import com.github.mikephil.charting.data.*;
        import com.github.mikephil.charting.data.PieData;
        import com.github.mikephil.charting.utils.Utils;


public class RoseChartActivity extends Activity {

    RoseChart rosechart;
    SQLiteDatabase db;
    MchartDBAdapter dbAdapter;

    Button btn_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rose_chart);
        btn_final=(Button)findViewById(R.id.btn_final);

        btn_final.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(RoseChartActivity.this,LastDatabase.class);
                startActivity(intent);
            }
        });

        initRoseChart();
    }


    private void initRoseChart() {
        this.rosechart = (RoseChart) findViewById(R.id.rosechart);
        List<TitleValueColorEntity> data3 = new ArrayList<TitleValueColorEntity>();

        String[] colorName = new String[]{
                "DarkRed", "LightRed", "Orange", "Yellow", "Green", "Blue", "LightViolet", "DarkViolet"
        };


        //...............................

        dbAdapter=new MchartDBAdapter(RoseChartActivity.this);
   //     float[] item=new float[7];

        int[] item=new int[7];

        ArrayList<Integer> colors = new ArrayList<Integer>();
 //       ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        db = openOrCreateDatabase("MCHART",MODE_PRIVATE,null);
        //  Cursor cursor=db.rawQuery("SELECT * FROM PIECHART ORDER BY _id DESC LIMIT 8",null);


 /*       Cursor cursor = db.rawQuery("select * from (SELECT * FROM PIECHART ORDER BY _id DESC LIMIT 8)order by _id ASC;" ,null);//piechart
        cursor.moveToFirst();*/

 /*       while(!cursor.isAfterLast()){
            int i=0;
            if(i<=7) {
                String ids = cursor.getString(0);
                String colorcodes = cursor.getString(1);

                // item[i] = Float.parseFloat(cursor.getString(2));
                item[i]=Integer.parseInt(cursor.getString(2));
                colors.add(Color.parseColor(colorcodes));       //set colo on the element of paichart

                data3.add(new TitleValueColorEntity(colorName[i], item[i],Color.parseColor(colorcodes)));

                Log.d("ids", ids);
                Log.d("colorcodes", colorcodes);
                i++;
                cursor.moveToNext();
            }
        }*/

        int darkred= Utility.getIntegerPreferences(getApplicationContext(),"Red");
 //       String colordark=Utility.getStringPreferences(getApplicationContext(),"darkred");

        int lightred=Utility.getIntegerPreferences(getApplicationContext(),"lightred");
 //       String  colorlightres=Utility.getStringPreferences(getApplicationContext(),"lightredcolor");

        int orange=Utility.getIntegerPreferences(getApplicationContext(),"orange");
 //       String  orangecolorcode=Utility.getStringPreferences(RoseChartActivity.this,"orangecolorcode");

  //      Log.d("orangecolorcode",""+orangecolorcode);


        int yellow=Utility.getIntegerPreferences(getApplicationContext(),"yellow");
 //       String  yellowcolorcode=Utility.getStringPreferences(getApplicationContext(),"yellowcolorcode");

        int green=Utility.getIntegerPreferences(getApplicationContext(),"green");
 //       String  greencolorcode=Utility.getStringPreferences(getApplicationContext(),"greencolorcode");

        int blue=Utility.getIntegerPreferences(getApplicationContext(),"blue");
 //       String  bluecolorcode=Utility.getStringPreferences(getApplicationContext(),"bluecolorcode");


        int lightviolet=Utility.getIntegerPreferences(getApplicationContext(),"lightviolet");
 //       String  lightvioletcolorcode=Utility.getStringPreferences(getApplicationContext(),"lightvioletcolorcode");

        int darkviolet=Utility.getIntegerPreferences(getApplicationContext(),"darkviolet");
 //       String  darkvioletcolorcode=Utility.getStringPreferences(getApplicationContext(),"darkvioletcolorcode");

        String colorred2="#B32637";
        String colorredlight="#E33537";
        String colororange="#E54020";
        String coloryellow="#FFAD05";
        String colorgreen="#5B967D";
        String colorblue="#00B8D4";
        String colorlightvilot="#765C96";
        String colordarkvilot="#965C89";


        data3.add(new TitleValueColorEntity("Red", Float.valueOf(darkred) ,Color.parseColor(colorred2)));
        data3.add(new TitleValueColorEntity("lightred", Float.valueOf(lightred) ,Color.parseColor(colorredlight)));
        data3.add(new TitleValueColorEntity("orange", Float.valueOf(orange) ,Color.parseColor(colororange)));
        data3.add(new TitleValueColorEntity("yellow", Float.valueOf(yellow) ,Color.parseColor(coloryellow)));
        data3.add(new TitleValueColorEntity("green", Float.valueOf(green) ,Color.parseColor(colorgreen)));
        data3.add(new TitleValueColorEntity("blue", Float.valueOf(blue) ,Color.parseColor(colorblue)));
        data3.add(new TitleValueColorEntity("lightviolet", Float.valueOf(lightviolet) ,Color.parseColor(colorlightvilot)));
        data3.add(new TitleValueColorEntity("darkviolet", Float.valueOf(darkviolet) ,Color.parseColor(colordarkvilot)));


        rosechart.setData(data3);


        //...............................

     /*
        data3.add(new TitleValueColorEntity(getResources().getString(R.string.rosechart_title1), 1,
                getResources().getColor(R.color.red)));
        data3.add(new TitleValueColorEntity(getResources().getString(R.string.rosechart_title1), 2,
                getResources().getColor(R.color.orange)));
        data3.add(new TitleValueColorEntity(getResources().getString(R.string.rosechart_title1), 3,
                getResources().getColor(R.color.yellow)));
        data3.add(new TitleValueColorEntity(getResources().getString(R.string.rosechart_title4), 4,
                getResources().getColor(R.color.green)));
        data3.add(new TitleValueColorEntity(getResources().getString(R.string.rosechart_title5), 5,
                getResources().getColor(R.color.blue)));
        data3.add(new TitleValueColorEntity(getResources().getString(R.string.rosechart_title6), 6,
                getResources().getColor(R.color.pink)));*/

     //   rosechart.setData(data3);


    }
}
