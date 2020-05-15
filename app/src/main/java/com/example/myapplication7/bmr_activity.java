package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class bmr_activity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle bundle){
        super.onCreate(bundle);
        setContentView(R.layout.bmr_calculator);
        final TextView bmr_summation = (TextView) findViewById(R.id.bmr_textView2);
        bmr_summation.setOnClickListener(this);
        final TextView bmr_helper = (TextView) findViewById(R.id.bmr_textView5);
        bmr_helper.setOnClickListener(this);
        final TextView bmr_metabolism_management = (TextView) findViewById(R.id.bmr_textView6);
        bmr_metabolism_management.setOnClickListener(this);
        final TextView bmr_food = (TextView) findViewById(R.id.bmr_textView8);
        bmr_food.setOnClickListener(this);
        final TextView bmr_graph = (TextView) findViewById(R.id.bmr_textView9);
        bmr_graph.setOnClickListener(this);
        final TextView bmr_main = (TextView) findViewById(R.id.bmr_textView10);
        bmr_main.setOnClickListener(this);
        final ImageView bmr_food_image = (ImageView) findViewById(R.id.bmr_imageView3);
        bmr_food_image.setOnClickListener(this);
        final ImageView bmr_graph_image = (ImageView) findViewById(R.id.bmr_imageView4);
        bmr_graph_image.setOnClickListener(this);
        final ImageView bmr_main_image = (ImageView) findViewById(R.id.bmr_imageView5);
        bmr_main_image.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bmr_textView2){
            Intent intent = new Intent(bmr_activity.this,basic_activity.class);
            startActivity(intent);
        }else if(v.getId() == R.id.bmr_textView5){
            Intent intent = new Intent(bmr_activity.this,bmr_activity.class);
            startActivity(intent);
            //활동칼로리 계산
        }else if(v.getId() == R.id.bmr_textView6) {
            Intent intent = new Intent(bmr_activity.this, active_metabolism.class);
            startActivity(intent);
            //식단으로 이동
        }else if(v.getId() == R.id.bmr_textView8) {
            Intent intent = new Intent(bmr_activity.this, diet_calender_activity.class);
            startActivity(intent);
            // 그래프로 이동
        }else if(v.getId() == R.id.bmr_textView9) {
            Intent intent = new Intent(bmr_activity.this, weight_graph.class);
            startActivity(intent);
        }
        //지금 속해있는 액티비티
        else if(v.getId() == R.id.bmr_textView10){
            Intent intent = new Intent(bmr_activity.this,basic_activity.class);
            startActivity(intent);
            //하단 식단그림 클릭시 이동
        }else if(v.getId() == R.id.bmr_imageView3) {
            Intent intent = new Intent(bmr_activity.this, diet_calender_activity.class);
            startActivity(intent);
            //하단 매뉴 그래프 그림 클릭시 이동
        }else if(v.getId() == R.id.bmr_imageView4) {
            Intent intent = new Intent(bmr_activity.this, weight_graph.class);
            startActivity(intent);
            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        }else if(v.getId() == R.id.bmr_imageView5) {
            Intent intent = new Intent(bmr_activity.this, basic_activity.class);
            startActivity(intent);
        }
    }
}
