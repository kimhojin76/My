package com.example.myapplication7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class morning extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView, morning_recyclerView;
    FoodAdapter adapter, morning_adapter;
    protected void onCreate(Bundle bundle) {
        Log.v("체중그래프 엑티비티", "create");

        super.onCreate(bundle);
        setContentView(R.layout.food_recyle_ex);
        recyclerView = findViewById(R.id.food_recyleview_ex);
        morning_recyclerView = findViewById(R.id.morning_food_recyle_selected);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new FoodAdapter();

        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.8","2.6","0.2"));
        adapter.addItem(new Food("닭가슴살","100","0","23","1.2"));

        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnFoodItemClickListener() {
            @Override
            public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {
                Food item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨"+item.getName(),Toast.LENGTH_LONG).show();


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
