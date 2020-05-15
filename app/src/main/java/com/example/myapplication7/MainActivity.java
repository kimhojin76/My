package com.example.myapplication7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);
            final EditText nametext = (EditText) findViewById(R.id.id_text1);
            final EditText passwordtext = (EditText) findViewById(R.id.login_password1);
            final TextView find_pass = (TextView) findViewById(R.id.login_findpassword1);
            final TextView sign_up = (TextView) findViewById(R.id.sign_up1) ;
            Button loginbutton = (Button) findViewById(R.id.login_button1);

        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String name = nametext.getText().toString();
                Intent intent = new Intent(getApplicationContext(), basic_activity.class);
                startActivity(intent);
            }
        });
        find_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), find_password.class);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup_activity.class);
                startActivity(intent);
            }
        });



    }
}
