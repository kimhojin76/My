package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signup_activity extends AppCompatActivity
        implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.acrivi_sign_up);
        Button id_test_button = (Button) findViewById(R.id.button9);
        id_test_button.setOnClickListener(this);
        Button signup_activity_button = (Button) findViewById(R.id.button3);
        signup_activity_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button9){
            Toast.makeText(signup_activity.this, "아이디 중복 확인",Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.button3){
            Toast.makeText(signup_activity.this, "회원가입 되었습니다.",Toast.LENGTH_SHORT).show();
        }
    }
}
