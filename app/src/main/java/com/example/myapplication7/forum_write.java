package com.example.myapplication7;

import android.content.Intent;
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

import java.text.SimpleDateFormat;
import java.util.Date;

public class forum_write extends AppCompatActivity implements View.OnClickListener {
    EditText title, contents;
    TextView date, nickcame;
//    ImageView reple_input_image;
//    Uri imageUri;

    @Override
    protected void onCreate(Bundle bundle) {
        Log.v("포럼 글쓰기", "create");
        super.onCreate(bundle);
        setContentView(R.layout.forum_write);


//        reple_input_image = (ImageView) findViewById(R.id.reple_input_image);
//        reple_input_image.setOnClickListener(this);
        title = (EditText) findViewById(R.id.forum_write_title);
        contents = (EditText) findViewById(R.id.forum_write_contents);
//        imageView = (ImageView) findViewById(R.id.write_image);
//        Button upload = (Button) findViewById(R.id.write_image_upload);
//        upload.setOnClickListener(this);
        Button register = (Button) findViewById(R.id.write_register);
        register.setOnClickListener(this);
        nickcame = (TextView) findViewById(R.id.forum_write_nickname);
        nickcame.setText("관리자");
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
            Log.v("포럼 글쓰기 엑티비티", "클릭");
            long now = System.currentTimeMillis();
            Date mDate = new Date(now);
            SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String getTime = simpleDate.format(mDate);

            Intent data = new Intent(forum_write.this, forum_activity.class);
            data.putExtra("제목", title.getText().toString());
            data.putExtra("닉네임", nickcame.getText().toString());
            data.putExtra("날짜", getTime.toString());
            data.putExtra("내용", contents.getText().toString());
//            data.putExtra("이미지",imageUri.toString());
            setResult(200, data);
            finish();

        } else if (v.getId() == R.id.reple_input_image) {

        }
    }
}