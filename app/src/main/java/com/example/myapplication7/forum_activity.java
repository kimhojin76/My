package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class forum_activity extends AppCompatActivity
        implements View.OnClickListener {
    RecyclerView recyclerView;
    memberAdapter adapter= new memberAdapter();
    private String ID,pos,reple_amount;
    public String PREFERENCE = "com.studio572.samplesharepreference";





    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("포럼 엑티비티", "create");

        super.onCreate(bundle);
        setContentView(R.layout.forum);

        //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        //에디터 선언
        SharedPreferences.Editor editor = pref.edit();

        ID = pref.getString("ID","");




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
        final ImageView forum_add = (ImageView) findViewById(R.id.forum_add);
        forum_add.setOnClickListener(this);
        //레이아웃 xml에 작성해준 리사이클러뷰를 자바로 가져와서 초기화
        recyclerView = findViewById(R.id.forum_board);
        //레이아웃 메너저를 통해 List형식으로 할지 Grid형식으로 할지 결정정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        //pal 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        //어뎁터 선언
//        if (pref.getInt("first",1) == 1) {        Log.v("포럼 엑티비티", "첫실행 꺼짐방지");
//
//
//            editor.putInt("first",2);
//            Gson gson = new Gson();
//            //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
//            //에디터 선언
//            String gson_member_adapter = gson.toJson(adapter.items);
//            //에디터에 json형식으로 변환된 객체값 집어넣기
//            editor.putString("gson_member_adapter", gson_member_adapter);
//            //쉐어드에 저장하기
//            editor.commit();
//        }
        //리사이클러뷰에 어댑터 설정
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnmemberItemClickListener() {
            @Override
            public void onItemClick(memberAdapter.ViewHolder holder, View view, int position) {
                member item = adapter.getitem(position);

                Intent data = new Intent(forum_activity.this, forum_detail.class);
                data.putExtra("포지션",Integer.toString(position));
                data.putExtra("닉네임",item.getNickname().toString());
                data.putExtra("제목",item.getTitle().toString());
                data.putExtra("날짜",item.getDate().toString());
                data.putExtra("내용",item.getContents().toString());
                startActivityForResult(data,1011);
            }
        });






    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);

        Log.v("포럼 엑티비티", "도착");

        if (requestCode==1010&&resultCode==200)
        {
            Log.v("포럼 엑티비티", "조건문 도착");

            Intent intent = data;
            adapter.addItem(new member(intent.getStringExtra("닉네임").toString(),intent.getStringExtra("제목").toString(),intent.getStringExtra("날짜").toString(),intent.getStringExtra("내용").toString(),""));
            recyclerView.setAdapter(adapter);
            Gson gson = new Gson();
            //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
            //에디터 선언
            SharedPreferences.Editor editor = pref.edit();
            String gson_member_adapter = gson.toJson(adapter.items);
            //에디터에 json형식으로 변환된 객체값 집어넣기
            editor.putString("gson_member_adapter",gson_member_adapter);
            //쉐어드에 저장하기
            editor.commit();
        }else if(resultCode==1031){
            Log.v("포럼 엑티비티", "1031 도착");
           String pos1 = data.getExtras().getString("포지션");
           String reple_amount1 = data.getExtras().getString("리플수");
            Log.v("포럼 엑티비티", pos1);
            Log.v("포럼 엑티비티", reple_amount1);

            member item = adapter.getitem(Integer.parseInt(pos1));
            item.setReple_amount(reple_amount1);
            recyclerView.setAdapter(adapter);
            Gson gson = new Gson();
            //gson을 이용해 Json형식으로 변환하여 어뎁터데이터를 저장
            String gson_member_adapter = gson.toJson(adapter.items);
            //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
            //에디터 선언
            SharedPreferences.Editor editor = pref.edit();
            //에디터에 json형식으로 변환된 객체값 집어넣기
            editor.putString("gson_member_adapter",gson_member_adapter);
            //에디터에 저장
            editor.commit();
            //디테일에서 수정 완료시 이쪽으로
        }else if(resultCode==1066){
            Log.v("포럼 엑티비티", "1066(삭제) 도착");
            String pos1 = data.getExtras().getString("포지션");
            String reple_amount1 = data.getExtras().getString("리플수");
            Log.v("포럼 엑티비티", pos1);
            Log.v("포럼 엑티비티", reple_amount1);
            adapter.items.remove(Integer.parseInt(pos1));
            Log.v("포럼 엑티비티", Integer.toString(adapter.items.size()));
            recyclerView.setAdapter(adapter);
            Gson gson = new Gson();
            //gson을 이용해 Json형식으로 변환하여 어뎁터데이터를 저장
            String gson_member_adapter = gson.toJson(adapter.items);
            //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
            //에디터 선언
            SharedPreferences.Editor editor = pref.edit();
            //에디터에 json형식으로 변환된 객체값 집어넣기
            editor.putString("gson_member_adapter",gson_member_adapter);
            //에디터에 저장
            editor.commit();
            //디테일에서 수정 완료시 이쪽으로
        }
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
        } else if (v.getId() == R.id.forum_add) {
            Intent intent = new Intent(forum_activity.this, forum_write.class);
            startActivityForResult(intent,1010);


        }
    }


    @Override
    protected void onResume() {
        Log.v("포럼 엑티비티", "Resume");
        super.onResume();
        //Gson 인스턴스 생성
        Gson gson = new Gson();
//        //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
//        //에디터 선언
        SharedPreferences.Editor editor = pref.edit();
//        String gson_member_adapter = gson.toJson(adapter.items);
        //에디터에 json형식으로 변환된 객체값 집어넣기
//        editor.putString("gson_member_adapter",gson_member_adapter);
        //쉐어드에 저장하기
//        editor.commit();
        //쉐어드에서 가져오기(json형식)
        String get_gson_member_adapter = pref.getString("gson_member_adapter","");
        //이를 변환
        Log.v("포럼 엑티비티 gson", get_gson_member_adapter.toString());
        //첫실행 꺼짐 방지
        if (get_gson_member_adapter != "") {
            ArrayList<member> list = gson.fromJson(get_gson_member_adapter, new TypeToken<ArrayList<member>>() {
            }.getType());
            adapter.items = list;

            recyclerView = findViewById(R.id.forum_board);
            //레이아웃 메너저를 통해 List형식으로 할지 Grid형식으로 할지 결정정
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            //pal 리사이클러뷰에 레이아웃 메니져 설정
            recyclerView.setLayoutManager(layoutManager);
            //어뎁터 선언
            recyclerView.setAdapter(adapter);
        }

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
        Gson gson = new Gson();
        //gson을 이용해 Json형식으로 변환하여 어뎁터데이터를 저장
        String gson_member_adapter = gson.toJson(adapter.items);
        //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        //에디터 선언
        SharedPreferences.Editor editor = pref.edit();
        //에디터에 json형식으로 변환된 객체값 집어넣기
        editor.putString("gson_member_adapter",gson_member_adapter);
        String get_gson_member_adapter = pref.getString("gson_member_adapter","");
        Log.v("포럼 엑티비티 pause gson road", get_gson_member_adapter.toString());

        //에디터에 저장
        editor.commit();
    }
    public void onBackPressed() {
        Intent intent = new Intent(forum_activity.this, basic_activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}