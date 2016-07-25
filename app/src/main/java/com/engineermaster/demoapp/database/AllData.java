package com.engineermaster.demoapp.database;




import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.engineermaster.demoapp.R;
import com.engineermaster.demoapp.staticVar.StaticVar;

public class AllData extends Activity{
	SQLiteDatabase db;
	TextView t2,t3,t4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alldata);

		db = openOrCreateDatabase("detail",MODE_PRIVATE,null);

	 
		Cursor cursor = db.rawQuery("select * from stud" ,null);
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()){
			String pass = cursor.getString(0);
			String add = cursor.getString(1);

	/*		StaticVar.alldatacolor=cursor.getString(0);
			StaticVar.alldataitem=cursor.getColumnName(1);*/

			cursor.moveToNext();
			

		}

	}

}
