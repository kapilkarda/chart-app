package com.engineermaster.demoapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.engineermaster.demoapp.database.OpenHelper;

/**
 * Created by Gopal on 02-06-2016.
 */
public class LoginActivity extends AppCompatActivity {

    static String DATABASE_NAME="color.db";
    String TABLE_NAME="stud";

    String Col1_name="Name";
    String Col2_rollno="RollNo";
    String Col3_per="Percentage";
    String Col4_class="Class";
    String Col5_div="Divison";
    static int VERSION=1;

    OpenHelper myHelper;

    SQLiteDatabase db;

    EditText user_name,emailid;
    CheckBox user_data_chkbox,newsletter_chkbox;
    Button login_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        user_name=(EditText)findViewById(R.id.user_name);
        emailid=(EditText)findViewById(R.id.email);
        user_data_chkbox=(CheckBox)findViewById(R.id.user_chk_box);
        newsletter_chkbox=(CheckBox)findViewById(R.id.newsleter_chk_box);
        login_btn=(Button)findViewById(R.id.login_btn);

        db = openOrCreateDatabase("detail",MODE_PRIVATE,null);
        db.execSQL("create table if not exists login(name varchar,email varchar)");

        myHelper=new OpenHelper(this, DATABASE_NAME, null, VERSION);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String username= user_name.getText().toString();
                String email=emailid.getText().toString();

        //        myHelper.insertData(username,email);


                db.execSQL("insert into login values('"+username+"','"+email+"')");
                db.close();

                Intent i=new Intent(LoginActivity.this,StartActivity.class);
                startActivity(i);
            }
        });


    }
}
