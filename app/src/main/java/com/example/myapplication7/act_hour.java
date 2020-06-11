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

public class act_hour extends AppCompatActivity implements View.OnClickListener {
    EditText add_hour;
    String name;


    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("푸드셀렉트 엑티비티형 다이얼로그", "create");
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.act_hour);

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.85); //display 사이즈의 70%
        int height = (int) (display.getHeight() * 0.3);//90%
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;
        add_hour = (EditText) findViewById(R.id.add_acthour_input);

        final Button acthour_button = (Button) findViewById(R.id.acthour_button);
        acthour_button.setOnClickListener(this);
        Intent intent = getIntent();
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
            if (add_hour.getText().toString() != "" ) {
                double input_hour = Double.parseDouble(add_hour.getText().toString());
                Intent intent = new Intent(act_hour.this,meal.class);
                intent.putExtra("음식명",name);
                intent.putExtra("중량",String.format("%.0f", input_hour));
                setResult(250,intent);
                finish();
            }else{

            }



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
