package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

//AppcompatActivity(화면에 필요한 기능들이 들어있음)를 상속하는 메인엑티비티
public class MainActivity extends AppCompatActivity {
    public String PREFERENCE = "com.studio572.samplesharepreference";
    SharedPreferences pref;
    EditText nametext,passwordtext;
    ArrayList<signup> list;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.v("메인 엑티비티","create");
        //부모클래스의 동일메서드 호출
            super.onCreate(savedInstanceState);
            //XML레이아웃과(로그인 레이아웃) 소스코드를 setContenView를 이용해 연결
            setContentView(R.layout.activity_login);
             nametext = (EditText) findViewById(R.id.id_text1);
            passwordtext = (EditText) findViewById(R.id.login_password1);
            final TextView find_pass = (TextView) findViewById(R.id.login_findpassword1);
            final TextView sign_up = (TextView) findViewById(R.id.sign_up1) ;
            Button loginbutton = (Button) findViewById(R.id.login_button1);
        pref =getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        Gson gson = new Gson();
        SharedPreferences.Editor edit = pref.edit();

        list = new ArrayList<signup>();
        if(pref.getString("ID_list", "").equals("")) {
            list.add(new signup("admin", "관리자", "0000", "crazybear1@naver.com", "content://com.android.providers.media.documents/document/image%3A16196"));
            String first = gson.toJson(list);
            Log.v("회원가입 엑티비티", first);
            edit.putString("ID_list", first);
            edit.commit();
        }
        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pref =getSharedPreferences(PREFERENCE,MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                Gson gson = new Gson();

                String list = pref.getString("ID_list","");
                if (!list.equals("")) {
                    ArrayList<signup> signuplist = gson.fromJson(list, new TypeToken<ArrayList<signup>>() {
                    }.getType());
                    boolean a = false;
                    for (int i = 0; i < signuplist.size(); i++) {
                        Log.v("로그인 엑티비티", nametext.getText().toString() + signuplist.get(i).getId());

                        if (nametext.getText().toString().equals(signuplist.get(i).getId())) {
                            Log.v("로그인 엑티비티", passwordtext.getText().toString() + signuplist.get(i).getPassword());
                            if (passwordtext.getText().toString().equals(signuplist.get(i).getPassword())) {
                                edit.putString("ID", signuplist.get(i).getId());
                                edit.commit();

                                String ID = pref.getString("ID", "");
                                edit.putString(ID + "NICKNAME", signuplist.get(i).getNickname());
                                edit.putString(ID + "EMAIL", signuplist.get(i).getEmail());
                                edit.putString(ID + "URI", signuplist.get(i).getImage_uri());
                                edit.putString(ID + "PASSWORD", signuplist.get(i).getPassword());
                                Log.v("로그인 엑티비티 로그인시점", signuplist.get(i).getNickname()+signuplist.get(i).getEmail()+signuplist.get(i).getPassword());

                                edit.commit();
                                a = true;

                                Intent intent = new Intent(getApplicationContext(), basic_activity.class);
                                startActivity(intent);
                                finish();
                            }

                        }
                    }
                    if (!a) {
                        Toast.makeText(MainActivity.this, "아이디,패스워드 정보를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "아이디,패스워드 정보를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }

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
