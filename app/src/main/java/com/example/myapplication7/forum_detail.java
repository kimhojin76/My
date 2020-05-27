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
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class forum_detail extends AppCompatActivity implements View.OnClickListener {
    String title,date,contents,nickname;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("포럼디테일", "create");
        super.onCreate(bundle);
        setContentView(R.layout.forum_item_detail);
        final TextView basic_food = (TextView) findViewById(R.id.textView8);

        TextView title2= (TextView) findViewById(R.id.forum_detail_title);
        TextView nickname2= (TextView) findViewById(R.id.forum_detail_nickname);
        TextView date2= (TextView) findViewById(R.id.forum_detail_date);
        TextView contents2= (TextView) findViewById(R.id.forum_detail_contents);

        Intent intent = getIntent();
        Log.v("포럼디테일", "인텐트 겟");
        title = intent.getStringExtra("제목").toString();
        Log.v("포럼디테일", title);

        nickname=intent.getStringExtra("닉네임").toString();
        date=intent.getStringExtra("날짜").toString();
        contents=intent.getStringExtra("내용").toString();

        title2.setText(title);
        nickname2.setText(nickname);
        date2.setText(date);
        contents2.setText(contents);



    }








    @Override
    protected void onResume() {
        Log.v("포럼디테일 엑티비티", "Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("포럼디테일 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("포럼디테일 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("포럼디테일 엑티비티", "Destroy");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v("포럼디테일 엑티비티", "Pause");
        super.onPause();
    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.v("포럼디테일 엑티비티", "도착");

        if (requestCode==1011)
        {
            Log.v("포럼디테일 엑티비티", "조건문 도착");
            Intent intent = data;
            Log.v("포럼 엑티비티", intent.getStringExtra("제목").toString());
            Log.v("포럼 엑티비티", intent.getStringExtra("닉네임").toString());
            Log.v("포럼 엑티비티", intent.getStringExtra("날짜").toString());
            Log.v("포럼 엑티비티", intent.getStringExtra("내용").toString());

            title =intent.getStringExtra("제목").toString();
            nickname=intent.getStringExtra("닉네임").toString();
            date=intent.getStringExtra("날짜").toString();
            contents=intent.getStringExtra("내용").toString();
        }
    }
    @Override
    public void onClick(View v) {

//            Intent data = new Intent(forum_detail.this, meal.class);
//            data.putExtra("음식명",add_foodname.getText().toString());
//            data.putExtra("칼로리",add_kcal.getText().toString());
//            data.putExtra("탄수화물",add_car.getText().toString());
//            data.putExtra("단백질",add_pro.getText().toString());
//            data.putExtra("지방",add_fat.getText().toString());
//            setResult(200,data);
//            finish();

        }
    }

