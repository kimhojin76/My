package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class meal extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView, morning_recyclerView;
    FoodAdapter adapter;
    String food_name,food_kcal,food_car,food_pro,foodfat;
    String meal = "아침식단";
    double user_kcal = 0;
    FoodAdapter2 morning_adapter,lunch_adapter,dinner_adapter,snack_adapter;
    String[] spinner_item = {"아침식단","점심식단","저녘식단","간식"};

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
        Intent intent = getIntent();
        //음식 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        //아침 리사이클러뷰에 레이아웃 메니져 설정
        morning_recyclerView.setLayoutManager(morning_layoutManager);

        //어뎁터 선언
        adapter = new FoodAdapter();
        morning_adapter = new FoodAdapter2();
        lunch_adapter = new FoodAdapter2();
        dinner_adapter = new FoodAdapter2();
        snack_adapter = new FoodAdapter2();

        //어뎁터에 수치 입력
        adapter.addItem(new Food("쌀밥","270","61","5","0.7"));
        adapter.addItem(new Food("찐고구마","193","45.8","2.6","0.2"));
        adapter.addItem(new Food("닭가슴살","100","0","23","1.2"));

        //칼로리계산기 버튼 연결 및 클릭이벤트 설정
        final Button add_foodadapter_button = (Button) findViewById(R.id.add_food);
        add_foodadapter_button.setOnClickListener(this);
        final Button kcal_sum_button = (Button) findViewById(R.id.kcal_sum_button);
        kcal_sum_button.setOnClickListener(this);
        //스피너에 아이템 연결
        final Spinner spinner = findViewById(R.id.spiner);
        //스피터 어댑터 선언
        ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,spinner_item);
        //스피너 어댑터 레이아웃 설정
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //스피너에 어댑터 설정
        spinner.setAdapter(spinner_adapter);
        //스피너에 리스너 설정
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView userkcal = (TextView) findViewById(R.id.textView26);
                Log.v("식단입력 엑티비티",spinner_item[position]);
                if(spinner_item[position]=="아침식단"){
                    meal = "아침식단";
                    if(morning_adapter.items.size()==0){
                        userkcal.setText(null);
                        morning_recyclerView.setAdapter(morning_adapter);
                    }else{
                    morning_recyclerView.setAdapter(morning_adapter);
                    user_kcal = 0;
                    for (int i = 0; i < morning_adapter.items.size(); i++) {
                        Food item1 = morning_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }}
                }else if(spinner_item[position]=="점심식단"){
                    meal = "점심식단";

                    if(lunch_adapter.items.size()==0){
                        userkcal.setText(null);
                        morning_recyclerView.setAdapter(lunch_adapter);
                    }else{
                    morning_recyclerView.setAdapter(lunch_adapter);
                    user_kcal = 0;
                    for (int i = 0; i < lunch_adapter.items.size(); i++) {
                        Food item1 = lunch_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }}

                }else if(spinner_item[position]=="저녘식단"){
                    meal = "저녘식단";
                    if(dinner_adapter.items.size()==0){
                        morning_recyclerView.setAdapter(dinner_adapter);
                        userkcal.setText(null);
                    }else{
                    morning_recyclerView.setAdapter(dinner_adapter);
                    user_kcal = 0;
                    for (int i = 0; i < dinner_adapter.items.size(); i++) {
                        Food item1 = dinner_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }}

                }else if(spinner_item[position]=="간식"){
                    meal = "간식";
                    if(snack_adapter.items.size()==0){
                        morning_recyclerView.setAdapter(snack_adapter);
                        userkcal.setText(null);
                    }else{
                    morning_recyclerView.setAdapter(snack_adapter);
                    user_kcal = 0;
                    for (int i = 0; i < snack_adapter.items.size(); i++) {
                        Food item1 = snack_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }}
                }else{

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        recyclerView.setAdapter(adapter);
        morning_recyclerView.setAdapter(morning_adapter);
        adapter.setOnItemClickListener(new OnFoodItemClickListener() {
            @Override
            public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {
                TextView userkcal = (TextView) findViewById(R.id.textView26);
                Food item = adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨"+item.getName()+item.getKcal()+item.getCar()+item.getPro()+item.getFat(),Toast.LENGTH_LONG).show();

                if(meal=="아침식단"){
                    morning_adapter.addItem(new Food(item.getName(),item.getKcal(),item.getCar(),item.getPro(),item.getFat()));
                    morning_recyclerView.setAdapter(morning_adapter);

                }else if(meal=="점심식단"){
                    lunch_adapter.addItem(new Food(item.getName(),item.getKcal(),item.getCar(),item.getPro(),item.getFat()));
                    morning_recyclerView.setAdapter(lunch_adapter);

                }else if(meal=="저녘식단"){
                    dinner_adapter.addItem(new Food(item.getName(),item.getKcal(),item.getCar(),item.getPro(),item.getFat()));
                    morning_recyclerView.setAdapter(dinner_adapter);

                }else if(meal=="간식"){
                    snack_adapter.addItem(new Food(item.getName(),item.getKcal(),item.getCar(),item.getPro(),item.getFat()));
                    morning_recyclerView.setAdapter(snack_adapter);

                }else{

                }

                if(meal == "아침식단") {

                    user_kcal = 0;
                    for (int i = 0; i < morning_adapter.items.size(); i++) {
                        Food item1 = morning_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }
                    Log.v("식단입력 엑티비티", Double.toString(user_kcal));
                }else if(meal == "점심식단"){
                    user_kcal = 0;
                    for (int i = 0; i < lunch_adapter.items.size(); i++) {
                        Food item1 = lunch_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }
                }else if(meal == "저녘식단"){
                    user_kcal = 0;
                    for (int i = 0; i < dinner_adapter.items.size(); i++) {
                        Food item1 = dinner_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }
                }else if(meal == "간식"){
                    user_kcal = 0;
                    for (int i = 0; i < snack_adapter.items.size(); i++) {
                        Food item1 = snack_adapter.getItem(i);
                        Log.v("식단입력 엑티비티", item1.getName());
                        user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                        userkcal.setText(Double.toString(user_kcal));
                    }
                }




            }
        });
        morning_adapter.setOnItemClickListener(new OnFoodItemClickListener() {
            @Override
            public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {
                Food item = morning_adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"아이템 선택됨"+item.getName(),Toast.LENGTH_LONG).show();
            }
        });




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("식단입력 엑티비티", "도착");

        if (requestCode==1001&&resultCode==200)
        {
            Log.v("식단입력 엑티비티", "조건문 도착");
            Intent intent = data;
            Log.v("식단입력 엑티비티", intent.getStringExtra("음식명").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("칼로리").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("탄수화물").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("단백질").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("지방").toString());

           adapter.addItem(new Food(intent.getStringExtra("음식명").toString(),intent.getStringExtra("칼로리").toString(),intent.getStringExtra("탄수화물").toString(),intent.getStringExtra("단백질").toString(),intent.getStringExtra("지방").toString()));
            recyclerView.setAdapter(adapter);

        }
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(com.example.myapplication7.meal.this);
        //칼로리계산기 버튼 클릭
        if (v.getId() == R.id.kcal_sum_button) {
            //반복문을 이용하여 모닝아답터 리스트의 kcal 총합 구하기
            TextView userkcal = (TextView) findViewById(R.id.textView26);

            if(meal == "아침식단") {
                user_kcal = 0;
                for (int i = 0; i < morning_adapter.items.size(); i++) {
                    Food item1 = morning_adapter.getItem(i);
                    Log.v("식단입력 엑티비티", item1.getName());
                    user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                    userkcal.setText(Double.toString(user_kcal));
                }
                Log.v("식단입력 엑티비티", Double.toString(user_kcal));
            }else if(meal == "점심식단"){
                user_kcal = 0;
                for (int i = 0; i < lunch_adapter.items.size(); i++) {
                    Food item1 = lunch_adapter.getItem(i);
                    Log.v("식단입력 엑티비티", item1.getName());
                    user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                    userkcal.setText(Double.toString(user_kcal));
                }
            }else if(meal == "저녘식단"){
                user_kcal = 0;
                for (int i = 0; i < dinner_adapter.items.size(); i++) {
                    Food item1 = dinner_adapter.getItem(i);
                    Log.v("식단입력 엑티비티", item1.getName());
                    user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                    userkcal.setText(Double.toString(user_kcal));
                }
            }else if(meal == "간식"){
                user_kcal = 0;
                for (int i = 0; i < snack_adapter.items.size(); i++) {
                    Food item1 = snack_adapter.getItem(i);
                    Log.v("식단입력 엑티비티", item1.getName());
                    user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
                    userkcal.setText(Double.toString(user_kcal));
                }
            }

        }else if (v.getId() == R.id.add_food){
            Log.v("식단입력 엑티비티", "음식 추가 버튼 클릭");
            Intent intent = new Intent(meal.this, Food_custom_add.class);
            startActivityForResult(intent,1001);
        }
    }


    protected void onResume() {
        Log.v("식단입력 엑티비티","Resume");
        super.onResume();

    }
    @Override
    protected void onStart() {
        Log.v("식단입력 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("식단입력 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("식단입력 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("식단입력 엑티비티","Pause");
        super.onPause();
    }
}
