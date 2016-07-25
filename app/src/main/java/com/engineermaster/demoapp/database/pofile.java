package com.engineermaster.demoapp.database;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.engineermaster.demoapp.R;

public class pofile extends Activity {
 Button b1;
 EditText t1;
 TextView t2,t3,t4;
 SQLiteDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
	setContentView(R.layout.profile);

	db = openOrCreateDatabase("detail",MODE_PRIVATE,null);

	b1 = (Button)findViewById(R.id.button1);
	b1.setOnClickListener(new OnClickListener() {
	
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			t1 = (EditText)findViewById(R.id.editText1);
			t2 = (TextView)findViewById(R.id.textView2);
			t3 = (TextView)findViewById(R.id.textView3);
		//	t4 = (TextView)findViewById(R.id.textView4);
			String name1 = t1.getText().toString();
			Cursor cursor = db.rawQuery("select * from stud where colorc = '"+name1+"'",null);
			cursor.moveToFirst();
			
			while(!cursor.isAfterLast()){
				String pass = cursor.getString(0);
				String add = cursor.getString(1);
			//	String email = cursor.getString(3);
				
				t2.setText(pass);
				t3.setText(add);
			//	t4.setText(email);
				
				cursor.moveToNext();
				
				
			}
		}
	});
	
	
	}
}
