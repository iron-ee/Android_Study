package com.cos.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = "SubActivity";
    private FloatingActionButton fabPop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
//        Bundle bundle = intent.getBundleExtra("userBundle");

        Log.d(TAG, "username: "+username);
        Log.d(TAG, "user: "+intent.getSerializableExtra("user"));
//        Log.d(TAG, "userBundle: "+bundle.getSerializable("user"));

        fabPop = findViewById(R.id.fab_pop);
        fabPop.setOnClickListener(v -> {
            // 인증이 성공함
            Intent newIntent = new Intent();
            newIntent.putExtra("auth", "ok");
            setResult(1,newIntent);
            finish();   // pop
        });
    }
}