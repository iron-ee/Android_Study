package com.cos.myapplication2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity2";
    private GridView gvMovie;
    List<Movie> movies;
    ItemAdapter adapter;

    // 1번 실행
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 전체 인플레이트

        init();

        adapter = new ItemAdapter(movies);
        gvMovie.setAdapter(adapter);
        }

    // 2번 실행
    @Override
    protected void onStart() {
        super.onStart();
    }

    // 3번 실행
    @Override
    protected void onResume() {
        super.onResume();
    }   // => 액티비티에 그림 그려짐.

    private void init() {
        gvMovie = findViewById(R.id.gv_movie);
        movies = new ArrayList<>();
        download();
    }

    private void download() {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                movies.add(new Movie(1, "제목", R.drawable.mov01));
                movies.add(new Movie(2, "제목", R.drawable.mov02));
                movies.add(new Movie(3, "제목", R.drawable.mov03));
                movies.add(new Movie(4, "제목", R.drawable.mov04));
                movies.add(new Movie(5, "제목", R.drawable.mov05));
                movies.add(new Movie(6, "제목", R.drawable.mov06));
                movies.add(new Movie(7, "제목", R.drawable.mov07));
                movies.add(new Movie(8, "제목", R.drawable.mov08));
                movies.add(new Movie(9, "제목", R.drawable.mov09));
                movies.add(new Movie(10, "제목", R.drawable.mov10));
                movies.add(new Movie(11, "제목", R.drawable.mov11));
                movies.add(new Movie(12, "제목", R.drawable.mov12));

                // main스레드=UI스레드가 adapter.notifyDataSetChanged(); 를 실행시키게 하면 됨.
                runOnUiThread(new Runnable() {  // 매우 중요한 개념 ! 메인스레드가 아닌 스레드에 UI 리프레쉬를 때리면 오류가 나지만
                    @Override                   // runOnUiThread 를 통해서 리프레쉬를 할 수 있도록 함수를 제공해주고 있다 !
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
            }
        }).start();
    }
}



