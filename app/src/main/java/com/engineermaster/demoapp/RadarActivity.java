package com.engineermaster.demoapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.engineermaster.demoapp.DBHelper.MchartDBAdapter;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

public class RadarActivity extends AppCompatActivity {
    SQLiteDatabase db;
    MchartDBAdapter dbAdapter;
    RadarChart chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);

        dbAdapter=new MchartDBAdapter(RadarActivity.this);
        float[] item=new float[7];
        ArrayList<Integer> colors = new ArrayList<Integer>();

         chart = (RadarChart) findViewById(R.id.chart);

        db = openOrCreateDatabase("MCHART",MODE_PRIVATE,null);
        //  Cursor cursor=db.rawQuery("SELECT * FROM PIECHART ORDER BY _id DESC LIMIT 8",null);
        Cursor cursor = db.rawQuery("select * from (SELECT * FROM PIECHART ORDER BY _id DESC LIMIT 8)order by _id ASC;" ,null);//piechart

        cursor.moveToFirst();
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();
        while(!cursor.isAfterLast()){
            int i=0;
            if(i<=7) {

                String ids = cursor.getString(0);
                String colorcodes = cursor.getString(1);
                item[i] = Float.parseFloat(cursor.getString(2));
                colors.add(Color.parseColor(colorcodes));       //set colo on the element of paichart
                yVals1.add(new Entry(item[i], i));
                Log.d("ids", ids);
                Log.d("colorcodes", colorcodes);
                i++;
                cursor.moveToNext();
            }
        }

    /*    ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(4f, 0));
        entries.add(new Entry(5f, 1));
        entries.add(new Entry(2f, 2));
        entries.add(new Entry(7f, 3));
        entries.add(new Entry(6f, 4));
        entries.add(new Entry(5f, 5));*/
/*
        ArrayList<Entry> entries2 = new ArrayList<>();
        entries2.add(new Entry(1f, 0));
        entries2.add(new Entry(5f, 1));
        entries2.add(new Entry(6f, 2));
        entries2.add(new Entry(3f, 3));
        entries2.add(new Entry(4f, 4));
        entries2.add(new Entry(8f, 5));*/

        RadarDataSet dataset_comp1 = new RadarDataSet(yVals1, "Company1");
    //    RadarDataSet dataset_comp2 = new RadarDataSet(entries2, "Company2");

        dataset_comp1.setColor(Color.CYAN);
        dataset_comp1.setDrawFilled(true);

    //    dataset_comp2.setColor(Color.RED);
    //    dataset_comp2.setDrawFilled(true);


        ArrayList<IRadarDataSet> dataSets = new ArrayList<IRadarDataSet>();
        dataSets.add(dataset_comp1);
    //    dataSets.add(dataset_comp2);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Communication");
        labels.add("Technical Knowledge");
        labels.add("Team Player");
        labels.add("Meeting Deadlines");
        labels.add("Problem Solving");
        labels.add("Punctuality");
        labels.add("Problem 2");
        labels.add("Punctuality2");

        RadarData data = new RadarData(labels,dataSets);
        chart.setData(data);

        String description = "Employee-Skill Analysis (scale of 1-10), 10 being the highest";
        chart.setDescription(description);
        chart.setWebLineWidthInner(0.2f);
        chart.setDescriptionColor(Color.RED);
        
        //chart.setSkipWebLineCount(10);
        chart.invalidate();
        chart.animate();

        dataset_comp1.setColors(colors);

    }

 
}
