package com.example.myapplication7;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class weight_graph extends AppCompatActivity implements View.OnClickListener {
    Calendar myCalendar = Calendar.getInstance();
    Calendar myCalendar2 = Calendar.getInstance();
    private LineChart lineChart;

    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, month);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel();
        }
    };
    DatePickerDialog.OnDateSetListener myDatePicker2 = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            myCalendar2.set(Calendar.YEAR, year);
            myCalendar2.set(Calendar.MONTH, month);
            myCalendar2.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            updateLabel2();
        }
    };

    @Override
    protected void onCreate(Bundle bundle){
        Log.v("체중그래프 엑티비티","create");

        super.onCreate(bundle);
        setContentView(R.layout.weight_graph);

        LineChart lineChart = (LineChart)findViewById(R.id.linechart);
        LineData chartdate = new LineData();//LineDataSet 선언
        ArrayList<Entry> weights = new ArrayList<>();
        weights.add(new Entry(4f,0));
        weights.add(new Entry(8f,1));
        weights.add(new Entry(6f,2));
//        weights.add(new Entry(2f,3));
//        weights.add(new Entry(18f,4));
//        weights.add(new Entry(9f,5));

        LineDataSet lineDataSet = new LineDataSet(weights,"꺽은선1");
        chartdate.addDataSet(lineDataSet);
        lineChart.setData(chartdate);
        lineChart.invalidate();

        //그래프에 들어갈 좌표값 입력


        final ImageView start = (ImageView) findViewById(R.id.graph_imageview1);
        start.setOnClickListener(this);
        final ImageView end = (ImageView) findViewById(R.id.graph_imageview2);
        end.setOnClickListener(this);



        final TextView kcal = (TextView) findViewById(R.id.textView5);
        kcal.setOnClickListener(this);
        final TextView basic_food = (TextView) findViewById(R.id.textView8);
        basic_food.setOnClickListener(this);
        final TextView basic_graph = (TextView) findViewById(R.id.textView9);
        basic_graph.setOnClickListener(this);
        final TextView basic_main = (TextView) findViewById(R.id.textView10);
        basic_main.setOnClickListener(this);
        final TextView basic_forum = (TextView) findViewById(R.id.textView16);
        basic_forum.setOnClickListener(this);
        final ImageView basic_food_image = (ImageView) findViewById(R.id.imageView3);
        basic_food_image.setOnClickListener(this);
        final ImageView basic_graph_image = (ImageView) findViewById(R.id.imageView4);
        basic_graph_image.setOnClickListener(this);
        final ImageView basic_main_image = (ImageView) findViewById(R.id.imageView5);
        basic_main_image.setOnClickListener(this);
        final ImageView basic_kcal_image = (ImageView) findViewById(R.id.imageView6);
        basic_kcal_image.setOnClickListener(this);
        final ImageView basic_forum_image = (ImageView) findViewById(R.id.imageView7);
        basic_forum_image.setOnClickListener(this);

    }
    private void setChart(List<weight> records) {
        LineChart lineChart = null;
        lineChart.invalidate(); //차트 초기화 작업
        lineChart.clear();
        DateFormat dateFormat = new SimpleDateFormat ("yyyyMMdd");

        ArrayList<Entry> values = new ArrayList<>();//차트 데이터 셋에 담겨질 데이터
//        for (weight record : records) { //values에 데이터를 담는 과정
//            Date dateTime =  dateFormat.parse(record.getDATE());
//            Double weight = Double.parseDouble(record.getWeight());
//            values.add(new Entry(dateTime, weight));
//        }

        /*몸무게*/
        LineDataSet lineDataSet = new LineDataSet(values, "무게"); //LineDataSet 선언


        LineData lineData = new LineData(); //LineDataSet을 담는 그릇 여러개의 라인 데이터가 들어갈 수 있습니다.
        lineData.addDataSet(lineDataSet);

        lineData.setValueTextSize(9);

        XAxis xAxis = lineChart.getXAxis(); // x 축 설정
        xAxis.setPosition(XAxis.XAxisPosition.TOP); //x 축 표시에 대한 위치 설정
//        xAxis.setValueFormatter(new ChartXValueFormatter()); //X축의 데이터를 제 가공함. new ChartXValueFormatter은 Custom한 소스
        xAxis.setLabelCount(5, true); //X축의 데이터를 최대 몇개 까지 나타낼지에 대한 설정 5개 force가 true 이면 반드시 보여줌

        YAxis yAxisLeft = lineChart.getAxisLeft(); //Y축의 왼쪽면 설정

        YAxis yAxisRight = lineChart.getAxisRight(); //Y축의 오른쪽면 설정
        yAxisRight.setDrawLabels(false);
        yAxisRight.setDrawAxisLine(false);
        yAxisRight.setDrawGridLines(false);
        //y축의 활성화를 제거함

        lineChart.setVisibleXRangeMinimum(60 * 60 * 24 * 1000 * 5); //라인차트에서 최대로 보여질 X축의 데이터 설정
        lineChart.setDescription(null); //차트에서 Description 설정 저는 따로 안했습니다.

        Legend legend = lineChart.getLegend(); //레전드 설정 (차트 밑에 색과 라벨을 나타내는 설정)

        lineChart.setData(lineData);
    }




    @Override
    //인터페이스 활용하여 클릭시 이곳으로 오게 하였음
    public void onClick(View v) {
        if (v.getId() == R.id.textView5) {
            Intent intent = new Intent(weight_graph.this, bmr_activity.class);
            startActivity(intent);
            finish();

            //활동칼로리 계산
        } else if (v.getId() == R.id.textView8) {
            Intent intent = new Intent(weight_graph.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            // 그래프로 이동
        } else if (v.getId() == R.id.textView9) {


        }
        //지금 속해있는 액티비티
        else if (v.getId() == R.id.textView10) {
            Intent intent = new Intent(weight_graph.this, basic_activity.class);
            startActivity(intent);
            finish();


            //게시판 텍스트 클릭
        } else if (v.getId() == R.id.textView16) {
            Intent intent = new Intent(weight_graph.this, forum_activity.class);
            startActivity(intent);
            finish();


        } else if (v.getId() == R.id.imageView3) {
            Intent intent = new Intent(weight_graph.this, diet_calender_activity.class);
            startActivity(intent);
            finish();

            //하단 매뉴 그래프 그림 클릭시 이동
        } else if (v.getId() == R.id.imageView4) {


            //하단 매뉴 메인메뉴 클릭시 (현재 액티비티)
        } else if (v.getId() == R.id.imageView5) {
            Intent intent = new Intent(weight_graph.this, basic_activity.class);
            startActivity(intent);
            finish();

        } else if (v.getId() == R.id.imageView6) {
            Intent intent = new Intent(weight_graph.this, bmr_activity.class);
            startActivity(intent);
            finish();
        } else if (v.getId() == R.id.imageView7) {
            Intent intent = new Intent(weight_graph.this, forum_activity.class);
            startActivity(intent);
            finish();
        }else if (v.getId()==R.id.graph_imageview1){
            new DatePickerDialog(weight_graph.this, myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }else if (v.getId() == R.id.graph_imageview2){
            new DatePickerDialog(weight_graph.this, myDatePicker2, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();
        }
    }





    private void updateLabel() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
        TextView start_date = (TextView) findViewById(R.id.graph_textView1);
        start_date.setText(sdf.format(myCalendar.getTime()));

    }
    private void updateLabel2() {
        String myFormat = "yyyy/MM/dd";    // 출력형식   2018/11/28
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.KOREA);
        TextView end_date = (TextView) findViewById(R.id.graph_textView2);
        end_date.setText(sdf.format(myCalendar2.getTime()));
    }










    protected void onResume() {
        Log.v("체중그래프 엑티비티","Resume");
        super.onResume();

    }
    @Override
    protected void onStart() {
        Log.v("체중그래프 엑티비티","Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("체중그래프 엑티비티","Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("체중그래프 엑티비티","Destroy");
        super.onDestroy();
    }
    protected void onPause() {
        Log.v("체중그래프 엑티비티","Pause");
        super.onPause();
    }
    public void onBackPressed() {
        Intent intent = new Intent(weight_graph.this, basic_activity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
