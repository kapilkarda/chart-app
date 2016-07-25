package com.engineermaster.demoapp.listener;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Gopal on 02-06-2016.
 */
public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public static String selectedItem ;

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        selectedItem = (String) parent.getItemAtPosition(pos);

      /*  Toast.makeText(parent.getContext(),
                "OnItemSelectedListener : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}