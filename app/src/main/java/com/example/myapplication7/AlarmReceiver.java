
package com.example.myapplication7;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.PowerManager;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


import static android.content.Context.MODE_PRIVATE;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        //알림(Notification)을 관리하는 관리자 객체를 운영체제(Context)로부터 불러오기
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        //알림 클릭시 할 행동과 이동될 액티비티 지정
        Intent notificationIntent = new Intent(context, diet_calender_activity.class);
        // 실행시 모든 액티비티를 스택에서 제거하고 실행(왜 이래야하는지는 모르겠음? 질문)
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        //NotificationManager가 인텐트를 실행해야 하기 때문에 (즉 다른 프로세스에서 수행하기 때문에)팬딩인텐트로 실행
        PendingIntent pendingI = PendingIntent.getActivity(context, 0,
                notificationIntent, 0);

        //Notification 객체를 생성해주는 건축가객체 생성(AlertDialog 와 비슷)
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");


        //OREO API 26 이상에서는 채널 필요
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            //mipmap 사용시 Oreo 이상에서 시스템 UI 에러남
            builder.setSmallIcon(R.drawable.ic_launcher_foreground);


            String channelName ="매일 알람 채널";
            String description = "매일 정해진 시간에 알람합니다.";
            //소리와 알림메시지를 같이 보여줌
            int importance = NotificationManager.IMPORTANCE_HIGH;
            //알림채널 객체 만들기
            NotificationChannel channel = new NotificationChannel("default", channelName, importance);
            channel.setDescription(description);

            if (notificationManager != null) {
                //알림매니저에게 채널 객체의 생성을 요청
                notificationManager.createNotificationChannel(channel);
            }
        }else builder.setSmallIcon(R.mipmap.ic_launcher); // Oreo 이하에서 mipmap 사용하지 않으면 Couldn't create icon: StatusBarIcon 에러남


        builder.setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())

                .setTicker("{오늘의 식단,체중을 입력해주세요}")
                .setContentTitle("다이어트 파트너")
                .setContentText("오늘의 식단,체중을 입력해주세요")
                .setContentInfo("INFO")
                .setContentIntent(pendingI);

        if (notificationManager != null) {
            //시스템의 서비스인 powerManager 호출
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            // CPU, Screen, Keyboard 를 다 켜주는 FULL_WAKE_LOCK을 호출
            PowerManager.WakeLock wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK  |
                    PowerManager.ACQUIRE_CAUSES_WAKEUP |//꺼져있는 화면을 호출하기 위해 사용
                    PowerManager.ON_AFTER_RELEASE, "My:Tag");//화면 깜박임을 덜어줌
            //5초후 켜진 화면이 종료됨
            wakeLock.acquire(5000);

            // 노티피케이션 동작시킴
            notificationManager.notify(1234, builder.build());

            Calendar NotifyTime = Calendar.getInstance();

            // 내일 같은 시간으로 알람시간 결정
            NotifyTime.add(Calendar.DATE, 1);

            //  Preference에 설정한 값 저장
            SharedPreferences.Editor editor = context.getSharedPreferences("com.studio572.samplesharepreference", MODE_PRIVATE).edit();
            editor.putLong("NotifyTime", NotifyTime.getTimeInMillis());
            editor.apply();
        }
    }
}
