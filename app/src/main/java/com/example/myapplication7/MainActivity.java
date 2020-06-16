package com.example.myapplication7;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kakao.auth.AuthType;
import com.kakao.auth.ErrorCode;
import com.kakao.auth.ISessionCallback;
import com.kakao.auth.KakaoSDK;
import com.kakao.auth.Session;
import com.kakao.network.ErrorResult;
import com.kakao.usermgmt.UserManagement;
import com.kakao.usermgmt.callback.MeResponseCallback;
import com.kakao.usermgmt.callback.MeV2ResponseCallback;
import com.kakao.usermgmt.response.MeV2Response;
import com.kakao.usermgmt.response.model.Profile;
import com.kakao.usermgmt.response.model.UserAccount;
import com.kakao.usermgmt.response.model.UserProfile;
import com.kakao.util.OptionalBoolean;
import com.kakao.util.exception.KakaoException;
import com.kakao.util.helper.log.Logger;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//AppcompatActivity(화면에 필요한 기능들이 들어있음)를 상속하는 메인엑티비티
public class MainActivity extends AppCompatActivity {
    public String PREFERENCE = "com.studio572.samplesharepreference";
    SharedPreferences pref;
    EditText nametext, passwordtext;
    ArrayList<signup> list;
    String token = "";
    String name = "";
    final static String TAG = "LoginActivityT";
    private SessionCallback sessionCallback = new SessionCallback();
    Session session;
    String userId;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.v("메인 엑티비티", "create");
        //부모클래스의 동일메서드 호출
        super.onCreate(savedInstanceState);
        //XML레이아웃과(로그인 레이아웃) 소스코드를 setContenView를 이용해 연결
        setContentView(R.layout.activity_login);
        session = Session.getCurrentSession();
        session.addCallback(sessionCallback);
        nametext = (EditText) findViewById(R.id.id_text1);
        passwordtext = (EditText) findViewById(R.id.login_password1);


        final TextView find_pass = (TextView) findViewById(R.id.login_findpassword1);
        final TextView sign_up = (TextView) findViewById(R.id.sign_up1);
        Button loginbutton = (Button) findViewById(R.id.login_button1);
        pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
        Gson gson = new Gson();
        SharedPreferences.Editor edit = pref.edit();


        list = new ArrayList<signup>();
        if (pref.getString("ID_list", "").equals("")) {
            list.add(new signup("admin", "관리자", "0000", "crazybear1@naver.com", "content://com.android.providers.media.documents/document/image%3A16196"));
            String first = gson.toJson(list);
            Log.v("회원가입 엑티비티", first);
            edit.putString("ID_list", first);
            edit.commit();
        }
        loginbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                pref = getSharedPreferences(PREFERENCE, MODE_PRIVATE);
                SharedPreferences.Editor edit = pref.edit();
                Gson gson = new Gson();

