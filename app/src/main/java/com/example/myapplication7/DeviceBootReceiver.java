package com.example.myapplication7;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class DeviceBootReceiver extends BroadcastReceiver {
    @Override
    //알람매니저가 실행한것이 이곳에 도착, 도착하면 온 리시버가 자동으로 실행
    public void onReceive(Context context, Intent intent) {
        //객체를 비교(Objects.equals) intetnt의 행동이 "android.intent.action.BOOT_COMPLETED"와 같은지를 확인 맞으면
        if (Objects.equals(intent.getAction(), "android.intent.action.BOOT_COMPLETED")) {

            // 디바이스가 켜지고 알람이 리셋됨(재부팅으로 인한 알람 취소), 알람리시버 클래스로 이동하는 인텐트 생성
            Intent alarmIntent = new Intent(context, AlarmReceiver.class);
            //AlarmManager를 통해 다른 프로세스에서 시행하기 때문에 PendingIntent
            //를 사용해야 본인 앱의 프로세스에서 사용하는 것처럼 사용할 수 있음., BroadcastReceiver 를 시작하는 것이기 때문에 .getBroadcast를 해주었음.
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, 0);
            //알람매니저 객체 생성, 알람매니저가 시스템 서비스이므로 getSystemService매소드를 사용하여 얻어옴
            AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
//
            //쉐어드 선언
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.studio572.samplesharepreference", MODE_PRIVATE);
//            NotifyTime
//            SharedPreferences sharedPreferences = context.getSharedPreferences("daily alarm", MODE_PRIVATE);
            long millis = sharedPreferences.getLong("NotifyTime", Calendar.getInstance().getTimeInMillis());

//            long millis = sharedPreferences.getLong("nextNotifyTime", Calendar.getInstance().getTimeInMillis());


            Calendar current_calendar = Calendar.getInstance();
            Calendar nextNotifyTime = new GregorianCalendar();
//            nextNotifyTime.setTimeInMillis(sharedPreferences.getLong("nextNotifyTime", millis));
            nextNotifyTime.setTimeInMillis(sharedPreferences.getLong("NotifyTime", millis));

            if (current_calendar.after(nextNotifyTime)) {
                nextNotifyTime.add(Calendar.DATE, 1);
            }

            Date currentDateTime = nextNotifyTime.getTime();
            String date_text = new SimpleDateFormat("yyyy년 MM월 dd일 EE요일 a hh시 mm분 ", Locale.getDefault()).format(currentDateTime);
            Toast.makeText(context.getApplicationContext(),"[재부팅후] 다음 알람은 " + date_text + "으로 알람이 설정되었습니다!", Toast.LENGTH_SHORT).show();


            if (manager != null) {
                manager.setRepeating(AlarmManager.RTC_WAKEUP, nextNotifyTime.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
            }
        }
    }
}
