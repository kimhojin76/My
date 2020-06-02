package com.example.myapplication7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class basic_activity extends AppCompatActivity
        implements View.OnClickListener {
    public String PREFERENCE = "com.studio572.samplesharepreference";
    String DATE;
    FoodAdapter2 morning_adapter,lunch_adapter,dinner_adapter,snack_adapter;


    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.basic);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        String ID = "admin";
        String NICKNAME = "관리자";
        edit.putString("ID",ID);
        edit.commit();

        edit.putString(ID+"NICKNAME",NICKNAME);

        edit.commit();
        DATE = pref.getString(ID+"date","");




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
//        ProgressBar basic_in_seekBar1 = (ProgressBar) findViewById(R.id.basic_in_seekBar1);
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

        //유저 식단 칼로리 입력
        basic_intext1.setText(user_meal_kcal);
        //유저 최대 영양소수치 셋팅
        basic_intext12.setText(max_car);
        basic_intext15.setText(max_pro);
        basic_intext18.setText(max_fat);
//프로그래스바 최대 수치 입력
        try {//String Type을 Date 타입으로 변환하면서 생기는 예외로 인한 오류 방지
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date firstdate = format2.parse(diet_date);
            Log.v("베이직 엑티비티",format2.parse(diet_date)+"다이어트 시작일 확인");
            Date currentTime = Calendar.getInstance().getTime();
            String nowdate = format2.format(currentTime);
            long calDate = currentTime.getTime() - firstdate.getTime();

            // Date.getTime() 은 해당날짜를 기준으로1970년 00:00:00 부터 몇 초가 흘렀는지를 반환해준다.
            // 이제 24*60*60*1000(각 시간값에 따른 차이점) 을 나눠주면 일수가 나온다.
            long calDateDays = calDate / ( 24*60*60*1000);
            Log.v("베이직 엑티비티",calDate+"다이어트 시작일 확인");

            calDateDays = Math.abs(calDateDays);
            Log.v("베이직 엑티비티",calDateDays+"다이어트 시작일 확인");
            double now_dday = Double.parseDouble(diet_maxdate)-calDateDays;
            basic_intext3.setText(Double.toString(now_dday));
            basic_in_seekBar3.setProgress((int)calDateDays);


            Log.v("베이직 엑티비티",format2.format(currentTime)+"현재일 확인");


        }
        catch (ParseException e)
        {}



        basic_in_seekBar2.setMax(Integer.parseInt(max_kcal));
        basic_in_seekBar3.setMax(Integer.parseInt(diet_maxdate));
        basic_in_seekBar4.setMax(Integer.parseInt(max_car));
        basic_in_seekBar5.setMax(Integer.parseInt(max_pro));
        basic_in_seekBar6.setMax(Integer.parseInt(max_fat));

        Log.v("베이직 엑티비티",ID+"입력확인");



        String gson_morning_adapter = pref.getString(ID+DATE+"gson_morning_adapter","");
        String gson_lunch_adapter = pref.getString(ID+DATE+"gson_lunch_adapter","");
        String gson_dinner_adapter = pref.getString(ID+DATE+"gson_dinner_adapter","");
        String gson_snack_adapter = pref.getString(ID+DATE+"gson_snack_adapter","");
        Gson gson = new Gson();
        double user_date_meal_kcal = 0;
        double user_date_meal_car = 0;
        double user_date_meal_pro = 0;
        double user_date_meal_fat = 0;

        double user_morning_kcal = 0;
        double user_morning_car = 0;
        double user_morning_pro = 0;
        double user_morning_fat = 0;

        double user_lunch_kcal = 0;
        double user_lunch_car = 0;
        double user_lunch_pro = 0;
        double user_lunch_fat = 0;

        double user_dinner_kcal = 0;
        double user_dinner_car = 0;
        double user_dinner_pro = 0;
        double user_dinner_fat = 0;

        double user_snack_kcal = 0;
        double user_snack_car = 0;
        double user_snack_pro = 0;
        double user_snack_fat = 0;
        morning_adapter = new FoodAdapter2();
        lunch_adapter = new FoodAdapter2();
        dinner_adapter = new FoodAdapter2();
        snack_adapter = new FoodAdapter2();
        if(gson_morning_adapter != ""){
            ArrayList<Food> morninglist = gson.fromJson(gson_morning_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
//            ArrayList<Food> dinnerlist = gson.fromJson(gson_dinner_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
//            ArrayList<Food> snacklist = gson.fromJson(gson_snack_adapter,new TypeToken<ArrayList<Food>>(){}.getType());

            morning_adapter.items = morninglist;
            Log.v("베이직 엑티비티 리줌",gson_morning_adapter);
            for (int i = 0; i < morninglist.size(); i++) {
                Food item1 = morning_adapter.getItem(i);
                Log.v("식단입력 엑티비티", item1.getName());
                user_morning_car = user_morning_car + Double.parseDouble(item1.getCar());
                user_morning_pro = user_morning_pro + Double.parseDouble(item1.getPro());
                user_morning_fat = user_morning_fat + Double.parseDouble(item1.getFat());
                user_morning_kcal = user_morning_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        if(gson_lunch_adapter != ""){
            ArrayList<Food> lunchlist = gson.fromJson(gson_lunch_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            lunch_adapter.items = lunchlist;
            for (int i = 0; i < lunchlist.size(); i++) {
                Food item1 = lunch_adapter.getItem(i);
                user_lunch_car = user_lunch_car + Double.parseDouble(item1.getCar());
                user_lunch_pro = user_lunch_pro + Double.parseDouble(item1.getPro());
                user_lunch_fat = user_lunch_fat + Double.parseDouble(item1.getFat());
                user_lunch_kcal = user_lunch_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        if(gson_dinner_adapter != ""){
            ArrayList<Food> lunchlist = gson.fromJson(gson_dinner_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            dinner_adapter.items = lunchlist;
            for (int i = 0; i < lunchlist.size(); i++) {
                Food item1 = dinner_adapter.getItem(i);
                user_dinner_car = user_dinner_car + Double.parseDouble(item1.getCar());
                user_dinner_pro = user_dinner_pro + Double.parseDouble(item1.getPro());
                user_dinner_fat = user_dinner_fat + Double.parseDouble(item1.getFat());
                user_dinner_kcal = user_dinner_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        if(gson_snack_adapter != ""){
            ArrayList<Food> lunchlist = gson.fromJson(gson_snack_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            snack_adapter.items = lunchlist;
            for (int i = 0; i < lunchlist.size(); i++) {
                Food item1 = snack_adapter.getItem(i);
                user_snack_car = user_snack_car + Double.parseDouble(item1.getCar());
                user_snack_pro = user_snack_pro + Double.parseDouble(item1.getPro());
                user_snack_fat = user_snack_fat + Double.parseDouble(item1.getFat());
                user_snack_kcal = user_snack_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        user_date_meal_kcal = user_morning_kcal+user_lunch_kcal+user_dinner_kcal+user_snack_kcal;
        user_date_meal_car = user_morning_car+user_lunch_car+user_dinner_car+user_snack_car;
        user_date_meal_pro = user_morning_pro+user_lunch_pro+user_dinner_pro+user_snack_pro;
        user_date_meal_fat = user_morning_fat+user_lunch_fat+user_dinner_fat+user_snack_fat;
        //섭취칼로리량
        basic_intext1.setText(String.format("%.0f", user_date_meal_kcal));
        basic_in_seekBar2.setProgress(Integer.parseInt(basic_intext1.getText().toString()));

        //잔여 칼로리량
        double kcal = Double.parseDouble(max_kcal)-user_date_meal_kcal;
        if (kcal < 0) {
            Math.abs(kcal);
            basic_intext2.setText(String.format("%.0f", Math.abs(kcal)));
            basic_intext2.setTextColor(Color.parseColor("#ff0000"));

        }else{
            basic_intext2.setText(String.format("%.0f", kcal));

        }

        //탄수화물 현재 식단 수치
        basic_intext10.setText(String.format("%.0f", user_date_meal_car));
        basic_in_seekBar4.setProgress(Integer.parseInt(basic_intext10.getText().toString()));

        //단백질 현재 식단 수치
        basic_intext13.setText(String.format("%.0f", user_date_meal_pro));
        basic_in_seekBar5.setProgress(Integer.parseInt(basic_intext13.getText().toString()));

        //지방 현재 식단 수치
        basic_intext16.setText(String.format("%.0f", user_date_meal_fat));
        basic_in_seekBar6.setProgress(Integer.parseInt(basic_intext16.getText().toString()));

        Log.v("식단입력 엑티비티", Double.toString(user_date_meal_kcal));












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
