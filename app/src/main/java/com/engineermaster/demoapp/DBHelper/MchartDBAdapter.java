package com.engineermaster.demoapp.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.engineermaster.demoapp.MessageHelper.MessageH;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Gopal on 04-06-2016.
 */
public class MchartDBAdapter  {
    MchartDB mchartDB;

    public MchartDBAdapter(Context context){
     mchartDB=new MchartDB(context);
    }

     public long insertValues(String color_code,String code_pos){
         SQLiteDatabase db = mchartDB.getWritableDatabase();
         ContentValues contentValues=new ContentValues();
         contentValues.put(MchartDB.COLOR_CODE,color_code);
         contentValues.put(MchartDB.SPINNER_ID,code_pos);
         long id=db.insert(MchartDB.TABLE_NAME,null,contentValues);
         db.close();
         return id;
     }

    public ArrayList<HashMap<String,String>> getAllData(){
        ArrayList<HashMap<String,String>> hashMaps=new ArrayList<>();
        SQLiteDatabase db = mchartDB.getWritableDatabase();
        String [] columns={MchartDB.UID,MchartDB.COLOR_CODE,MchartDB.SPINNER_ID};
        Cursor c=db.query(MchartDB.TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext()) {

       //     int i = 0;

      //      if (i<=7) {

                int id = c.getInt(0);
                String color_c = c.getString(1);
                String pos = c.getString(2);
                HashMap<String, String> stringStringHashMap = new HashMap<>();
                stringStringHashMap.put("color_c", color_c);
                stringStringHashMap.put("pos", pos);
                hashMaps.add(stringStringHashMap);
          //  }
        }
    return  hashMaps;
    }
    public static class MchartDB extends  SQLiteOpenHelper{

        private static final String DATABASE_NAME = "MCHART";
        private static final int DATABASE_VERSION = 5;
        private static final String TABLE_NAME = "PIECHART";
        private static final String UID = "_id";
        private static final String COLOR_CODE = "Color";
        private static final String SPINNER_ID = "SPId";
        private static final String CREATE_TABLE = "CREATE TABLE " +TABLE_NAME+ "(" +UID+ " INTEGER PRIMARY KEY AUTOINCREMENT , " +COLOR_CODE+ " VARCHAR , " +SPINNER_ID+ " VARCHAR );";
//        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "( " + UID +" INTEGER PRIMARY KEY AUTOINCREMENT , " +KEY_IMAGE+ " BLOB );";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS" + TABLE_NAME;
        private Context mContext;

        public MchartDB(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.mContext = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (SQLException e) {
                MessageH.message(mContext, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (SQLException e) {
                MessageH.message(mContext, "" + e);
            }

        }
    }
}
