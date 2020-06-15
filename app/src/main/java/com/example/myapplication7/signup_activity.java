package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.GenericLifecycleObserver;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;

public class signup_activity extends AppCompatActivity
        implements View.OnClickListener{
    static final int REQUEST_IMAGE_GET = 1;
    public String PREFERENCE = "com.studio572.samplesharepreference";
    SharedPreferences pref;
    ArrayList<signup> list;
    EditText signup_id,signup_nickname,signup_password,signup_repassword,signup_email;
    Uri imageUri;
//f

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("회원가입 엑티비티","create");
         pref =getSharedPreferences(PREFERENCE,MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();
        Gson gson = new Gson();


        super.onCreate(bundle);
        setContentView(R.layout.acrivi_sign_up);
        final Button image_button = (Button) findViewById(R.id.image_upload_button);
        image_button.setOnClickListener(this);
        Button id_test_button = (Button) findViewById(R.id.id_check_button);
        id_test_button.setOnClickListener(this);
        Button signup_activity_button = (Button) findViewById(R.id.button3);
        signup_activity_button.setOnClickListener(this);
         signup_id = (EditText)findViewById(R.id.signup_id);
         signup_nickname = (EditText)findViewById(R.id.signup_nickname);
         signup_password = (EditText)findViewById(R.id.signup_password);
         signup_repassword = (EditText)findViewById(R.id.signup_repassword);
         signup_email = (EditText)findViewById(R.id.signup_email);
        list = new ArrayList<signup>();
        if(pref.getString("ID_list","") == "") {
            list.add(new signup("admin", "관리자", "0000", "crazybear1@naver.com", "content://com.android.providers.media.documents/document/image%3A16196"));
            String first = gson.toJson(list);
            Log.v("회원가입 엑티비티", first);
            edit.putString("ID_list", first);
            edit.commit();
        }


    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor edit = pref.edit();

        if(v.getId() == R.id.id_check_button){
            Toast.makeText(signup_activity.this, "아이디 중복 확인",Toast.LENGTH_SHORT).show();
        }else if(v.getId() == R.id.button3) {
            String idlist=pref.getString("ID_list","");
            if (idlist=="") {
                Gson gson = new Gson();
                String firstidlist = gson.toJson(list);
                Log.v("회원가입 엑티비티", firstidlist);
                edit.commit();

            }else if (idlist!=""){
                Gson gson = new Gson();
                String firstidlist = pref.getString("ID_list","");

                ArrayList<signup> signuplist = gson.fromJson(firstidlist,new TypeToken<ArrayList<signup>>(){}.getType());
                for (int i = 0; i < signuplist.size(); i++) {
                    if (signup_id.getText().toString() == signuplist.get(i).getId()){
                        Toast.makeText(signup_activity.this, "중복된 아이디입니다.",Toast.LENGTH_SHORT).show();
                        finish();
                    }else if(signup_nickname.getText().toString() == signuplist.get(i).getNickname()){
                        Toast.makeText(signup_activity.this, "중복된 닉네임입니다.",Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }
                signuplist.add(new signup(signup_id.getText().toString(),signup_nickname.getText().toString(),signup_password.getText().toString(),signup_email.getText().toString(),imageUri.toString()));
                String list = gson.toJson(signuplist);
                edit.putString("ID_list",list);
                edit.commit();
                Log.v("회원가입 엑티비티", list);

                Toast.makeText(signup_activity.this, "회원가입 되었습니다.", Toast.LENGTH_SHORT).show();
                finish();
            }
//            if(idlist == ""){
//                list.add(new signup(signup_id.getText().toString(),signup_nickname.getText().toString(),signup_password.getText().toString(),signup_email.getText().toString(),imageUri.toString()));
//                //gson을 이용해 Json형식으로 변환하여 어뎁터데이터를 저장
//                idlist = gson.toJson(list);
//                Log.v("회원가입 엑티비티",idlist);
//                //에디터에 json형식으로 변환된 객체값 집어넣기
//                edit.putString("ID_list",idlist);
//                edit.commit();
//            }else if (idlist != ""){
//                ArrayList<signup> jsonidlist = gson.fromJson(idlist,new TypeToken<ArrayList<signup>>(){}.getType());
//
//            }
            //이미지 업로드 버튼 클릭
        }else if(v.getId() == R.id.image_upload_button) {
            Log.v("회원가입 엑티비티","이미지 업로드 버튼 클릭");
            //이미지 요청 암시적 인텐트 생성
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            //이미지파일로 한정
            intent.setType("image/*");
            //리퀘스트값이 있게 forresult사용 코드값은 임의로 1000때려밖았음
            startActivityForResult(intent,1000);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ImageView my_image = (ImageView) findViewById(R.id.my_imageView);
        //리퀘스트 코드가 1000이며, 리절트 코드가 OK이고 데이터가 null값이 아닐떄
        if(requestCode==1000 && resultCode == RESULT_OK && data != null){
            //사진 경로
            imageUri = data.getData();
                //사진을 비트맵으로 얻기
               // Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);
                //이비지뷰에 비트맵 설정
               // my_image.setImageBitmap(bitmap);
            //라이브러리
                Glide.with(this).load(imageUri.toString()).into(my_image);





        }
        // 그림이 정상적으로 선택되면

    }

    @Override
    protected void onResume() {
        Log.v("회원가입 엑티비티","Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("회원가입 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("회원가입 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("회원가입 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("회원가입 엑티비티","Pause");
        super.onPause();
    }
}
