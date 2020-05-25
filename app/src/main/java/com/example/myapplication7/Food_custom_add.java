package com.example.myapplication7;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Food_custom_add extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("푸드 추가 커스텀 엑티비티형 다이얼로그", "create");
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.food_recyle_ex);

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.85); //display 사이즈의 70%
        int height = (int) (display.getHeight() * 0.6);//90%
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

        Button save = (Button) findViewById(R.id.add_food);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final EditText add_foodname = (EditText) findViewById(R.id.add_foodname_input);
        add_foodname.setOnClickListener(this);
        final EditText add_kcal = (EditText) findViewById(R.id.add_kcal_input);
        add_foodname.setOnClickListener(this);
        final EditText add_car = (EditText) findViewById(R.id.add_car_input);
        add_foodname.setOnClickListener(this);
        final EditText add_pro = (EditText) findViewById(R.id.add_pro_input);
        add_foodname.setOnClickListener(this);
        final EditText add_fat = (EditText) findViewById(R.id.add_fat_input);
        add_foodname.setOnClickListener(this);
        final Button add_food_button = (Button) findViewById(R.id.food_add_button);
        add_food_button.setOnClickListener(this);


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
        if (v.getId() == R.id.food_add_button) {
            Log.v("푸드추가 엑티비티", "추가버튼 클릭 확인");

        }
    }
}
