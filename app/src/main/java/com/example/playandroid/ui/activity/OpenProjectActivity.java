package com.example.playandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;

public class OpenProjectActivity extends BaseActivity implements View.OnClickListener {

    private View mGlide;
    private View mGson;
    private View mRetrofit;
    private View mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_project);
        initView();
        initListener();
    }

    private void initListener() {
        mGlide.setOnClickListener(this);
        mGlide.setOnClickListener(this);
        mRetrofit.setOnClickListener(this);
        mBack.setOnClickListener(this);
    }

    private void initView() {
        mGlide = findViewById(R.id.ll_glide);
        mGson = findViewById(R.id.ll_gson);
        mRetrofit = findViewById(R.id.ll_retrofit);
        mBack = findViewById(R.id.iv_OpenProject_back);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, WebActivity.class);
        switch (v.getId()) {
            case R.id.ll_glide:
                intent.putExtra("url", "https://github.com/bumptech/glide");
                startActivity(intent);
                break;
            case R.id.ll_gson:
                intent.putExtra("url", "https://github.com/google/gson");
                startActivity(intent);
                break;
            case R.id.ll_retrofit:
                intent.putExtra("url", "https://github.com/square/retrofit");
                startActivity(intent);
                break;
            case R.id.iv_OpenProject_back:
                finish();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}