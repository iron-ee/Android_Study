package com.cos.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private ImageView ivImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImg = findViewById(R.id.iv_img);

        // https://github.com/bumptech/glide  => 참고하기
        Glide
                .with(MainActivity.this)
                .load("http://picsum.photos/200/300")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(ivImg);
    }
}