package com.example.myapplication7;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class splash extends Activity {
    ImageView limage1,limage2,limage3,limage4;
    int count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        limage1 = (ImageView) findViewById(R.id.loading_image1);
        limage2 = (ImageView) findViewById(R.id.loading_image2);
        limage3 = (ImageView) findViewById(R.id.loading_image3);
        limage4 = (ImageView) findViewById(R.id.loading_image4);

        new Loader().execute();


    } // onCreate

    //// AsyncTask

    class Loader extends AsyncTask<Void, Integer, Integer> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            limage1.setVisibility(View.INVISIBLE);
            limage2.setVisibility(View.INVISIBLE);
            limage3.setVisibility(View.INVISIBLE);
            limage4.setVisibility(View.INVISIBLE);

        }

        @Override
        protected Integer doInBackground(Void... voids) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {e.printStackTrace();}

            for(count=0;count<4;count++) {

                publishProgress(count);

                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            finish();
            return null;
        }



        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            switch (count) {
                case 0:
                    limage1.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    limage2.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    limage3.setVisibility(View.VISIBLE);

                    break;
                case 3:
                    limage4.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(splash.this, basic_activity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }
}


