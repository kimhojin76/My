package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.Map;

public class weight_graph extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle bundle){
        Log.v("체중그래프 엑티비티","create");

        super.onCreate(bundle);
        setContentView(R.layout.weight_graph);

        LineChart lineChart = (LineChart)findViewById(R.id.linechart);
        LineData chartdate = new LineData();
        ArrayList<Entry> weights = new ArrayList<>();
        ArrayList<Entry> weights2 = new ArrayList<>();
        weights.add(new Entry(4f,0));
        weights.add(new Entry(8f,1));
        weights.add(new Entry(6f,2));
//        weights.add(new Entry(2f,3));
//        weights.add(new Entry(18f,4));
//        weights.add(new Entry(9f,5));

        LineDataSet lineDataSet = new LineDataSet(weights,"꺽은선1");
        chartdate.addDataSet(lineDataSet);
        lineChart.setData(chartdate);
        lineChart.invalidate();

        //그래프에 들어갈 좌표값 입력





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
        if (v.getId() == R.id.textView5) {
            Intent intent = new Intent(weight_graph.this, bmr_activity.class);
            startActivity(intent);
            finish();

            //활동칼로리 계산
        } else if (v.getId() == R.id.textView8) {
            Intent intent = new Intent(weight_graph.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        } else if (v.getId() == R.id.textView9) {


        }
        //지금 속해있는 액티비티
        else if (v.getId() == R.id.textView10) {
            Intent intent = new Intent(weight_graph.this, basic_activity.class);
            startActivity(intent);
            finish();


            //게시판 텍스트 클릭
        } else if (v.getId() == R.id.textView16) {
            Intent intent = new Intent(weight_graph.this, forum_activity.class);
            startActivity(intent);
            finish();


        } else if (v.getId() == R.id.imageView3) {
            Intent intent = new Intent(weight_graph.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        } else if (v.getId() == R.id.imageView4) {


            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        } else if (v.getId() == R.id.imageView5) {
            Intent intent = new Intent(weight_graph.this, basic_activity.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.imageView6) {
            Intent intent = new Intent(weight_graph.this, bmr_activity.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.imageView7) {
            Intent intent = new Intent(weight_graph.this, forum_activity.class);
            startActivity(intent);
            finish();


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
    public void onBackPressed() {
        Intent intent = new Intent(weight_graph.this, basic_activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
