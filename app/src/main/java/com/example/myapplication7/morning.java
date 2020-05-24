package com.example.myapplication7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class morning extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView, morning_recyclerView;
    FoodAdapter adapter;
    FoodAdapter2 morning_adapter;
    protected void onCreate(Bundle bundle) {
        Log.v("체중그래프 엑티비티", "create");

        super.onCreate(bundle);
        //모닝 액티비티 레이아웃 food_recyle_ex 연결
        setContentView(R.layout.food_recyle_ex);
        //레이아웃 xml에 작성해준 리사이클러뷰를 자바로 가져와서 초기화
        recyclerView = findViewById(R.id.food_recyleview_ex);
        //레이아웃 xml에 작성해준 리사이클러뷰를 자바로 가져와서 초기화
        morning_recyclerView = findViewById(R.id.morning_food_recyle_selected);
        //레이아웃 메너저를 통해 List형식으로 할지 Grid형식으로 할지 결정정
       LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        LinearLayoutManager morning_layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //음식 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        //아침 리사이클러뷰에 레이아웃 메니져 설정
        morning_recyclerView.setLayoutManager(morning_layoutManager);
        //어뎁터 선언
        adapter = new FoodAdapter();
        morning_adapter = new FoodAdapter2();
        //어뎁터에 수치 입력
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.8","2.6","0.2"));
        adapter.addItem(new Food("닭가슴살","100","0","23","1.2"));

        recyclerView.setAdapter(adapter);
        morning_recyclerView.setAdapter(morning_adapter);

        adapter.setOnItemClickListener(new OnFoodItemClickListener() {
            @Override
            public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {
                Food item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨"+item.getName()+item.getKcal()+item.getCar()+item.getPro()+item.getFat(),Toast.LENGTH_LONG).show();
                morning_adapter.addItem(new Food(item.getName(),item.getKcal(),item.getCar(),item.getPro(),item.getFat()));
                morning_recyclerView.setAdapter(morning_adapter);



            }
        });
        morning_adapter.setOnItemClickListener(new OnFoodItemClickListener() {
            @Override
            public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {
                Food item = morning_adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨"+item.getName(),Toast.LENGTH_LONG).show();

                ArrayList<Integer> list = new ArrayList<>();
                list.add(4);
                list.add(44);
                list.add(444);
                int sum = 0;
                int max = Collections.max(list);
                int min = Collections.min(list);
                for(Integer i : list){
                    sum += i;
                }
                int average = sum / list.size();
                System.out.println("합계 = "+sum);
                System.out.println("평균 = "+average);
                System.out.println("최대값 = "+max);
                System.out.println("최소값 = "+min);


            }
        });
    }
    @Override
    public void onClick(View v) {

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
