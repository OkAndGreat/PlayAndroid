package com.example.playandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.example.playandroid.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //隐藏顶部标题栏
//        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(0,1000);
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg){
            //实现页面的跳转
            Intent intent=new Intent(WelcomeActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
            super.handleMessage(msg);
        }
    };

}