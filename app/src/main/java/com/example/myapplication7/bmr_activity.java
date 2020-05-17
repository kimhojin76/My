package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class bmr_activity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle bundle){
        Log.v("BMR 엑티비티","create");
        super.onCreate(bundle);
        setContentView(R.layout.bmr_calculator);
        final EditText age = (EditText) findViewById(R.id.now_age_input);
        EditText target_weight = (EditText) findViewById(R.id.taget_weight_input);
        RadioButton male = (RadioButton) findViewById(R.id.gender_input_male);
        RadioButton female = (RadioButton) findViewById(R.id.gender_input2_female);
        Button start_diet = (Button) findViewById(R.id.start_diet);
        EditText weight = (EditText) findViewById(R.id.now_weight_input);
        EditText stature = (EditText) findViewById(R.id.now_stature_input);
        TextView PAL = (TextView) findViewById(R.id.pal_input) ;
        TextView diet_date = (TextView) findViewById(R.id.diet_date) ;


        final TextView bmr_summation = (TextView) findViewById(R.id.bmr_textView2);
        bmr_summation.setOnClickListener(this);
        final TextView bmr_helper = (TextView) findViewById(R.id.bmr_textView5);
        bmr_helper.setOnClickListener(this);
        final TextView bmr_metabolism_management = (TextView) findViewById(R.id.bmr_textView6);
        bmr_metabolism_management.setOnClickListener(this);
        final TextView bmr_food = (TextView) findViewById(R.id.bmr_textView8);
        bmr_food.setOnClickListener(this);
        final TextView bmr_graph = (TextView) findViewById(R.id.bmr_textView9);
        bmr_graph.setOnClickListener(this);
        final TextView bmr_main = (TextView) findViewById(R.id.bmr_textView10);
        bmr_main.setOnClickListener(this);
        final ImageView bmr_food_image = (ImageView) findViewById(R.id.bmr_imageView3);
        bmr_food_image.setOnClickListener(this);
        final ImageView bmr_graph_image = (ImageView) findViewById(R.id.bmr_imageView4);
        bmr_graph_image.setOnClickListener(this);
        final ImageView bmr_main_image = (ImageView) findViewById(R.id.bmr_imageView5);
        bmr_main_image.setOnClickListener(this);
        start_diet.setOnClickListener(this);
        //스타트 버튼 클릭

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bmr_textView2) {
            Intent intent = new Intent(bmr_activity.this, basic_activity.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.bmr_textView5) {
            Intent intent = new Intent(bmr_activity.this, bmr_activity.class);
            startActivity(intent);
            finish();

            //활동칼로리 계산
        } else if (v.getId() == R.id.bmr_textView6) {
            TextView BMR = (TextView) findViewById(R.id.bmr_input) ;
            double bmr_next = Double.parseDouble(BMR.getText().toString());

            Intent intent = new Intent(bmr_activity.this, active_metabolism.class );
            intent.putExtra("기초대사량",bmr_next);

            startActivity(intent);
            finish();

            //식단으로 이동
        } else if (v.getId() == R.id.bmr_textView8) {
            Intent intent = new Intent(bmr_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        } else if (v.getId() == R.id.bmr_textView9) {
            Intent intent = new Intent(bmr_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

        }
        //지금 속해있는 액티비티
        else if (v.getId() == R.id.bmr_textView10) {
            Intent intent = new Intent(bmr_activity.this, basic_activity.class);
            startActivity(intent);
            finish();

            //하단 식단그림 클릭시 이동
        } else if (v.getId() == R.id.bmr_imageView3) {
            Intent intent = new Intent(bmr_activity.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        } else if (v.getId() == R.id.bmr_imageView4) {
            Intent intent = new Intent(bmr_activity.this, weight_graph.class);
            startActivity(intent);
            finish();

            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        } else if (v.getId() == R.id.bmr_imageView5) {
            Intent intent = new Intent(bmr_activity.this, basic_activity.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.start_diet) {
            EditText target_weight = (EditText) findViewById(R.id.taget_weight_input);
            RadioButton male = (RadioButton) findViewById(R.id.gender_input_male);
            RadioButton female = (RadioButton) findViewById(R.id.gender_input2_female);
            Button start_diet = (Button) findViewById(R.id.start_diet);
            EditText weight = (EditText) findViewById(R.id.now_weight_input);
            EditText age = (EditText) findViewById(R.id.now_age_input);
            EditText stature = (EditText) findViewById(R.id.now_stature_input);
            TextView BMR = (TextView) findViewById(R.id.bmr_input) ;
            TextView PAL = (TextView) findViewById(R.id.pal_input) ;
            TextView diet_date = (TextView) findViewById(R.id.diet_date) ;
            Log.v("BMR엑티비티","스타트버튼 클릭");
            //기초대사량 공식 남성 : BMR(기초대사량) = (10*체중)+(6.25*신장)-(5*나이)+5
            //기초대사량 공식 여성 : BMR(기초대사량) = (10*체중)+(6.25*신장)-(5*나이)-161
            if(TextUtils.isEmpty(weight.getText().toString()) == true || TextUtils.isEmpty(stature.getText().toString()) == true||TextUtils.isEmpty(age.getText().toString()) == true){

                Log.v("BMR엑티비티","스타트버튼 클릭, 필수입력값 선택안함.");
                Toast.makeText(bmr_activity.this,"체중,신장,목표체중,나이,성별을 입력해주세요",Toast.LENGTH_LONG).show();

            }else {
                double weightint = (10 * Integer.parseInt(weight.getText().toString())) + (6.25 * Integer.parseInt(stature.getText().toString())) - (5 * Integer.parseInt(age.getText().toString()));
                System.out.println(weightint);
                double now_weight_double = Double.parseDouble(weight.getText().toString());
                double target_weight_double = Double.parseDouble(target_weight.getText().toString());
                double diet_date_double = ((now_weight_double - target_weight_double) * 7000) / 500;
                System.out.println(Math.round(diet_date_double));
                diet_date.setText(Double.toString(Math.round(diet_date_double)));
                BMR.setText(Double.toString(Math.round(weightint)));

}




        } else if (v.getId() == R.id.end_diet) {

        }
    }
    @Override
    protected void onResume() {
        Log.v("BMR 엑티비티","Resume");
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
        super.onPause();
    }


}
