package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class meal extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerView, morning_recyclerView;
    FoodAdapter adapter;
    public String PREFERENCE = "com.studio572.samplesharepreference";
    static String ID,DATE,M,L,D,S;
    String food_name,food_kcal,food_car,food_pro,foodfat;
    static String meal = "아침식단";
    public static TextView userkcal;
    SharedPreferences pref;
    double user_kcal = 0;
    FoodAdapter2 morning_adapter,lunch_adapter,dinner_adapter,snack_adapter;
    public String[] spinner_item = {"아침식단","점심식단","저녘식단","간식"};
//gj
    protected void onCreate(Bundle bundle) {

        pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        ID = pref.getString("ID","");
        DATE = pref.getString(ID+"date","");
        String DATEtitle = pref.getString(ID+"datetitle","");

        Log.v("체중그래프 엑티비티", ID+DATE);
        //타이틀 바 날자+식단으로 변경

        setTitle(DATEtitle+" 식단");


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
        final Intent intent = getIntent();
        //음식 리사이클러뷰에 레이아웃 메니져 설정
        recyclerView.setLayoutManager(layoutManager);
        //아침 리사이클러뷰에 레이아웃 메니져 설정
        morning_recyclerView.setLayoutManager(morning_layoutManager);

        //어뎁터 선언
        adapter = new FoodAdapter(this);
        morning_adapter = new FoodAdapter2(this);
        lunch_adapter = new FoodAdapter2(this);
        dinner_adapter = new FoodAdapter2(this);
        snack_adapter = new FoodAdapter2(this);

        //어뎁터에 수치 입력
        adapter.addItem(new Food("쌀밥","270","61","5","0.7","100"));
        adapter.addItem(new Food("찐고구마","193","45.8","2.6","0.2","100"));
        adapter.addItem(new Food("닭가슴살","100","0","23","1.2","100"));
        Gson gson = new Gson();
//        String gson_food_adapter = gson.toJson(adapter.items);
//        //에디터에 json형식으로 변환된 객체값 집어넣기
//        editor.putString(ID+"gson_food_adapter",gson_food_adapter);
//        editor.commit();
        Log.v("식단입력 엑티비티",adapter.items.toString());

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
                userkcal = (TextView) findViewById(R.id.textView26);
                SharedPreferences pref = getSharedPreferences(PREFERENCE,MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("선택식단",spinner_item[position]);
                editor.commit();
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
                    }M=Double.toString(user_kcal);
                    }
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
                    }L=Double.toString(user_kcal);
                    }

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
                    }D=Double.toString(user_kcal);
                    }

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
                    }S=Double.toString(user_kcal);
                    }
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
                Intent fooddata = new Intent(meal.this, Food_custom_weight.class);
                fooddata.putExtra("음식명",item.getName().toString());
                fooddata.putExtra("칼로리",item.getKcal().toString());
                fooddata.putExtra("탄수화물",item.getCar().toString());
                fooddata.putExtra("단백질",item.getPro().toString());
                fooddata.putExtra("지방",item.getFat().toString());

                startActivityForResult(fooddata,1020);





            }
        });
        morning_adapter.setOnItemClickListener(new OnFoodItemClickListener() {
            @Override
            public void onItemClick(FoodAdapter.ViewHolder holder, View view, int position) {
                Food item = morning_adapter.getItem(position);
            }
        });




    }

    public void get_mornig(){
        for (int i = 0; i < morning_adapter.items.size(); i++) {
            Food item1 = morning_adapter.getItem(i);
            Log.v("식단입력 엑티비티", item1.getName());
            user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
            userkcal.setText(Double.toString(user_kcal));
        }
    }
    public void get_lunch(){
        for (int i = 0; i < lunch_adapter.items.size(); i++) {
            Food item1 = lunch_adapter.getItem(i);
            Log.v("식단입력 엑티비티", item1.getName());
            user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
            userkcal.setText(Double.toString(user_kcal));
        }
    }
    public void get_dinner(){
        for (int i = 0; i < dinner_adapter.items.size(); i++) {
            Food item1 = dinner_adapter.getItem(i);
            Log.v("식단입력 엑티비티", item1.getName());
            user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
            userkcal.setText(Double.toString(user_kcal));
        }
    }
    public void get_snack(){
        for (int i = 0; i < snack_adapter.items.size(); i++) {
            Food item1 = snack_adapter.getItem(i);
            Log.v("식단입력 엑티비티", item1.getName());
            user_kcal = user_kcal + Double.parseDouble(item1.getKcal());
            userkcal.setText(Double.toString(user_kcal));
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("식단입력 엑티비티", "도착");

        pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        Gson gson = new Gson();
        //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
        //에디터 선언
        SharedPreferences.Editor editor = pref.edit();
        if (requestCode==1001&&resultCode==200)
        {
            Log.v("식단입력 엑티비티", "조건문 도착");

            Intent intent = data;
            Log.v("식단입력 엑티비티", intent.getStringExtra("음식명").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("칼로리").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("탄수화물").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("단백질").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("지방").toString());

           adapter.addItem(new Food(intent.getStringExtra("음식명").toString(),intent.getStringExtra("칼로리").toString(),intent.getStringExtra("탄수화물").toString(),intent.getStringExtra("단백질").toString(),intent.getStringExtra("지방").toString(),"100"));
            recyclerView.setAdapter(adapter);
            Log.v("식단입력 엑티비티", adapter.items.toString());
            String gson_food_adapter = gson.toJson(adapter.items);
            //에디터에 json형식으로 변환된 객체값 집어넣기
            editor.putString(ID+"gson_food_adapter",gson_food_adapter);
            //쉐어드에 저장하기
            editor.commit();









        }else if(requestCode==1020&&resultCode==220){
            TextView userkcal = (TextView) findViewById(R.id.textView26);

            Log.v("식단입력 엑티비티", "조건문 도착");
            Intent intent = data;
            Log.v("식단입력 엑티비티", intent.getStringExtra("음식명").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("칼로리").toString());
            Log.v("식단입력 엑티비티", intent.getStringExtra("탄수화물").toString());

            if(meal=="아침식단"){
                morning_adapter.addItem(new Food(intent.getStringExtra("음식명"),intent.getStringExtra("칼로리"),intent.getStringExtra("탄수화물"),intent.getStringExtra("단백질"),intent.getStringExtra("지방"),intent.getStringExtra("중량")));
                morning_recyclerView.setAdapter(morning_adapter);

                String gson_morning_adapter = gson.toJson(morning_adapter.items);
                //에디터에 json형식으로 변환된 객체값 집어넣기
                editor.putString(ID+DATE+"gson_morning_adapter",gson_morning_adapter);
                //쉐어드에 저장하기
                editor.commit();
                Log.v("식단입력 모닝 엑티비티", gson.toJson(morning_adapter.items));


            }else if(meal=="점심식단"){
                lunch_adapter.addItem(new Food(intent.getStringExtra("음식명"),intent.getStringExtra("칼로리"),intent.getStringExtra("탄수화물"),intent.getStringExtra("단백질"),intent.getStringExtra("지방"),intent.getStringExtra("중량")));
                morning_recyclerView.setAdapter(lunch_adapter);

                String gson_lunch_adapter = gson.toJson(lunch_adapter.items);
                //에디터에 json형식으로 변환된 객체값 집어넣기
                editor.putString(ID+DATE+"gson_lunch_adapter",gson_lunch_adapter);
                //쉐어드에 저장하기
                editor.commit();
                Log.v("식단입력 모닝 엑티비티", gson.toJson(lunch_adapter.items));

            }else if(meal=="저녘식단"){
                dinner_adapter.addItem(new Food(intent.getStringExtra("음식명"),intent.getStringExtra("칼로리"),intent.getStringExtra("탄수화물"),intent.getStringExtra("단백질"),intent.getStringExtra("지방"),intent.getStringExtra("중량")));
                morning_recyclerView.setAdapter(dinner_adapter);

                String gson_dinner_adapter = gson.toJson(dinner_adapter.items);
                //에디터에 json형식으로 변환된 객체값 집어넣기
                editor.putString(ID+DATE+"gson_dinner_adapter",gson_dinner_adapter);
                //쉐어드에 저장하기
                editor.commit();
                Log.v("식단입력 모닝 엑티비티", gson.toJson(dinner_adapter.items));

            }else if(meal=="간식"){
                snack_adapter.addItem(new Food(intent.getStringExtra("음식명"),intent.getStringExtra("칼로리"),intent.getStringExtra("탄수화물"),intent.getStringExtra("단백질"),intent.getStringExtra("지방"),intent.getStringExtra("중량")));
                morning_recyclerView.setAdapter(snack_adapter);
                String gson_snack_adapter = gson.toJson(snack_adapter.items);
                //에디터에 json형식으로 변환된 객체값 집어넣기
                editor.putString(ID+DATE+"gson_snack_adapter",gson_snack_adapter);
                //쉐어드에 저장하기
                editor.commit();
                Log.v("식단입력 모닝 엑티비티", gson.toJson(snack_adapter.items));
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
        Gson gson = new Gson();
        //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
        pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        //에디터 선언
        SharedPreferences.Editor editor = pref.edit();
        String gson_food_adapter = pref.getString(ID+"gson_food_adapter","");

        if (gson_food_adapter != "") {
            gson_food_adapter = pref.getString(ID + "gson_food_adapter", "");
            ArrayList<Food> foodlist = gson.fromJson(gson_food_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            adapter.items = foodlist;

        }
        String gson_morning_adapter = pref.getString(ID+DATE+"gson_morning_adapter","");
        String gson_lunch_adapter = pref.getString(ID+DATE+"gson_lunch_adapter","");
        String gson_dinner_adapter = pref.getString(ID+DATE+"gson_dinner_adapter","");
        String gson_snack_adapter = pref.getString(ID+DATE+"gson_snack_adapter","");
        Log.v("포럼 엑티비티 pause gson road", gson_morning_adapter);
        //첫실행 꺼짐 방지
        if (gson_morning_adapter != "" && gson_lunch_adapter != "" && gson_dinner_adapter != "" && gson_snack_adapter != "") {
        ArrayList<Food> morninglist = gson.fromJson(gson_morning_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
        ArrayList<Food> lunchlist = gson.fromJson(gson_lunch_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
        ArrayList<Food> dinnerlist = gson.fromJson(gson_dinner_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
        ArrayList<Food> snacklist = gson.fromJson(gson_snack_adapter,new TypeToken<ArrayList<Food>>(){}.getType());

        morning_adapter.items = morninglist;
        lunch_adapter.items = lunchlist;
        dinner_adapter.items = dinnerlist;
        snack_adapter.items = snacklist;
        }

        Log.v("포럼 엑티비티 pause gson road", pref.getString(ID+DATE+"gson_morning_adapter",""));
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
        Gson gson = new Gson();
        //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
        pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        //에디터 선언
        SharedPreferences.Editor editor = pref.edit();

        //gson을 이용해 Json형식으로 변환하여 어뎁터데이터를 저장
        String gson_morning_adapter = gson.toJson(morning_adapter.items);
        Log.v("식단입력 엑티비티",gson_morning_adapter);
        String gson_lunch_adapter = gson.toJson(lunch_adapter.items);
        String gson_dinner_adapter = gson.toJson(dinner_adapter.items);
        String gson_snack_adapter = gson.toJson(snack_adapter.items);
        String gson_food_adapter = gson.toJson(adapter.items);

        //에디터에 json형식으로 변환된 객체값 집어넣기
        editor.putString(ID+"gson_food_adapter",gson_food_adapter);
        editor.putString(ID+DATE+"gson_morning_adapter",gson_morning_adapter);
        editor.putString(ID+DATE+"gson_lunch_adapter",gson_lunch_adapter);
        editor.putString(ID+DATE+"gson_dinner_adapter",gson_dinner_adapter);
        editor.putString(ID+DATE+"gson_snack_adapter",gson_snack_adapter);
        editor.commit();

        Log.v("포럼 엑티비티 pause gson road", pref.getString(ID+DATE+"gson_morning_adapter",""));

        //에디터에 저장
    }
}
