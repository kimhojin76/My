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
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class forum_edit extends AppCompatActivity implements View.OnClickListener {
    EditText title2, contents2;
    TextView date2, nickname2;
    String title,date,contents,nickname,ID,NICKNAME,position;
    public String PREFERENCE = "com.studio572.samplesharepreference";

//    ImageView reple_input_image;
//    Uri imageUri;

    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("포럼 글쓰기", "create");
        super.onCreate(bundle);
        setContentView(R.layout.forum_write);

        title2 = (EditText) findViewById(R.id.forum_write_title);
        contents2 = (EditText) findViewById(R.id.forum_write_contents);
//        imageView = (ImageView) findViewById(R.id.write_image);
//        Button upload = (Button) findViewById(R.id.write_image_upload);
//        upload.setOnClickListener(this);
        Button register = (Button) findViewById(R.id.write_register);
        register.setText("수정하기");
        register.setOnClickListener(this);
        nickname2 = (TextView) findViewById(R.id.forum_write_nickname);
        SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        Intent intent = getIntent();

        ID = pref.getString("ID","");
        NICKNAME = pref.getString(ID+"NICKNAME","");
        title = intent.getExtras().getString("제목");
        nickname=intent.getExtras().getString("닉네임");
        date=intent.getExtras().getString("날짜");
        contents=intent.getExtras().getString("내용");
        position = intent.getExtras().getString("포지션");

        title2.setText(title);
        nickname2.setText(nickname);
        contents2.setText(contents);
    }


    @Override
    protected void onResume() {
        Log.v("포럼 글쓰기 엑티비티", "Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("포럼 글쓰기 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("포럼 글쓰기 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("포럼 글쓰기 엑티비티", "Destroy");
        super.onDestroy();
    }

    protected void onPause() {
        Log.v("포럼 글쓰기 엑티비티", "Pause");
        super.onPause();
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        imageView = (ImageView) findViewById(R.id.write_image);
//        //리퀘스트 코드가 1000이며, 리절트 코드가 OK이고 데이터가 null값이 아닐떄
//        if (requestCode == 1000 && resultCode == RESULT_OK && data != null) {
//            //사진 경로
//            Uri Uri = data.getData();
//            //사진을 비트맵으로 얻기
//            // Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(),imageUri);
//            //이비지뷰에 비트맵 설정
//            // my_image.setImageBitmap(bitmap);
//            //라이브러리
//            Glide.with(this).load(Uri.toString()).into(imageView);
////            imageUri=Uri;

    }

    @Override
    public void onClick(View v) {
//        if (v.getId() == R.id.write_image_upload) {
//            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//            //이미지파일로 한정
//            intent.setType("image/*");
//            //리퀘스트값이 있게 forresult사용 코드값은 임의로 1000때려밖았음
//            startActivityForResult(intent,1000);
        if (v.getId() == R.id.write_register) {
            Log.v("포럼 글 수정 엑티비티", "클릭");
            Intent data = new Intent(forum_edit.this, forum_detail.class);
            data.putExtra("포지션",position);
            data.putExtra("제목", title2.getText().toString());
            data.putExtra("닉네임", nickname2.getText().toString());
            data.putExtra("날짜", date.toString());
            data.putExtra("내용", contents2.getText().toString());
            SharedPreferences pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
            Gson gson = new Gson();

            String get_gson_member_adapter = pref.getString("gson_member_adapter","");
            ArrayList<member> list = gson.fromJson(get_gson_member_adapter, new TypeToken<ArrayList<member>>() {
            }.getType());
            memberAdapter adapter = new memberAdapter();
            adapter.items = list;
            member item = adapter.getitem(Integer.parseInt(position));
            item.setContents(contents2.getText().toString());
            item.setTitle(title2.getText().toString());


            //gson을 이용해 Json형식으로 변환하여 어뎁터데이터를 저장
            String gson_member_adapter = gson.toJson(adapter.items);
            //쉐어드프리퍼런스 pref에 쉐어드 주소,타입 지정해서 매칭
            //에디터 선언
            Log.v("포럼 글 수정 엑티비티", gson_member_adapter);

            SharedPreferences.Editor editor = pref.edit();
            //에디터에 json형식으로 변환된 객체값 집어넣기
            editor.putString("gson_member_adapter",gson_member_adapter);
            //에디터에 저장
            editor.commit();
//            data.putExtra("이미지",imageUri.toString());
            setResult(1077, data);
            startActivity(data);
            finish();

        }
    }
}