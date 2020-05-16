package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class weight_graph extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle bundle){
        Log.v("체중그래프 엑티비티","create");

        super.onCreate(bundle);
        setContentView(R.layout.weight_graph);
        final TextView basic_food = (TextView) findViewById(R.id.textView8);
        basic_food.setOnClickListener(this);
        final TextView basic_graph = (TextView) findViewById(R.id.textView9);
        basic_graph.setOnClickListener(this);
        final TextView basic_main = (TextView) findViewById(R.id.textView10);
        basic_main.setOnClickListener(this);
        final ImageView basic_food_image = (ImageView) findViewById(R.id.imageView3);
        basic_food_image.setOnClickListener(this);
        final ImageView basic_graph_image = (ImageView) findViewById(R.id.imageView4);
        basic_graph_image.setOnClickListener(this);
        final ImageView basic_main_image = (ImageView) findViewById(R.id.imageView5);
        basic_main_image.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.textView8) {
            Intent intent = new Intent(weight_graph.this, diet_calender_activity.class);
            startActivity(intent);
            // 그래프로 이동
        }else if(v.getId() == R.id.textView9) {
            Intent intent = new Intent(weight_graph.this, weight_graph.class);
            startActivity(intent);
        }
        //지금 속해있는 액티비티
        else if(v.getId() == R.id.textView10){
            Intent intent = new Intent(weight_graph.this,basic_activity.class);
            startActivity(intent);

            //하단 식단그림 클릭시 이동
        }else if(v.getId() == R.id.imageView3) {
            Intent intent = new Intent(weight_graph.this, diet_calender_activity.class);
            startActivity(intent);
            //하단 매뉴 그래프 그림 클릭시 이동
        }else if(v.getId() == R.id.imageView4) {
            Intent intent = new Intent(weight_graph.this, weight_graph.class);
            startActivity(intent);
            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        }else if(v.getId() == R.id.imageView5) {
            Intent intent = new Intent(weight_graph.this, basic_activity.class);
            startActivity(intent);

        }
    }
    protected void onResume() {
        Log.v("체중그래프 엑티비티","Resume");
        super.onResume();

    }
    @Override
    protected void onStart() {
        Log.v("체중그래프 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("체중그래프 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("체중그래프 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("체중그래프 엑티비티","Pause");
        super.onPause();
    }
}
