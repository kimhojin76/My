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
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Food_custom_weight extends AppCompatActivity implements View.OnClickListener {
    EditText add_weight;
    double add_kcal,add_car,add_pro,add_fat;
    String name;

    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("푸드셀렉트 엑티비티형 다이얼로그", "create");
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.food_weight);

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.85); //display 사이즈의 70%
        int height = (int) (display.getHeight() * 0.3);//90%
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;
        add_weight = (EditText) findViewById(R.id.add_foodweight_input);

        final Button food_add_weight_button = (Button) findViewById(R.id.food_add_weight_button);
        food_add_weight_button.setOnClickListener(this);
        Intent intent = getIntent();
        add_kcal = Double.parseDouble(intent.getStringExtra("칼로리"))/100;
        add_car = Double.parseDouble(intent.getStringExtra("탄수화물"))/100;
        add_pro = Double.parseDouble(intent.getStringExtra("단백질"))/100;
        add_fat = Double.parseDouble(intent.getStringExtra("지방"))/100;
        name = intent.getStringExtra("음식명");




    }








    @Override
    protected void onResume() {
        Log.v("푸드추가 엑티비티", "Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("푸드추가 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("푸드추가 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("푸드추가 엑티비티", "Destroy");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v("푸드추가 엑티비티", "Pause");
        super.onPause();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.food_add_weight_button) {
            Log.v("푸드추가 엑티비티", "추가버튼 클릭 확인");
            double input_weight = Double.parseDouble(add_weight.getText().toString());
            double food_kcal = (Math.round(input_weight * add_kcal*10)/10.0);
            double food_car = (Math.round(input_weight * add_car*10)/10.0);
            double food_pro = (Math.round(input_weight * add_pro*10)/10.0);
            double food_fat = (Math.round(input_weight * add_fat*10)/10.0);

            Intent intent = new Intent(Food_custom_weight.this,meal.class);
            intent.putExtra("음식명",name);
            intent.putExtra("칼로리",Double.toString(food_kcal));
            intent.putExtra("탄수화물",Double.toString(food_car));
            intent.putExtra("단백질",Double.toString(food_pro));
            intent.putExtra("지방",Double.toString(food_fat));
            intent.putExtra("중량",Double.toString(input_weight));
            setResult(220,intent);
            finish();

//            Log.v("푸드추가 엑티비티", add_foodname.getText().toString());
//
//            Intent data = new Intent(Food_custom_weight.this, meal.class);
//            data.putExtra("음식명",add_foodname.getText().toString());
//            data.putExtra("칼로리",add_kcal.getText().toString());
//            data.putExtra("탄수화물",add_car.getText().toString());
//            data.putExtra("단백질",add_pro.getText().toString());
//            data.putExtra("지방",add_fat.getText().toString());
//            setResult(210,data);
//            finish();

        }
    }
}
