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
    TextView act_sum_hour;


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
        Intent intent = getIntent();
        //pal 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        seleted_recyclerView.setLayoutManager(selected_layoutManager);

        //어뎁터 선언
        adapter = new ACTAdapter();
        selected_adapter = new ACTAdapter2();

        //어뎁터에 수치 입력
        adapter.addItem(new ACT("수면","0.9","1"));
        adapter.addItem(new ACT("휴식,TV시청(앉음)","1.2","1"));
        adapter.addItem(new ACT("식사","1.4","1"));
        adapter.addItem(new ACT("사무업무","1.6","1"));
        adapter.addItem(new ACT("대중교통(앉음)","1.7","1"));
        adapter.addItem(new ACT("대중교통(서서)","2","1"));
        adapter.addItem(new ACT("산책","2.5","1"));
        adapter.addItem(new ACT("근력운동(약)","3","1"));
        adapter.addItem(new ACT("수영,스포츠(초급반)","3.1","1"));
        adapter.addItem(new ACT("집안일","3.1","1"));
        adapter.addItem(new ACT("걷기(시속3km)","3.7","1"));
        adapter.addItem(new ACT("싸이클","3.75","1"));
        adapter.addItem(new ACT("에어로빅","4.1","1"));
        adapter.addItem(new ACT("축구,테니스","4.4","1"));
        adapter.addItem(new ACT("근력운동(중)","4.5","1"));
        adapter.addItem(new ACT("유산소(약)","4.5","1"));
        adapter.addItem(new ACT("등산","5.7","1"));
        adapter.addItem(new ACT("싸이클(빠른속도)","5.8","1"));
        adapter.addItem(new ACT("유산소(중)","6","1"));
        adapter.addItem(new ACT("근력운동(강)","6","1"));
        adapter.addItem(new ACT("유산소(강)","9","1"));



        recyclerView.setAdapter(adapter);
        seleted_recyclerView.setAdapter(selected_adapter);
        adapter.setOnItemClickListener(new OnACTItemClickListener() {
            @Override
            public void onItemClick(ACTAdapter.ViewHolder holder, View view, int position) {
                ACT item = adapter.getItem(position);
                selected_adapter.addItem(new ACT(item.getActname(),item.getAct_pal(),"1"));
                seleted_recyclerView.setAdapter(selected_adapter);
                user_hour = 0;
                for (int i = 0; i < selected_adapter.items.size(); i++) {
                    ACT item1 = selected_adapter.getItem(i);
                    Log.v("식단입력 엑티비티", item1.getAct_hour());
                    user_hour = user_hour + Double.parseDouble(item1.getAct_hour());
                    act_sum_hour.setText(Double.toString(user_hour));
                }

            }
        });


        act_sum_hour = (TextView) findViewById(R.id.textView12);
        act_sum_hour.setText(Double.toString(user_hour));
        Button save = (Button) findViewById(R.id.add_custom_pal);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });





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
