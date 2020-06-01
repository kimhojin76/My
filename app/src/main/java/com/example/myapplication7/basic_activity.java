package com.example.myapplication7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class basic_activity extends AppCompatActivity
        implements View.OnClickListener {
    public String PREFERENCE = "com.studio572.samplesharepreference";


    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.basic);

        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        String ID = "admin";
        edit.putInt("first",1);
        edit.putString("ID",ID);
        edit.commit();




        final TextView kcal = (TextView) findViewById(R.id.textView5);
        kcal.setOnClickListener(this);
        final TextView basic_food = (TextView) findViewById(R.id.textView8);
        basic_food.setOnClickListener(this);
        final TextView basic_graph = (TextView) findViewById(R.id.textView9);
        basic_graph.setOnClickListener(this);
        final TextView basic_main = (TextView) findViewById(R.id.textView10);
        basic_main.setOnClickListener(this);
        final TextView basic_forum = (TextView) findViewById(R.id.textView16);
        basic_forum.setOnClickListener(this);
        final ImageView basic_food_image = (ImageView) findViewById(R.id.imageView3);
        basic_food_image.setOnClickListener(this);
        final ImageView basic_graph_image = (ImageView) findViewById(R.id.imageView4);
        basic_graph_image.setOnClickListener(this);
        final ImageView basic_main_image = (ImageView) findViewById(R.id.imageView5);
        basic_main_image.setOnClickListener(this);
        final ImageView basic_kcal_image = (ImageView) findViewById(R.id.imageView6);
        basic_kcal_image.setOnClickListener(this);
        final ImageView basic_forum_image = (ImageView) findViewById(R.id.imageView7);
        basic_forum_image.setOnClickListener(this);
        final Button youtube_button1 = (Button) findViewById(R.id.youtube_button1);
        youtube_button1.setOnClickListener(this);
        final Button youtube_button2 = (Button) findViewById(R.id.youtube_button2);
        youtube_button2.setOnClickListener(this);
        final TextView in_profile = (TextView) findViewById(R.id.basic_in_profile);
        in_profile.setOnClickListener(this);
        final TextView logout = (TextView) findViewById(R.id.basic_in_logout);
        logout.setOnClickListener(this);


    }

    @Override
    //인터페이스 활용하여 클릭시 이곳으로 오게 하였음
    public void onClick(View v) {
        if(v.getId() == R.id.textView5){
            Intent intent = new Intent(basic_activity.this, bmr_activity.class);
            startActivity(intent);
            finish();

            //활동칼로리 계산
        }else if(v.getId() == R.id.textView8) {
            Intent intent = new Intent(basic_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        }else if(v.getId() == R.id.textView9) {
            Intent intent = new Intent(basic_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

        }
        //지금 속해있는 액티비티
        else if(v.getId() == R.id.textView10){



            //게시판 텍스트 클릭
        }else if(v.getId() == R.id.textView16) {
            Intent intent = new Intent(basic_activity.this, forum_activity.class);
            startActivity(intent);
            finish();


        }else if(v.getId() == R.id.imageView3) {
            Intent intent = new Intent(basic_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        }else if(v.getId() == R.id.imageView4) {
            Intent intent = new Intent(basic_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        }else if(v.getId() == R.id.imageView5) {


        }else if(v.getId() == R.id.imageView6) {
            Intent intent = new Intent(basic_activity.this, bmr_activity.class);
            startActivity(intent);
            finish();
        }else if(v.getId() == R.id.imageView7) {
            Intent intent = new Intent(basic_activity.this, forum_activity.class);
            startActivity(intent);
            finish();
        }else if(v.getId() == R.id.youtube_button1) {
            String url ="https://www.youtube.com/watch?v=By7i6rDTjLg&feature=youtu.be";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }else if(v.getId() == R.id.youtube_button2) {
            String url ="https://www.fatsecret.kr/%EC%B9%BC%EB%A1%9C%EB%A6%AC-%EC%98%81%EC%96%91%EC%86%8C/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }else if(v.getId() == R.id.basic_in_profile) {
            Intent intent = new Intent(basic_activity.this, profile_activity.class);
            startActivity(intent);
         }else if(v.getId() == R.id.basic_in_logout) {
            Intent intent = new Intent(basic_activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }



    @Override
    protected void onResume() {
        Log.v("베이직 엑티비티","Resume");
        super.onResume();
        Log.v("베이직 엑티비티","create");
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        String ID = pref.getString("ID","");

        edit.putString(ID+"user_act_kcal","");
        String  max_car = pref.getString(ID+"max_car","0");
        String  max_pro = pref.getString(ID+"max_pro","0");
        String  max_fat = pref.getString(ID+"max_fat","0");
        String  max_kcal = pref.getString(ID+"max_kcal","0");
        String  diet_date = pref.getString(ID+"다이어트시작일","0");
        String  diet_maxdate = pref.getString(ID+"다이어트기간","0");
        Log.v("베이직 엑티비티",diet_date+diet_maxdate);



        Log.v("베이직 엑티비티",pref.getString(ID+"_user_act_kcal",""));

        String user_act_kcal = pref.getString(ID+"user_act_kcal","");
        int user_d_day = pref.getInt(ID+"user_d_day",0);
        String user_meal_kcal = pref.getString(ID+"user_meal_kcal","0000");
        String user_meal_car = pref.getString(ID+"user_meal_car","0");
        String user_meal_pro = pref.getString(ID+"user_meal_pro","0");
        String user_meal_fat = pref.getString(ID+"user_meal_fat","0");
        ProgressBar basic_in_seekBar1 = (ProgressBar) findViewById(R.id.basic_in_seekBar1);
        ProgressBar basic_in_seekBar2 = (ProgressBar) findViewById(R.id.basic_in_seekBar2);
        ProgressBar basic_in_seekBar3 = (ProgressBar) findViewById(R.id.basic_in_seekBar3);

        ProgressBar basic_in_seekBar4 = (ProgressBar) findViewById(R.id.basic_in_seekBar4);
        ProgressBar basic_in_seekBar5 = (ProgressBar) findViewById(R.id.basic_in_seekBar5);
        ProgressBar basic_in_seekBar6 = (ProgressBar) findViewById(R.id.basic_in_seekBar6);

        //유저 식단 총합 칼로리
        TextView basic_intext1 = (TextView) findViewById(R.id.basic_intext1);
        //유저 잔여 칼로리(행동칼로리-식단칼로리)
        TextView basic_intext2 = (TextView) findViewById(R.id.basic_intext2);

        //유저 다이어트 d-day 알림
        TextView basic_intext3 = (TextView) findViewById(R.id.basic_intext3);
        basic_intext3.setText("");
        //유저 섭취 탄수화물/유저 설정상 최대 탄수화물
        TextView basic_intext10 = (TextView) findViewById(R.id.basic_intext10);
        TextView basic_intext12 = (TextView) findViewById(R.id.basic_intext12);
        //유저 섭취 단백질/유저 설정상 최대 단백질
        TextView basic_intext13 = (TextView) findViewById(R.id.basic_intext13);
        TextView basic_intext15 = (TextView) findViewById(R.id.basic_intext15);
        //유저 섭취 지방/유저 설정상 최대 지방
        TextView basic_intext16 = (TextView) findViewById(R.id.basic_intext16);
        TextView basic_intext18 = (TextView) findViewById(R.id.basic_intext18);

        basic_in_seekBar3.setMax(Integer.parseInt(diet_maxdate));
        basic_intext1.setText(user_meal_kcal);
        basic_intext12.setText(max_car);
        basic_intext15.setText(max_pro);
        basic_intext18.setText(max_fat);
        basic_intext2.setText(max_kcal);
//
        basic_in_seekBar2.setMax(Integer.parseInt(max_kcal));
        basic_in_seekBar4.setMax(Integer.parseInt(max_car));
        basic_in_seekBar5.setMax(Integer.parseInt(max_pro));
        basic_in_seekBar6.setMax(Integer.parseInt(max_fat));

        Log.v("베이직 엑티비티",ID+"입력확인");
    }

    @Override
    protected void onStart() {
        Log.v("베이직 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("베이직 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("베이직 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("베이직 엑티비티","Pause");
        super.onPause();
    }

}
