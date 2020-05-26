package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class forum_activity extends AppCompatActivity
        implements View.OnClickListener {
    RecyclerView recyclerView;
    memberAdapter adapter;


    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("식단/체중 엑티비티", "create");

        super.onCreate(bundle);
        setContentView(R.layout.forum);

        //레이아웃 xml에 작성해준 리사이클러뷰를 자바로 가져와서 초기화
        recyclerView = findViewById(R.id.forum_board);
        //레이아웃 메너저를 통해 List형식으로 할지 Grid형식으로 할지 결정정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //pal 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        //어뎁터 선언
        adapter = new memberAdapter();
        adapter.addItem(new member("다이어터","다이어트 방법 공유좀해주세요","2020-05-26","다이어트 방법 공유좀요"));
        adapter.addItem(new member("동면중","다이어트 식단 이렇게 짜세요","2020-05-26","잘짜세요"));
        adapter.addItem(new member("피톨로지","살이 찌는 이유는 무엇일까?","2020-05-26","많이 먹어서"));
        adapter.addItem(new member("살덩이","매일 배가 고파요","2020-05-26","먹어도 먹어도 배가 고픔"));
        //리사이클러뷰에 어댑터 설정
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnmemberItemClickListener() {
            @Override
            public void onItemClick(memberAdapter.ViewHolder holder, View view, int position) {

            }
        }); {



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
        //칼로리 계산
        if (v.getId() == R.id.textView5) {
            Intent intent = new Intent(forum_activity.this, bmr_activity.class);
            startActivity(intent);
            finish();

            //달력
        } else if (v.getId() == R.id.textView8) {
            Intent intent = new Intent(forum_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        } else if (v.getId() == R.id.textView9) {
            Intent intent = new Intent(forum_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

        }
        //메인 액티비티
        else if (v.getId() == R.id.textView10) {
            Intent intent = new Intent(forum_activity.this, basic_activity.class);
            startActivity(intent);
            finish();

            //게시판 텍스트 클릭
        } else if (v.getId() == R.id.textView16) {


        } else if (v.getId() == R.id.imageView3) {
            Intent intent = new Intent(forum_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        } else if (v.getId() == R.id.imageView4) {
            Intent intent = new Intent(forum_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        } else if (v.getId() == R.id.imageView5) {
            Intent intent = new Intent(forum_activity.this, basic_activity.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.imageView6) {
            Intent intent = new Intent(forum_activity.this, bmr_activity.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.imageView7) {



        }
    }


    @Override
    protected void onResume() {
        Log.v("포럼 엑티비티", "Resume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v("포럼 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("포럼 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("포럼 엑티비티", "Destroy");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v("포럼 엑티비티", "Pause");
        super.onPause();
    }
    public void onBackPressed() {
        Intent intent = new Intent(forum_activity.this, basic_activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}