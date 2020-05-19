package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class basic_activity extends AppCompatActivity
        implements View.OnClickListener {
    public final String PREFERENCE = "com.studio572.samplesharepreference";

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("베이직 엑티비티","create");
        super.onCreate(bundle);
        setContentView(R.layout.basic);

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


        }
    }



    @Override
    protected void onResume() {
        Log.v("베이직 엑티비티","Resume");
        super.onResume();
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