                String list = pref.getString("ID_list", "");
                if (!list.equals("")) {
                    ArrayList<signup> signuplist = gson.fromJson(list, new TypeToken<ArrayList<signup>>() {}.getType());
                    boolean a = false;
                    for (int i = 0; i < signuplist.size(); i++) {
                        Log.v("로그인 엑티비티", nametext.getText().toString() + signuplist.get(i).getId());

                        if (nametext.getText().toString().equals(signuplist.get(i).getId())) {
                            Log.v("로그인 엑티비티", passwordtext.getText().toString() + signuplist.get(i).getPassword());
                            if (passwordtext.getText().toString().equals(signuplist.get(i).getPassword())) {
                                edit.putString("ID", signuplist.get(i).getId());
                                edit.commit();

                                String ID = pref.getString("ID", "");
                                edit.putString(ID + "NICKNAME", signuplist.get(i).getNickname());
                                edit.putString(ID + "EMAIL", signuplist.get(i).getEmail());
                                edit.putString(ID + "URI", signuplist.get(i).getImage_uri());
                                edit.putString(ID + "PASSWORD", signuplist.get(i).getPassword());
                                Log.v("로그인 엑티비티 로그인시점", signuplist.get(i).getNickname() + signuplist.get(i).getEmail() + signuplist.get(i).getPassword());

                                edit.commit();
                                a = true;

                                Intent intent = new Intent(getApplicationContext(), basic_activity.class);
                                startActivity(intent);
                                finish();
                            }

                        }
                    }
                    if (!a) {
                        Toast.makeText(MainActivity.this, "아이디,패스워드 정보를 확인해주세요.", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "아이디,패스워드 정보를 확인해주세요.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        find_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), find_password.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), signup_activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        Log.v("메인 엑티비티", "Resume");
        super.onResume();

    }

    @Override
    protected void onStart() {
        Log.v("메인 엑티비티", "Start");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v("메인 엑티비티", "Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.v("메인 엑티비티", "Destroy");
        super.onDestroy();
        Session.getCurrentSession().removeCallback(sessionCallback);

    }

    protected void onPause() {
        Log.v("메인 엑티비티", "Pause");
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // 카카오톡|스토리 간편로그인 실행 결과를 받아서 SDK로 전달
        if (Session.getCurrentSession().handleActivityResult(requestCode, resultCode, data)) {
            return;
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    private void redirectHomeActivity() {
        startActivity(new Intent(this, basic_activity.class));
        finish();
    }

    public class SessionCallback implements ISessionCallback {

        // 로그인에 성공한 상태
        @Override
        public void onSessionOpened() {
            requestMe();
        }

        // 로그인에 실패한 상태
        @Override
        public void onSessionOpenFailed(KakaoException exception) {
            Log.e("SessionCallback :: ", "onSessionOpenFailed : " + exception.getMessage());
        }

        // 사용자 정보 요청
        public void requestMe() {
            UserManagement.getInstance()
                    .me(new MeV2ResponseCallback() {
                        @Override
                        public void onSessionClosed(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "세션이 닫혀 있음: " + errorResult);
                        }

                        @Override
                        public void onFailure(ErrorResult errorResult) {
                            Log.e("KAKAO_API", "사용자 정보 요청 실패: " + errorResult);
                        }

                        @Override
                        public void onSuccess(MeV2Response result) {
                            Log.i("KAKAO_API", "사용자 아이디: " + result.getId());
                            UserAccount kakaoAccount = result.getKakaoAccount();
                            SharedPreferences.Editor edit = pref.edit();
                            edit.putString("ID", Long.toString(result.getId()));
                            edit.putString(Long.toString(result.getId())+"NICKNAME", Long.toString(result.getId()));
                            Log.i("KAKAO_API", "사용자 아이디, 닉네임: " + result.getId());

                            edit.commit();
                            Intent intent = new Intent(getApplicationContext(), basic_activity.class);
                            startActivity(intent);
                            finish();



                            if (kakaoAccount != null) {

                                // 이메일
                                String email = kakaoAccount.getEmail();

                                if (email != null) {
                                    Log.i("KAKAO_API", "email: " + email);

                                } else if (kakaoAccount.emailNeedsAgreement() == OptionalBoolean.TRUE) {
                                    // 동의 요청 후 이메일 획득 가능
                                    // 단, 선택 동의로 설정되어 있다면 서비스 이용 시나리오 상에서 반드시 필요한 경우에만 요청해야 합니다.

                                } else {
                                    // 이메일 획득 불가
                                }

                                // 프로필
                                Profile profile = kakaoAccount.getProfile();

                                if (profile != null) {
                                    Log.d("KAKAO_API", "nickname: " + profile.getNickname());
                                    Log.d("KAKAO_API", "profile image: " + profile.getProfileImageUrl());
                                    Log.d("KAKAO_API", "thumbnail image: " + profile.getThumbnailImageUrl());

                                } else if (kakaoAccount.profileNeedsAgreement() == OptionalBoolean.TRUE) {
                                    // 동의 요청 후 프로필 정보 획득 가능

                                } else {
                                    // 프로필 획득 불가
                                }
                            }
                        }
                    });
        }
    }
}
