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
    private Context mContext = MainActivity.this;
    private ListView lvMovie;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // 전체 인플레이트

        lvMovie = findViewById(R.id.lv_moive);
        Log.d(TAG, "컨텍스트 : "+MainActivity.this);
        Log.d(TAG, "컨텍스트 : "+lvMovie.getContext());

        List<Movie> movies = new ArrayList<>();

        for (int i=0; i < 20; i++) {
            movies.add(new Movie(i, "제목"+i, "서브제목"+i));
        }

        ItemAdapter adapter = new ItemAdapter(movies);

        lvMovie.setAdapter(adapter);
    }
}



