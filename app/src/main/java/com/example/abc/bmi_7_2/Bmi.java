package com.example.abc.bmi_7_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bmi extends AppCompatActivity implements View.OnClickListener {

    private EditText field_height;
    private EditText field_weight;
    private Button submit;
    private static final String TAG = "LifeCycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Bmi-onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        findViews();
        setListeners();
        restorePrefs();
    }

    @Override
    protected void onStart() {
        Log.d(TAG,"Bmi-onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"Bmi-onResume()");
        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.d(TAG,"Bmi-onStop()");
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"Bmi-onRestart()");
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"Bmi-onDestroy()");
        super.onDestroy();
    }

    private void findViews(){
        submit = findViewById(R.id.submit);
        field_height = findViewById(R.id.field_height);
        field_weight = findViewById(R.id.field_weight);
    }

    private void setListeners(){
        submit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(Bmi.this,Report.class);
        Bundle bundle = new Bundle();
        bundle.putString("KEY_HEIGHT",field_height.getText().toString());
        bundle.putString("KEY_WEIGHT",field_weight.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public static final String PREF = "BMI_PREF";
    public static final String PREF_HEIGHT = "BMI_Height";

    // Restore preferences
    private void restorePrefs() {
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        String pref_height = settings.getString(PREF_HEIGHT, "");
        if (!"".equals(pref_height))
        {
            field_height.setText(pref_height);
            field_weight.requestFocus();
        }
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"Bmi-onPause()");
        super.onPause();
        // Save user preferences. use Editor object to make changes.
        SharedPreferences settings = getSharedPreferences(PREF, 0);
        settings.edit().putString(PREF_HEIGHT, field_height. getText().toString()).commit();
    }
}