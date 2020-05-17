package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//AppcompatActivity(화면에 필요한 기능들이 들어있음)를 상속하는 메인엑티비티
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v("메인 엑티비티","create");
        //부모클래스의 동일메서드 호출
            super.onCreate(savedInstanceState);
            //XML레이아웃과(로그인 레이아웃) 소스코드를 setContenView를 이용해 연결
            setContentView(R.layout.activity_login);
            final EditText nametext = (EditText) findViewById(R.id.id_text1);
            final EditText passwordtext = (EditText) findViewById(R.id.login_password1);
            final TextView find_pass = (TextView) findViewById(R.id.login_findpassword1);
            final TextView sign_up = (TextView) findViewById(R.id.sign_up1) ;
            Button loginbutton = (Button) findViewById(R.id.login_button1);

        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), basic_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });
        find_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), find_password.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });



    }

    @Override
    protected void onResume() {
        Log.v("메인 엑티비티","Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("메인 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("메인 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("메인 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("메인 엑티비티","Pause");
        super.onPause();
    }
}
