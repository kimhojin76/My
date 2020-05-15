package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            final EditText nametext = (EditText) findViewById(R.id.id_text1);
            final EditText passwordtext = (EditText) findViewById(R.id.login_password1);
        Button loginbutton = (Button) findViewById(R.id.login_button1);
        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), SignUp_Activity.class);
                startActivity(intent);
            }
        });


    }
}
