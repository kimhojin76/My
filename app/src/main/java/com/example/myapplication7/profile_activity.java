package com.example.myapplication7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class profile_activity extends AppCompatActivity
        implements View.OnClickListener{
//    static final int REQUEST_IMAGE_GET = 1;
    private ImageView my_imageView;
    private EditText add_car_input,add_pro_input,add_fat_input,editText6;
    private Button image_upload_button,button3;
    private Uri imageUri;
    private String Get_imageUri;
    private String PREFERENCE = "com.studio572.samplesharepreference";
    private ArrayList<signup> list;
    private String ID;
    boolean a = true;
//f

    @Override
    protected void onCreate(Bundle bundle){
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        SharedPreferences.Editor edit = pref.edit();

        ID = pref.getString("ID","");

        Log.v("회원가입 엑티비티","create"+ID);

        super.onCreate(bundle);
        setContentView(R.layout.activity_profile);

        my_imageView = (ImageView)findViewById(R.id.my_imageView);
        add_car_input = (EditText)findViewById(R.id.add_car_input);
        add_pro_input = (EditText)findViewById(R.id.add_pro_input);
        add_fat_input = (EditText)findViewById(R.id.add_fat_input);
        editText6 = (EditText)findViewById(R.id.editText6);
        image_upload_button = (Button)findViewById(R.id.image_upload_button);
        image_upload_button.setOnClickListener(this);
        button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);
        String a = pref.getString(ID + "NICKNAME","");
        String b = pref.getString(ID + "EMAIL","");
        Get_imageUri = pref.getString(ID + "URI","");
        Log.v("회원정보변경 엑티비티","create"+a+b+Get_imageUri);
        add_car_input.setText(a);
        editText6.setText(b);
        Glide.with(this).load(Get_imageUri).into(my_imageView);



    }

    @Override
    public void onClick(View v) {
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);

        if(v.getId() == R.id.image_upload_button){
            Log.v("회원정보변경 엑티비티","이미지 업로드 버튼 클릭");
            //이미지 요청 암시적 인텐트 생성
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            //이미지파일로 한정
            intent.setType("image/*");
            //리퀘스트값이 있게 forresult사용 코드값은 임의로 1000때려밖았음
            startActivityForResult(intent,1000);
        }else if(v.getId() == R.id.button3){
            SharedPreferences.Editor edit = pref.edit();
            Gson gson = new Gson();
            String list2 = pref.getString("ID_list","");
            list = gson.fromJson(list2, new TypeToken<ArrayList<signup>>() {
            }.getType());

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equals(ID)) {
                    Log.v("회원정보변경 엑티비티",list.get(i).getPassword());
                    if(list.get(i).getPassword().equals(add_pro_input.getText().toString())) {
                        list.get(i).setNickname(add_car_input.getText().toString());
                        if (a = true) {
                            list.get(i).setImage_uri(Get_imageUri.toString());
                        } else {
                            list.get(i).setImage_uri(imageUri.toString());
                        }
                        list.get(i).setEmail(editText6.getText().toString());
                        list.get(i).setPassword(add_fat_input.getText().toString());
                        Log.v("프로필변경 엑티비티 변경", list.toString());
                        String list3 = gson.toJson(list);
                        edit.putString("ID_list", list3);
                        edit.putString(ID + "NICKNAME", add_car_input.getText().toString());
                        edit.putString(ID + "EMAIL", editText6.getText().toString());
                        if (a = true) {
                            edit.putString(ID + "URI", Get_imageUri);
                        } else {
                            edit.putString(ID + "URI", imageUri.toString());
                        }
                        edit.putString(ID + "PASSWORD", add_fat_input.getText().toString());


                        edit.commit();
                        Toast.makeText(profile_activity.this, "변경되었습니다.", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(profile_activity.this, "비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();

                }
            }
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
            a=false;
        }else if (requestCode==1010 && resultCode == RESULT_OK && data != null){
            Glide.with(this).load(Get_imageUri).into(my_image);
        }
        // 그림이 정상적으로 선택되면

    }


    @Override
    protected void onResume() {
        Log.v("회원정보변경 엑티비티", "Resume");
        Log.v("회원정보변경 엑티비티", ""+ID);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);

        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v("회원정보변경 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("회원정보변경 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("회원정보변경 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("회원정보변경 엑티비티","Pause");
        super.onPause();
    }
}
