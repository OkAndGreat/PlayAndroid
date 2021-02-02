package com.example.playandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.playandroid.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}