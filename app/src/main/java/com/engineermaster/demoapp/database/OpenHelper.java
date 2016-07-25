package com.engineermaster.demoapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class OpenHelper extends SQLiteOpenHelper {
	
	static String DATABASE_NAME="color.db";
	String TABLE_NAME="stud";
	String TABLENAME2="colortable";

	static int VERSION=1;
	
	String Col1_name="Name";
	String Col2_rollno="RollNo";
	String Col3_per="Percentage";
	String Col4_class="Class";
	String Col5_div="Divison";
	
//	String SCRIPT="create table stud(Name TEXT,RollNo INTEGER,Percentage FLOAT, Class TEXT,Divison TEXT)";

	String SCRIPT="create table stud(Name TEXT,Email TEXT)";

//	String COLOR="create table colortable(ColorName TEXT,SpinnerItem TEXT)";

	public OpenHelper(Context context, String name, CursorFactory factory,
					  int version) {
		super(context, DATABASE_NAME, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(SCRIPT);
	//	db.execSQL(COLOR);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
	public void insertData(String aname, String email)
	{
		Log.d("insert",aname);

		SQLiteDatabase sqldb=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("Name", aname);
		values.put("Email", email);
		sqldb.insert("stud", null, values);
		Log.d("Data Inserted", "<<<<<<<<<"+values);
		sqldb.close();
		
	}

	public Cursor select(String aname)
	{
		SQLiteDatabase sqldb=this.getWritableDatabase();
		
		String query="select * from stud where name=? ";
		 Cursor c=sqldb.rawQuery(query, new String[]{aname});
		 if(c.getCount()!=0)
		 {
		 return c;
		 }
		 return null;
		
	}
	public Cursor fullselect()
	{
		SQLiteDatabase sqldb=this.getWritableDatabase();
		
		String query="select * from stud ";
		 Cursor c=sqldb.rawQuery(query, null);
		 if(c.getCount()!=0)
		 {
		 return c;
		 }
		 return null;
		
	}
	
	public void delete(String aname)
	{
		SQLiteDatabase sqldb=this.getWritableDatabase();
		
		sqldb.delete("stud", "name=?", new String[] {aname});
			
	}
	
	public void update(String aname, int arollno, float aper, String aclass, String adivison)
	{
		SQLiteDatabase sqldb=this.getWritableDatabase();
		ContentValues values=new ContentValues();
		values.put("Name", aname);
		values.put("RollNo", arollno);
		values.put("Percentage", aper);
		values.put("Class", aclass);
		values.put("Divison", adivison);
		
		sqldb.update("stud", values, "name=?", new String[]{aname});
	
	}
	
	
	public void deleteAll()
	{
		Log.v("tushar","delete All......");
		SQLiteDatabase sqldb=this.getWritableDatabase();
	    //SQLiteDatabase db = this.getWritableDatabase();
	   // db.delete(TABLE_NAME,null,null);
	    //db.execSQL("delete * from"+ TABLE_NAME);
		sqldb.execSQL("delete from "+ TABLE_NAME);
		sqldb.close();
	}


}
