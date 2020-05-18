package com.example.myapplication7;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup_activity extends AppCompatActivity
        implements View.OnClickListener{
    static final int REQUEST_IMAGE_GET = 1;

//f

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("회원가입 엑티비티","create");

        super.onCreate(bundle);
        setContentView(R.layout.acrivi_sign_up);

        final Button image_button = (Button) findViewById(R.id.image_upload_button);
        image_button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("비번찾기 엑티비티","이미지 업로드 버튼 클릭");

            }
        });

        Button id_test_button = (Button) findViewById(R.id.button9);
        id_test_button.setOnClickListener(this);
        Button signup_activity_button = (Button) findViewById(R.id.button3);
        signup_activity_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button9){
            Toast.makeText(signup_activity.this, "아이디 중복 확인",Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.button3) {
            Toast.makeText(signup_activity.this, "회원가입 되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }
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
