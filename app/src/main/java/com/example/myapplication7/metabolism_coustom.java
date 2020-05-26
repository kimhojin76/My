package com.example.myapplication7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class metabolism_coustom extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView,seleted_recyclerView;
    ACTAdapter adapter;
    double user_hour =0;
    ACTAdapter2 selected_adapter;



    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("활동관리커스텀 엑티비티", "create");
        super.onCreate(bundle);
        //모닝 액티비티 레이아웃 metabollism_coustom 레이아웃 연결
        setContentView(R.layout.metabolism_coustom);
        //레이아웃 xml에 작성해준 리사이클러뷰를 자바로 가져와서 초기화
        recyclerView = findViewById(R.id.custom_kcal_recyle);
        //레이아웃 xml에 작성해준 리사이클러뷰를 자바로 가져와서 초기화
        seleted_recyclerView = findViewById(R.id.custom_kcal_selected);
        //레이아웃 메너저를 통해 List형식으로 할지 Grid형식으로 할지 결정정
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager selected_layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);

        //pal 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        seleted_recyclerView.setLayoutManager(selected_layoutManager);

        //어뎁터 선언
        adapter = new ACTAdapter();
        selected_adapter = new ACTAdapter2();

        //어뎁터에 수치 입력
        adapter.addItem(new ACT("수면","0.93"));
        recyclerView.setAdapter(adapter);
        recyclerView.setAdapter(selected_adapter);
        adapter.setOnItemClickListener(new OnACTItemClickListener() {
            @Override
            public void onItemClick(ACTAdapter.ViewHolder holder, View view, int position) {

            }
        });

//
//
//
//        Button save = (Button) findViewById(R.id.add_custom_pal);
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });





    }

    @Override
    protected void onResume() {
        Log.v("활동관리커스텀 엑티비티", "Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("활동관리커스텀 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("활동관리커스텀 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("활동관리커스텀 엑티비티", "Destroy");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v("활동관리커스텀 엑티비티", "Pause");
        super.onPause();
    }

    @Override
    public void onClick(View v) {



    }
}
