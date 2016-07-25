package com.engineermaster.demoapp.database;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.engineermaster.demoapp.R;

public class ViewDetail extends Activity {
    /** Called when the activity is first created. */
	
	static String DATABASE_NAME="color.db";
	String TABLE_NAME="stud";

	String Col1_name="Name";
	String Col2_rollno="RollNo";
	String Col3_per="Percentage";
	String Col4_class="Class";
	String Col5_div="Divison";
	static int VERSION=1;
	
	OpenHelper myHelper;
	Button view;
	EditText name;
	TextView res;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewdetail);
        
        view=(Button)findViewById(R.id.view);
        
        name=(EditText)findViewById(R.id.name);
        res=(TextView)findViewById(R.id.res);
        	
		myHelper=new OpenHelper(this, DATABASE_NAME, null, VERSION);
        view.setOnClickListener(btn);
        
	}
    
    
    OnClickListener btn=new OnClickListener()
    {

		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String aname=name.getText().toString();

			Cursor cur=myHelper.select(aname);
			if(cur==null)
			{
				Toast.makeText(getApplicationContext(), "No record found", Toast.LENGTH_LONG).show();
			}
			else
			{
			cur.moveToFirst();
			if(cur.getCount()!=0)
			{
				String s=cur.getString(cur.getColumnIndex("Name"));
				String s1= cur.getString(cur.getColumnIndex("Email"));
			/*	String s2= Float.toString(cur.getFloat(cur.getColumnIndex("Percentage")));
				String s3=cur.getString(cur.getColumnIndex("Class"));
				String s4=cur.getString(cur.getColumnIndex("Divison"))*/;
				
				Log.d("dkjghfdkjgfdg", ""+s+s1);
				res.setText(" Name : "+s+"\n Email : "+s1+"");
			}
			}
			
		}
    	
    };
}
