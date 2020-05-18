package com.example.myapplication7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class find_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){

        Log.v("비번찾기 엑티비티","create");
        super.onCreate(bundle);
        setContentView(R.layout.activity_find_password);

    }
    protected void onResume() {
        Log.v("비번찾기 엑티비티","Resume");
        super.onResume();
    }
    @Override
    protected void onStart() {
        Log.v("비번찾기 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("비번찾기 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("비번찾기 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("비번찾기 엑티비티","Pause");
        super.onPause();
    }
}
