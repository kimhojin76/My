package com.example.myapplication7;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class forum_detail extends AppCompatActivity implements View.OnClickListener {
    String title,date,contents,nickname,ID,NICKNAME,position;
    RecyclerView recyclerView;
    repleadapter adapter;
    public String PREFERENCE = "com.studio572.samplesharepreference";
    EditText reple_input_edittext;
    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("포럼디테일 엑티비티", "create");
        super.onCreate(bundle);
        setContentView(R.layout.forum_item_detail);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        TextView title2= (TextView) findViewById(R.id.forum_detail_title);
        TextView nickname2= (TextView) findViewById(R.id.forum_detail_nickname);
        TextView date2= (TextView) findViewById(R.id.forum_detail_date);
        TextView contents2= (TextView) findViewById(R.id.forum_detail_contents);
        reple_input_edittext = (EditText) findViewById(R.id.reple_input_edittext);
        ImageView reple_input_image = (ImageView) findViewById(R.id.reple_input_image);
        reple_input_image.setOnClickListener(this);

        recyclerView = findViewById(R.id.reple_recyle);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new repleadapter();
        recyclerView.setAdapter(adapter);


        Log.v("포럼디테일 엑티비티", "인텐트 겟");
        Intent intent = getIntent();
        ID = pref.getString("ID","");
        NICKNAME = pref.getString(ID+"NICKNAME","");
        title = intent.getExtras().getString("제목");
        nickname=intent.getExtras().getString("닉네임");
        date=intent.getExtras().getString("날짜");
        contents=intent.getExtras().getString("내용");
        position = intent.getExtras().getString("포지션");

        title2.setText(title);
        nickname2.setText(nickname);
        date2.setText(date);
        contents2.setText(contents);
        Log.v("포럼디테일 엑티비티", "입력테스트");
//        adapter.addItem(new reple(NICKNAME,"",reple_input_edittext.getText().toString()));
//        recyclerView.setAdapter(adapter);

    }








    @Override
    protected void onResume() {
        Log.v("포럼디테일 엑티비티", "Resume");
        super.onResume();
        Gson gson = new Gson();
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        String gson_reple_adapter = pref.getString(NICKNAME+date+"gson_reple_adapter","");
        if(gson_reple_adapter !=""){
            ArrayList<reple> replelist = gson.fromJson(gson_reple_adapter,new TypeToken<ArrayList<reple>>(){}.getType());
            adapter.items = replelist;
//            recyclerView.setAdapter(adapter);


        }


    }

    @Override
    protected void onStart() {
        Log.v("포럼디테일 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("포럼디테일 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("포럼디테일 엑티비티", "Destroy");
        super.onDestroy();

    }

    protected void onPause() {
        Log.v("포럼디테일 엑티비티", "Pause");
        super.onPause();
        Intent intent = new Intent(forum_detail.this, forum_activity.class);
        intent.putExtra("리플수",Integer.toString(adapter.items.size()));
        intent.putExtra("포지션",position);
        Log.v("포럼엑티비티 게시글 클릭 포지션", position);
        Log.v("포럼엑티비티 게시글 클릭 리플 갯수", Integer.toString(adapter.items.size()));

        setResult(1031,intent);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        Gson gson = new Gson();
        String gson_reple_adapter = gson.toJson(adapter.items);
        //에디터에 json형식으로 변환된 객체값 집어넣기
        editor.putString(NICKNAME+date+"gson_reple_adapter",gson_reple_adapter);
        //쉐어드에 저장하기
        editor.commit();
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("포럼디테일 엑티비티", "도착");

//        if (requestCode==1011)
//        {
//            Log.v("포럼디테일 엑티비티", "조건문 도착");
//            Intent intent = data;
//            Log.v("포럼디테일 엑티비티", intent.getStringExtra("제목").toString());
//            Log.v("포럼디테일 엑티비티", intent.getStringExtra("닉네임").toString());
//            Log.v("포럼디테일 엑티비티", intent.getStringExtra("날짜").toString());
//            Log.v("포럼디테일 엑티비티", intent.getStringExtra("내용").toString());
//
//            title =intent.getStringExtra("제목").toString();
//            nickname=intent.getStringExtra("닉네임").toString();
//            date=intent.getStringExtra("날짜").toString();
//            contents=intent.getStringExtra("내용").toString();
//        }
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.reple_input_image) {
            Log.v("포럼엑티비티 게시글 클릭", "연필 이미지 클릭");

            long now = System.currentTimeMillis();
            Date mDate = new Date(now);
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String getTime = simpleDate.format(mDate);
            Log.v("포럼엑티비티 게시글 클릭", getTime);
            Log.v("포럼엑티비티 게시글 클릭", NICKNAME);
            Log.v("포럼엑티비티 게시글 클릭", reple_input_edittext.getText().toString());

            adapter.addItem(new reple(NICKNAME,getTime,reple_input_edittext.getText().toString()));
            recyclerView.setAdapter(adapter);
            SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
            SharedPreferences.Editor editor = pref.edit();
            Gson gson = new Gson();
            String gson_reple_adapter = gson.toJson(adapter.items);
            //에디터에 json형식으로 변환된 객체값 집어넣기
            editor.putString(NICKNAME+date+"gson_reple_adapter",gson_reple_adapter);
            //쉐어드에 저장하기
            editor.commit();
        }


//            Intent data = new Intent(forum_detail.this, meal.class);
//            data.putExtra("음식명",add_foodname.getText().toString());
//            data.putExtra("칼로리",add_kcal.getText().toString());
//            data.putExtra("탄수화물",add_car.getText().toString());
//            data.putExtra("단백질",add_pro.getText().toString());
//            data.putExtra("지방",add_fat.getText().toString());
//            setResult(200,data);
//            finish();

        }
    public void onBackPressed() {

        finish();
    }
    }

