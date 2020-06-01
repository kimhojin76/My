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

public class act_custom_hours extends AppCompatActivity implements View.OnClickListener {
    EditText add_acthours_input;
    double acthours;
    String name;

    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("푸드셀렉트 엑티비티형 다이얼로그", "create");
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_hours);

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.85); //display 사이즈의 70%
        int height = (int) (display.getHeight() * 0.3);//90%
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;
        add_acthours_input = (EditText) findViewById(R.id.add_acthours_input);

        final Button acthours_button = (Button) findViewById(R.id.acthours_button);
        acthours_button.setOnClickListener(this);
        Intent intent = getIntent();




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
        if (v.getId() == R.id.acthours_button) {
            Log.v("푸드추가 엑티비티", "추가버튼 클릭 확인");


            Intent intent = new Intent(act_custom_hours.this,meal.class);
            intent.putExtra("음식명",name);

            setResult(230,intent);
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
