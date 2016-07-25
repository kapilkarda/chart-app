package com.engineermaster.demoapp;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.engineermaster.demoapp.DBHelper.MchartDBAdapter;
import com.engineermaster.demoapp.MessageHelper.MessageH;
import com.engineermaster.demoapp.staticVar.StaticVar;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Gopal on 03-06-2016.
 */
public class ChartActivity extends Activity{

    MchartDBAdapter dbAdapter;
    SQLiteDatabase db;
    PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pai_chart);

         dbAdapter=new MchartDBAdapter(ChartActivity.this);
         pieChart = (PieChart) findViewById(R.id.chart);

        pieChart.setHighlightPerTapEnabled(true);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(60);
        pieChart.setHoleRadius(0f);
        pieChart.setTransparentCircleRadius(0f);
        pieChart.setDrawCenterText(true);
        pieChart.setRotationAngle(0);
        // enable rotation of the chart by touch
        pieChart.setRotationEnabled(true);
     //   pieChart.setHighlightPerTapEnabled(true);
        pieChart.setTouchEnabled(false);



        float[] item=new float[7];
        ArrayList<Integer> colors = new ArrayList<Integer>();


        ArrayList<HashMap<String, String>> getData = dbAdapter.getAllData();

        for(int i=0;i<getData.size();i++){
            HashMap<String, String> showData = getData.get(i);
            if(showData!=null){
                //MessageH.message(ChartActivity.this,showData.get("color_c"));

                String color=showData.get("color_c");
                String spin=showData.get("pos");
                Log.d("color",color);
                Log.d("spin",spin);
            }
        }


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
                yVals1.add(new Entry(item[i],i));


                Log.d("ids", ids);
                Log.d("colorcodes", colorcodes);

                i++;
                cursor.moveToNext();
            }
        }




        /*for (int i = 0; i < spin.length; i++) {
            Toast.makeText(ChartActivity.this,""+spin,Toast.LENGTH_LONG).show();
            yVals1.add(new Entry(spin[i], i));
        }*/
       /* ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(2f, 0));
        entries.add(new Entry(1f, 1));
        entries.add(new Entry(2f, 2));
        entries.add(new Entry(1f, 3));
        entries.add(new Entry(1f, 4));
        entries.add(new Entry(1f, 5));
        entries.add(new Entry(1f, 6));
        entries.add(new Entry(1f, 7));*/

        PieDataSet dataset = new PieDataSet(yVals1, "# of Calls");

      /* ArrayList<String> xVals = new ArrayList<String>();
        for (int i = 0; i < StaticVar.colorcode1.length; i++)
            xVals.add(StaticVar.colorcode1[i]);*/

        ArrayList<String> labels = new ArrayList<String>();

        labels.add("DarkRed");
        labels.add("LightRed");
        labels.add("Orange");
        labels.add("Yellow");
        labels.add("Green");
        labels.add("Blue");
        labels.add("LightViolet");
        labels.add("DarkViolet");

        PieData data = new PieData(labels, dataset); // initialize Piedata
        pieChart.setData(data);
        pieChart.setDescription("Description");  // set the description
     //   pieChart.animateY(1000);
    //    dataset.setColors(ColorTemplate.COLORFUL_COLORS); // set the color\
      //  pieChart.setBackgroundColor(Color.BLACK);




          dataset.setColors(colors);
      //  dataset.setSliceSpace(20);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent i = new Intent(this,LoginActivity.class);
        startActivity(i);

        finish();

    }
}
