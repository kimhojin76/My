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
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class metabolism_coustom extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("활동관리커스텀 엑티비티", "create");
        super.onCreate(bundle);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.metabolism_coustom);

        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = (int) (display.getWidth() * 0.85); //display 사이즈의 70%
        int height = (int) (display.getHeight() * 0.6);//90%
        getWindow().getAttributes().width = width;
        getWindow().getAttributes().height = height;

        Button save = (Button) findViewById(R.id.add_custom_pal);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        final TextView sleep = (TextView) findViewById(R.id.sleep_pal);
        sleep.setOnClickListener(this);
        final TextView sleep2 = (TextView) findViewById(R.id.sleep_pal2);
        sleep2.setOnClickListener(this);


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
        if (v.getId() == R.id.sleep_pal) {
            Log.v("활동관리커스텀 엑티비티", "슬립 클릭 확인");
        } else if (v.getId() == R.id.sleep_pal2) {
            Log.v("활동관리커스텀 엑티비티", "슬립 클릭 확인");
        }
    }
}
