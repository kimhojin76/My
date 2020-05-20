package com.example.myapplication7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class profile_activity extends AppCompatActivity
        implements View.OnClickListener{
    static final int REQUEST_IMAGE_GET = 1;

//f

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("회원가입 엑티비티","create");

        super.onCreate(bundle);
        setContentView(R.layout.activity_profile);

    }

    @Override
    public void onClick(View v) {

        }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);







        }
        // 그림이 정상적으로 선택되면


    @Override
    protected void onResume() {
        Log.v("회원가입 엑티비티","Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("회원가입 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("회원가입 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("회원가입 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("회원가입 엑티비티","Pause");
        super.onPause();
    }
}
