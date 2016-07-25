package com.engineermaster.demoapp.Logintest2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.engineermaster.demoapp.LoginActivity;
import com.engineermaster.demoapp.R;
import com.engineermaster.demoapp.StartActivity;
import com.engineermaster.demoapp.Utility.Utility;
import com.engineermaster.demoapp.database.OpenHelper;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Gopal on 27-06-2016.
 */
public class LoginActivity2 extends AppCompatActivity {

    int chk_click=0,chk_click2=0;
   public static String use_data,news;
    public static String login_email;

    CheckBox user_chk_box,newsleter_chk_box;

    String final_username,final_email;
   /* OpenHelper myHelper;
    SQLiteDatabase db;
    static String DATABASE_NAME="logindetail.db";
    static int VERSION=1;*/

    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;

    @Bind(R.id.input_email)
    EditText _emailText;

    @Bind(R.id.input_username)
    EditText _username;

    @Bind(R.id.btn_login)
    Button _loginButton;
  /*  @InjectView(R.id.link_signup)
    TextView _signupLink;*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity2);
        ButterKnife.bind(this);


        newsleter_chk_box=(CheckBox)findViewById(R.id.newsleter_chk_box);

        user_chk_box=(CheckBox)findViewById(R.id.user_chk_box);
        user_chk_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chk_click=1;

                if (user_chk_box.isChecked()){

                  //  Utility.setStringPreferences(LoginActivity2.this,"usedata", "Use Data");

                    use_data="Use Data";
                    chk();
                }
                else {
                    use_data="";
                }

            }
        });

        newsleter_chk_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chk_click2=1;

                if(newsleter_chk_box.isChecked()){

                //    Utility.setStringPreferences(LoginActivity2.this,"news", "Newsletter");
                    news="Newsletter";
                }
                else {
                    news="";
                }
            }
        });

  /*      db = openOrCreateDatabase("detail",MODE_PRIVATE,null);
        db.execSQL("create table if not exists login(name varchar,email varchar)");
        myHelper=new OpenHelper(this, DATABASE_NAME, null, VERSION);*/


        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                login();
            }
        });
/*
        _signupLink.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
            }
        });*/
    }

    private void chk() {

    }


    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(LoginActivity2.this);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Please wait...");
        progressDialog.show();


        String password = _username.getText().toString();
        String email = _emailText.getText().toString();

        // TODO: Implement your own authentication logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        onLoginSuccess();
                        // onLoginFailed();
                        progressDialog.dismiss();
                    }
                }, 3000);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SIGNUP) {
            if (resultCode == RESULT_OK) {

                // TODO: Implement successful signup logic here
                // By default we just finish the Activity and log them in automatically
                this.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(true);

        final_username = _username.getText().toString();
        final_email = _emailText.getText().toString();


        Utility.setStringPreferences(LoginActivity2.this,"username",final_username);
        Utility.setStringPreferences(LoginActivity2.this,"email",final_email);


        login_email=final_email;

        if(chk_click==0){

            use_data="";
        }
        if(chk_click2==0){
            news="";
        }

        Intent i=new Intent(LoginActivity2.this,StartActivity.class);
        startActivity(i);

        finish();
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;


        String password = _username.getText().toString();
        String email = _emailText.getText().toString();

     //   if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())    //for mail addres bst code

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {

            _emailText.setError("enter a valid email address");
            valid = false;
        }
        else {
            _emailText.setError(null);
        }

        if (password.isEmpty()) {
            _username.setError("Please enter name");
            valid = false;
        } else {
            _username.setError(null);
        }

        return valid;
    }
}