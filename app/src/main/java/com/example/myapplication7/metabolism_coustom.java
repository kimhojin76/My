package com.example.myapplication7;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class metabolism_coustom extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("활동관리커스텀 엑티비티","create");
        super.onCreate(bundle);
        setContentView(R.layout.metabolism_coustom);

    }

    @Override
    protected void onResume() {
        Log.v("활동관리커스텀 엑티비티","Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("활동관리커스텀 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("활동관리커스텀 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("활동관리커스텀 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("활동관리커스텀 엑티비티","Pause");
        super.onPause();
    }
}
