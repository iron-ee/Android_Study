package com.cos.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// 메인쓰레드 => onCreate() => UI 쓰레드 (무한루프[ ] )
//                          => 이벤트 쓰레드 [배열] 확인
//                          => 이벤트 리스너(OS) [ ]
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    
    private TextView tvTitle;

    // 매니페스트에서 설정된 자바 파일이 실행될 때 가장 먼저 실행되는 함수 onCreate()
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // 그림 그리는 함수 (무엇을? activity_main) => java
        Log.d(TAG, "onCreate: ");
    }

    // 화면 그려지기 직전! -> 데이터 다운로드
    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        String title = sp.getString("title", "없음");
        Log.d(TAG, "onResume: "+title);
    }

    // 앱이 멈출 때!
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    // 앱이 종료될 때!
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");

        // 1. 파일 ( 그림 사진 = 카메라로 찍은 사진)
        // 2. 내부 DB = (SQL Lite) 주소록, 메모장, 달력
        // 3. 외부 서버 = 외부 DB (인스타그램 업로드 할 사진)
        // 4. 하드 엑세스 저장소 ( 제일 많이 씀) = 앱마다 달려있음. = 실제로는 한개 (키로 구분) = Shared Preference

        SharedPreferences sp = getSharedPreferences("movie", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("title", "바람과 함께 사라지다.");
        editor.commit();
    }



}