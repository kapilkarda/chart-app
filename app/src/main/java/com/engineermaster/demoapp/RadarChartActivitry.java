
package com.engineermaster.demoapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import com.engineermaster.demoapp.DBHelper.MchartDBAdapter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendPosition;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

public class RadarChartActivitry extends AppCompatActivity {

    private RadarChart mChart;
    private Typeface tf;
    SQLiteDatabase db;
    MchartDBAdapter dbAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_main);

        mChart = (RadarChart) findViewById(R.id.chart);


        mChart.setDescription("");

        mChart.setWebLineWidth(1.5f);
        mChart.setWebLineWidthInner(0.75f);
        mChart.setWebAlpha(100);

        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it


        setData();

     /*   mChart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(tf);
        xAxis.setTextSize(9f);

        YAxis yAxis = mChart.getYAxis();
        yAxis.setTypeface(tf);
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(9f);
        yAxis.setAxisMinValue(0f);

        Legend l = mChart.getLegend();
        l.setPosition(LegendPosition.RIGHT_OF_CHART);
        l.setTypeface(tf);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(5f);*/
    }


    private String[] mParties = new String[]{
            "DarkRed", "LightRed", "Orange", "Yellow", "Green", "Blue", "LightViolet", "DarkViolet"
    };

    public void setData() {
        dbAdapter=new MchartDBAdapter(RadarChartActivitry.this);
        float[] item=new float[7];
        ArrayList<Integer> colors = new ArrayList<Integer>();
        ArrayList<Entry> yVals1 = new ArrayList<Entry>();

        db = openOrCreateDatabase("MCHART",MODE_PRIVATE,null);
        //  Cursor cursor=db.rawQuery("SELECT * FROM PIECHART ORDER BY _id DESC LIMIT 8",null);
        Cursor cursor = db.rawQuery("select * from (SELECT * FROM PIECHART ORDER BY _id DESC LIMIT 8)order by _id ASC;" ,null);//piechart
        cursor.moveToFirst();

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

        ArrayList<String> xVals = new ArrayList<String>();

        for (int i = 0; i <=7; i++)
          //  xVals.add(mParties[i % mParties.length]);
            xVals.add(mParties[i]);

        RadarDataSet set1 = new RadarDataSet(yVals1, "Set 1");
        set1.setColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        set1.setFillColor(ColorTemplate.VORDIPLOM_COLORS[0]);
        set1.setDrawFilled(true);
        set1.setLineWidth(2f);


        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);

        RadarData data = new RadarData(xVals, sets);

        data.setValueTypeface(tf);
        data.setValueTextSize(8f);
        data.setDrawValues(false);

        mChart.setData(data);
        set1.setColors(colors);

        mChart.invalidate();
    }
}
