package com.example.myapplication7;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class morning extends AppCompatActivity implements View.OnClickListener {
    protected void onCreate(Bundle bundle) {
        Log.v("체중그래프 엑티비티", "create");

        super.onCreate(bundle);
        setContentView(R.layout.food_recyle_ex);
        RecyclerView recyclerView = findViewById(R.id.food_recyleview_ex);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        FoodAdapter adapter = new FoodAdapter();

        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        adapter.addItem(new Food("닭가슴살","100","0","22.98","1.23"));
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.85","2.6","0.22"));
        recyclerView.setAdapter(adapter);


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
