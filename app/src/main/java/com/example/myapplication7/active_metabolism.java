package com.example.myapplication7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class active_metabolism extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle bundle){
        Log.v("활동관리 엑티비티","create");

        super.onCreate(bundle);


        //BMR

        setContentView(R.layout.activity_metabolism);


        Button pal_level1 = (Button) findViewById(R.id.par_button1);
        pal_level1.setOnClickListener(this);
        Button pal_level2 = (Button) findViewById(R.id.par_button4);
        pal_level2.setOnClickListener(this);
        Button pal_level3 = (Button) findViewById(R.id.par_button3);
        pal_level3.setOnClickListener(this);
        Button pal_level4 = (Button) findViewById(R.id.par_button5);
        pal_level4.setOnClickListener(this);



        final TextView summation = (TextView) findViewById(R.id.textView2);
        summation.setOnClickListener(this);
        final TextView helper = (TextView) findViewById(R.id.textView5);
        helper.setOnClickListener(this);
        final TextView metabolism_management = (TextView) findViewById(R.id.textView6);
        metabolism_management.setOnClickListener(this);
        final TextView basic_food = (TextView) findViewById(R.id.textView8);
        basic_food.setOnClickListener(this);
        final TextView basic_graph = (TextView) findViewById(R.id.textView9);
        basic_graph.setOnClickListener(this);
        final TextView basic_main = (TextView) findViewById(R.id.textView10);
        basic_main.setOnClickListener(this);
        final ImageView basic_food_image = (ImageView) findViewById(R.id.imageView3);
        basic_food_image.setOnClickListener(this);
        final ImageView basic_graph_image = (ImageView) findViewById(R.id.imageView4);
        basic_graph_image.setOnClickListener(this);
        final ImageView basic_main_image = (ImageView) findViewById(R.id.imageView5);
        basic_main_image.setOnClickListener(this);
        final ImageView active_metabolism_add = (ImageView) findViewById(R.id.imageView8);
        active_metabolism_add.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        TextView BMR_input = (TextView) findViewById(R.id.basal_metabolism) ;
        TextView active_input = (TextView) findViewById(R.id.activity_metabolism) ;

        double active_kcal;
        if(v.getId() == R.id.textView2){
            Intent intent = new Intent(active_metabolism.this,basic_activity.class);
            startActivity(intent);
            finish();

            //지금 속해있는 액티비티
        }else if(v.getId() == R.id.textView5){
            Intent intent = new Intent(active_metabolism.this,bmr_activity.class);
            startActivity(intent);
            finish();

            //활동칼로리 계산
        }else if(v.getId() == R.id.textView6) {
            Intent intent = new Intent(active_metabolism.this, active_metabolism.class);
            startActivity(intent);
            finish();

            //식단으로 이동
        }else if(v.getId() == R.id.textView8) {
            Intent intent = new Intent(active_metabolism.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        }else if(v.getId() == R.id.textView9) {
            Intent intent = new Intent(active_metabolism.this, weight_graph.class);
            startActivity(intent);
            finish();

        }else if(v.getId() == R.id.par_button1) {

            Log.v("활동관리 엑티비티","par 버튼 1 클릭");
            Log.v("활동관리 엑티비티",BMR_input.getText().toString());
            double BMR = Double.parseDouble(BMR_input.getText().toString());
            active_input.setText(Double.toString(Math.round(BMR*1.5*10)/10));

        }else if(v.getId() == R.id.par_button4) {
            Log.v("활동관리 엑티비티","par 버튼 2 클릭");
            Log.v("활동관리 엑티비티",BMR_input.getText().toString());
            double BMR = Double.parseDouble(BMR_input.getText().toString());
            active_input.setText(Double.toString(Math.round(BMR*1.75*10)/10));
        }else if(v.getId() == R.id.par_button3) {
            Log.v("활동관리 엑티비티","par 버튼 3 클릭");
            Log.v("활동관리 엑티비티",BMR_input.getText().toString());
            double BMR = Double.parseDouble(BMR_input.getText().toString());
            active_input.setText(Double.toString(Math.round(BMR*1.62*10)/10));
        }else if(v.getId() == R.id.par_button5) {
            Log.v("활동관리 엑티비티","par 버튼 4 클릭");
            Log.v("활동관리 엑티비티",BMR_input.getText().toString());
            double BMR = Double.parseDouble(BMR_input.getText().toString());
            active_input.setText(Double.toString(Math.round(BMR*1.65*10)/10));
            //지금 속해있는 액티비티
        }else if(v.getId() == R.id.textView10){
            Intent intent = new Intent(active_metabolism.this,basic_activity.class);
            startActivity(intent);
            finish();


            //하단 식단그림 클릭시 이동
        }else if(v.getId() == R.id.imageView3) {
            Intent intent = new Intent(active_metabolism.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        }else if(v.getId() == R.id.imageView4) {
            Intent intent = new Intent(active_metabolism.this, weight_graph.class);
            startActivity(intent);
            finish();

            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        }else if(v.getId() == R.id.imageView5) {
            Intent intent = new Intent(active_metabolism.this, basic_activity.class);
            startActivity(intent);
            finish();

        }else if(v.getId() == R.id.imageView8) {
            Intent intent = new Intent(active_metabolism.this, metabolism_coustom.class);
            startActivity(intent);
            finish();

        }
    }
    @Override
    protected void onResume() {
        Log.v("활동관리 엑티비티","Resume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v("활동관리 엑티비티","Start");
        super.onStart();
        TextView BMR_input = (TextView) findViewById(R.id.basal_metabolism) ;
        Intent intent = getIntent();
        String BMR = intent.getStringExtra("BMR");
        if (BMR == null){

        }else {
            System.out.println(" BMR값 ");
            System.out.println(BMR);
            BMR_input.setText(BMR);
        }
    }

    @Override
    protected void onStop() {
        Log.v("활동관리 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("활동관리 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("활동관리 엑티비티","Pause");
        super.onPause();
    }

}
