package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class bmr_activity extends AppCompatActivity implements View.OnClickListener {
    public String PREFERENCE = "com.studio572.samplesharepreference";
    private String ID,DATE;

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("BMR 엑티비티","create");
        super.onCreate(bundle);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        ID = pref.getString("ID","");
        setContentView(R.layout.bmr_calculator);
        RadioButton male = (RadioButton) findViewById(R.id.gender_input_male);
        RadioButton female = (RadioButton) findViewById(R.id.gender_input2_female);
        final Button start_diet = (Button) findViewById(R.id.start_diet);
        final Button activity_move = (Button) findViewById(R.id.activity_move);
        final Button reset_button = (Button) findViewById(R.id.reset_button);


        activity_move.setOnClickListener(this);
        start_diet.setOnClickListener(this);
        reset_button.setOnClickListener(this);
        final TextView bmr_helper = (TextView) findViewById(R.id.textView5);
        bmr_helper.setOnClickListener(this);
        final TextView bmr_food = (TextView) findViewById(R.id.textView8);
        bmr_food.setOnClickListener(this);
        final TextView bmr_graph = (TextView) findViewById(R.id.textView9);
        bmr_graph.setOnClickListener(this);
        final TextView bmr_main = (TextView) findViewById(R.id.textView10);
        bmr_main.setOnClickListener(this);
        final TextView basic_forum = (TextView) findViewById(R.id.textView16);
        basic_forum.setOnClickListener(this);
        final ImageView bmr_food_image = (ImageView) findViewById(R.id.imageView3);
        bmr_food_image.setOnClickListener(this);
        final ImageView bmr_graph_image = (ImageView) findViewById(R.id.imageView4);
        bmr_graph_image.setOnClickListener(this);
        final ImageView bmr_main_image = (ImageView) findViewById(R.id.imageView5);
        bmr_main_image.setOnClickListener(this);
        final ImageView basic_kcal_image = (ImageView) findViewById(R.id.imageView6);
        basic_kcal_image.setOnClickListener(this);
        final ImageView basic_forum_image = (ImageView) findViewById(R.id.imageView7);
        basic_forum_image.setOnClickListener(this);
        //스타트 버튼 클릭

    }

    @Override
    public void onClick(View v) {
        EditText target_weight = (EditText) findViewById(R.id.taget_weight_input);
        RadioButton male = (RadioButton) findViewById(R.id.gender_input_male);
        RadioButton female = (RadioButton) findViewById(R.id.gender_input2_female);
        Button start_diet = (Button) findViewById(R.id.start_diet);
        EditText weight = (EditText) findViewById(R.id.now_weight_input);
        EditText age = (EditText) findViewById(R.id.now_age_input);
        EditText stature = (EditText) findViewById(R.id.now_stature_input);
        TextView BMR = (TextView) findViewById(R.id.bmr_input);
        TextView down_kcal = (TextView) findViewById(R.id.down_kcal);
        TextView diet_date = (TextView) findViewById(R.id.diet_date);
        RadioGroup gender = (RadioGroup) findViewById(R.id.gender_group);
        TextView last_kcal = (TextView) findViewById(R.id.last_kcal);





        if (v.getId() == R.id.textView5) {


            //활동칼로리 계산
        } else if (v.getId() == R.id.textView8) {

            Intent intent = new Intent(bmr_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        } else if (v.getId() == R.id.textView9) {
            Intent intent = new Intent(bmr_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

        }
        //지금 속해있는 액티비티
        else if (v.getId() == R.id.textView10) {
            Intent intent = new Intent(bmr_activity.this, basic_activity.class);
            startActivity(intent);
            finish();


            //하단 식단그림 클릭시 이동
        }else if(v.getId() == R.id.textView16) {
            Intent intent = new Intent(bmr_activity.this, forum_activity.class);
            startActivity(intent);
            finish();

        //활동대사량 버튼 클릭
        }else if (v.getId() == R.id.activity_move) {
            Log.v("BMR 엑티비티","활동대사 버튼 클릭");
            Intent intent = new Intent(bmr_activity.this, active_metabolism.class);
            startActivity(intent);
        //리셋 버튼 클릭
        } else if (v.getId() == R.id.reset_button) {
            Log.v("BMR 엑티비티","초기화 클릭");
            weight.setText(null);
            stature.setText(null);
            age.setText(null);
            target_weight.setText(null);
            down_kcal.setText(null);
            BMR.setText(null);
            diet_date.setText(null);
            male.setChecked(false);
            female.setChecked(false);
            last_kcal.setText(null);

        } else if (v.getId() == R.id.imageView3) {
            Intent intent = new Intent(bmr_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        } else if (v.getId() == R.id.imageView4) {
            Intent intent = new Intent(bmr_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        } else if (v.getId() == R.id.imageView5) {
            Intent intent = new Intent(bmr_activity.this, basic_activity.class);
            startActivity(intent);
            finish();

        }  else if (v.getId() == R.id.imageView7) {
            Intent intent = new Intent(bmr_activity.this, forum_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        }  else if (v.getId() == R.id.start_diet) {
//계산버튼 클릭
            Log.v("BMR엑티비티", "계산버튼 클릭");
            //기초대사량 공식 남성 : BMR(기초대사량) = (10*체중)+(6.25*신장)-(5*나이)+5
            //기초대사량 공식 여성 : BMR(기초대사량) = (10*체중)+(6.25*신장)-(5*나이)-161
            if (TextUtils.isEmpty(weight.getText().toString()) == true || TextUtils.isEmpty(stature.getText().toString()) == true || TextUtils.isEmpty(age.getText().toString()) == true || gender.getCheckedRadioButtonId() == -1 || TextUtils.isEmpty(target_weight.getText().toString()) == true || TextUtils.isEmpty(down_kcal.getText().toString())) {
                Log.v("BMR엑티비티", "스타트버튼 클릭, 필수입력값 선택안함.");
                Toast.makeText(bmr_activity.this, "체중,신장,목표체중,나이,성별, 감량 칼로리를 입력해주세요", Toast.LENGTH_LONG).show();

            } else if(Integer.parseInt(target_weight.getText().toString()) > Integer.parseInt(weight.getText().toString())){
                Toast.makeText(bmr_activity.this, "목표 체중이 현재 체중보다 낮게 설정되어 있습니다.", Toast.LENGTH_LONG).show();
            }
            else {
                double gender_Kcal;
                if (male.isChecked() == true) {
                    gender_Kcal = 5;
                } else {
                    gender_Kcal = -161;
                }
                double weightint = (10 * Double.parseDouble(weight.getText().toString())) + (6.25 * Double.parseDouble(stature.getText().toString())) - (5 * Double.parseDouble(age.getText().toString())) + gender_Kcal;
                System.out.println(weightint);

                double now_weight_double = Double.parseDouble(weight.getText().toString());
                double target_weight_double = Double.parseDouble(target_weight.getText().toString());
                double diet_date_double = ((now_weight_double - target_weight_double) * 7000) / Double.parseDouble(down_kcal.getText().toString());
                System.out.println(Math.round(diet_date_double));

                diet_date.setText( String.format("%.0f", diet_date_double));
                BMR.setText(String.format("%.0f", weightint));



            }


        }
    }
    @Override
    protected void onResume() {


        Log.v("BMR 엑티비티","Resume");

        EditText age = (EditText) findViewById(R.id.now_age_input);
        EditText target_weight = (EditText) findViewById(R.id.taget_weight_input);
        RadioButton male = (RadioButton) findViewById(R.id.gender_input_male);
        RadioButton female = (RadioButton) findViewById(R.id.gender_input2_female);
        EditText stature = (EditText) findViewById(R.id.now_stature_input);
        TextView BMR = (TextView) findViewById(R.id.bmr_input) ;
        EditText down_kcal = (EditText) findViewById((R.id.down_kcal));
        TextView diet_date = (TextView) findViewById(R.id.diet_date) ;
        EditText weight = (EditText) findViewById(R.id.now_weight_input);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        TextView lastkcal_car_text = (TextView) findViewById(R.id.lastkcal_car_text);
        TextView last_kcal = (TextView) findViewById(R.id.last_kcal);
        TextView lastkcal_pro_text = (TextView) findViewById(R.id.lastkcal_pro_text);
        TextView lastkcal_fat_text = (TextView) findViewById(R.id.lastkcal_fat_text);
        ProgressBar last_kcal_seekbar_car = (ProgressBar) findViewById(R.id.last_kcal_seekbar_car);
        ProgressBar last_kcal_seekbar_pro = (ProgressBar) findViewById(R.id.last_kcal_seekbar_pro);
        ProgressBar last_kcal_seekbar_fat = (ProgressBar) findViewById(R.id.last_kcal_seekbar_fat);
        DATE = pref.getString(ID+"date","");

        String bmr_lastkcal = pref.getString(ID+"PAL","");
        String bmr_weight = pref.getString(ID+"weight","");
        String bmr_stature = pref.getString(ID+"stature","");
        String bmr_age = pref.getString(ID+"age","");
        String bmr_target_weight = pref.getString(ID+"target_weight","");
        String bmr_diet_date = pref.getString(ID+"다이어트기간","");
        String bmr_BMR = pref.getString(ID+"BMR","");
        String bmr_down_kcal = pref.getString(ID+"down_kcal","");
        boolean putmale = pref.getBoolean(ID+"male",false);
        boolean putfemale = pref.getBoolean(ID+"female",false);

        male.setChecked(putmale);
        female.setChecked(putfemale);

        last_kcal.setText(bmr_lastkcal);
        weight.setText(bmr_weight);
        stature.setText(bmr_stature);
        age.setText(bmr_age);
        target_weight.setText(bmr_target_weight);
        diet_date.setText(bmr_diet_date);
        BMR.setText(bmr_BMR);
        down_kcal.setText(bmr_down_kcal);


        String gson_morning_adapter = pref.getString(ID+DATE+"gson_morning_adapter","");
        String gson_lunch_adapter = pref.getString(ID+DATE+"gson_lunch_adapter","");
        String gson_dinner_adapter = pref.getString(ID+DATE+"gson_dinner_adapter","");
        String gson_snack_adapter = pref.getString(ID+DATE+"gson_snack_adapter","");
        Gson gson = new Gson();
        double user_date_meal_kcal = 0;
        double user_date_meal_car = 0;
        double user_date_meal_pro = 0;
        double user_date_meal_fat = 0;

        double user_morning_kcal = 0;
        double user_morning_car = 0;
        double user_morning_pro = 0;
        double user_morning_fat = 0;

        double user_lunch_kcal = 0;
        double user_lunch_car = 0;
        double user_lunch_pro = 0;
        double user_lunch_fat = 0;

        double user_dinner_kcal = 0;
        double user_dinner_car = 0;
        double user_dinner_pro = 0;
        double user_dinner_fat = 0;

        double user_snack_kcal = 0;
        double user_snack_car = 0;
        double user_snack_pro = 0;
        double user_snack_fat = 0;
        FoodAdapter2 morning_adapter = new FoodAdapter2();
        FoodAdapter2 lunch_adapter = new FoodAdapter2();
        FoodAdapter2 dinner_adapter = new FoodAdapter2();
        FoodAdapter2 snack_adapter = new FoodAdapter2();
        if(gson_morning_adapter != ""){
            ArrayList<Food> morninglist = gson.fromJson(gson_morning_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
//            ArrayList<Food> dinnerlist = gson.fromJson(gson_dinner_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
//            ArrayList<Food> snacklist = gson.fromJson(gson_snack_adapter,new TypeToken<ArrayList<Food>>(){}.getType());

            morning_adapter.items = morninglist;
            Log.v("베이직 엑티비티 리줌",gson_morning_adapter);
            for (int i = 0; i < morninglist.size(); i++) {
                Food item1 = morning_adapter.getItem(i);
                Log.v("식단입력 엑티비티", item1.getName());
                user_morning_car = user_morning_car + Double.parseDouble(item1.getCar());
                user_morning_pro = user_morning_pro + Double.parseDouble(item1.getPro());
                user_morning_fat = user_morning_fat + Double.parseDouble(item1.getFat());
                user_morning_kcal = user_morning_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        if(gson_lunch_adapter != ""){
            ArrayList<Food> lunchlist = gson.fromJson(gson_lunch_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            lunch_adapter.items = lunchlist;
            for (int i = 0; i < lunchlist.size(); i++) {
                Food item1 = lunch_adapter.getItem(i);
                user_lunch_car = user_lunch_car + Double.parseDouble(item1.getCar());
                user_lunch_pro = user_lunch_pro + Double.parseDouble(item1.getPro());
                user_lunch_fat = user_lunch_fat + Double.parseDouble(item1.getFat());
                user_lunch_kcal = user_lunch_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        if(gson_dinner_adapter != ""){
            ArrayList<Food> lunchlist = gson.fromJson(gson_dinner_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            dinner_adapter.items = lunchlist;
            for (int i = 0; i < lunchlist.size(); i++) {
                Food item1 = dinner_adapter.getItem(i);
                user_dinner_car = user_dinner_car + Double.parseDouble(item1.getCar());
                user_dinner_pro = user_dinner_pro + Double.parseDouble(item1.getPro());
                user_dinner_fat = user_dinner_fat + Double.parseDouble(item1.getFat());
                user_dinner_kcal = user_dinner_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        if(gson_snack_adapter != ""){
            ArrayList<Food> lunchlist = gson.fromJson(gson_snack_adapter,new TypeToken<ArrayList<Food>>(){}.getType());
            snack_adapter.items = lunchlist;
            for (int i = 0; i < lunchlist.size(); i++) {
                Food item1 = snack_adapter.getItem(i);
                user_snack_car = user_snack_car + Double.parseDouble(item1.getCar());
                user_snack_pro = user_snack_pro + Double.parseDouble(item1.getPro());
                user_snack_fat = user_snack_fat + Double.parseDouble(item1.getFat());
                user_snack_kcal = user_snack_kcal + Double.parseDouble(item1.getKcal());
            }
        }
        user_date_meal_car = user_morning_car+user_lunch_car+user_dinner_car+user_snack_car;
        user_date_meal_pro = user_morning_pro+user_lunch_pro+user_dinner_pro+user_snack_pro;
        user_date_meal_fat = user_morning_fat+user_lunch_fat+user_dinner_fat+user_snack_fat;
        //섭취칼로리량




        if (bmr_lastkcal != "") {
            double max_kcal = Double.parseDouble(bmr_lastkcal)-Double.parseDouble(bmr_down_kcal);
            double max_car = ((max_kcal / 100)*50) / 4;
            double max_pro = ((max_kcal / 100)*30) / 4;
            double max_fat = ((max_kcal / 100)*20) / 9;
            last_kcal.setText(String.format("%.0f", max_kcal)+"Kcal");
            String last_Kcal = String.format("%.0f", max_kcal);
            String last_car = String.format("%.0f", max_car);
            String last_pro = String.format("%.0f", max_pro);
            String last_fat = String.format("%.0f", max_fat);

            lastkcal_car_text.setText("탄수"+ String.format("%.0f", user_date_meal_car) + "/"+last_car+"g");
            lastkcal_pro_text.setText("단백질"+String.format("%.0f", user_date_meal_pro) + "/" + last_pro+"g");
            lastkcal_fat_text.setText("지방"+String.format("%.0f", user_date_meal_fat) + "/" + last_fat+"g");
            last_kcal_seekbar_car.setMax(Integer.parseInt(last_car));
            last_kcal_seekbar_car.setProgress((int)user_date_meal_car);

            last_kcal_seekbar_pro.setMax(Integer.parseInt(last_pro));
            last_kcal_seekbar_pro.setProgress((int)user_date_meal_pro);

            last_kcal_seekbar_fat.setMax(Integer.parseInt(last_fat));
            last_kcal_seekbar_fat.setProgress((int)user_date_meal_fat);

            SharedPreferences.Editor editor = pref.edit();
        }








        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v("BMR 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("BMR 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("BMR 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("BMR 엑티비티","Pause");
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        EditText age = (EditText) findViewById(R.id.now_age_input);
        EditText target_weight = (EditText) findViewById(R.id.taget_weight_input);
        RadioButton male = (RadioButton) findViewById(R.id.gender_input_male);
        RadioButton female = (RadioButton) findViewById(R.id.gender_input2_female);
        Button start_diet = (Button) findViewById(R.id.start_diet);
        EditText stature = (EditText) findViewById(R.id.now_stature_input);
        TextView diet_date = (TextView) findViewById(R.id.diet_date) ;
        EditText weight = (EditText) findViewById(R.id.now_weight_input);
        TextView BMR = (TextView) findViewById(R.id.bmr_input) ;
        EditText down_kcal = (EditText) findViewById((R.id.down_kcal));


        editor.putString(ID+"weight",weight.getText().toString());
        editor.putString(ID+"stature",stature.getText().toString());
        editor.putString(ID+"age",age.getText().toString());
        editor.putString(ID+"target_weight",target_weight.getText().toString());
        editor.putString(ID+"BMR",BMR.getText().toString());
        editor.putString(ID+"down_kcal",down_kcal.getText().toString());
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");

        Date time = new Date();
        String time1 = format2.format(time);


        String bmr_down_kcal = pref.getString(ID+"down_kcal","");
        String bmr_lastkcal = pref.getString(ID+"PAL","");
        if (bmr_lastkcal != "") {
            double max_kcal = Double.parseDouble(bmr_lastkcal)-Double.parseDouble(bmr_down_kcal);
            double max_car = ((max_kcal / 100)*50) / 4;
            double max_pro = ((max_kcal / 100)*30) / 4;
            double max_fat = ((max_kcal / 100)*20) / 9;
            String last_Kcal = String.format("%.0f", max_kcal);
            String last_car = String.format("%.0f", max_car);
            String last_pro = String.format("%.0f", max_pro);
            String last_fat = String.format("%.0f", max_fat);
            diet_date.getText();
            editor.putString(ID+"다이어트시작일",time1);
            editor.putString(ID+"다이어트기간",diet_date.getText().toString());
            editor.putString(ID+"max_car",last_car);
            editor.putString(ID+"max_pro",last_pro);
            editor.putString(ID+"max_fat",last_fat);
            editor.putString(ID+"max_kcal",last_Kcal);
            editor.commit();


        }


        editor.commit();
        if(male.isChecked()==true){
            editor.putBoolean(ID+"male",true);
            editor.putBoolean(ID+"female",false);
        }else {
            editor.putBoolean(ID+"male",false);
            editor.putBoolean(ID+"female",true);
        }

        editor.commit();




















        super.onPause();
    }
    public void onBackPressed() {
        Intent intent = new Intent(bmr_activity.this, basic_activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }


}
