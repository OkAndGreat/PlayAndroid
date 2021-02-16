package com.example.playandroid.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.playandroid.R;
import com.example.playandroid.utils.ImageBlur.UtilBitmap;

/**
 * @author OkAndGreat
 */
public class AboutAuthorActivity extends AppCompatActivity {
    private LinearLayout mLlAboutGithub;
    private LinearLayout mLlAboutCsdn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //让状态栏透明
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_author);
        ImageView ivBgAbout = findViewById(R.id.iv_bg1_about);
        //背景图片高斯模糊
        UtilBitmap.blurImageView(this, ivBgAbout, 25);
        //设置Github与CSDN点击事件
        Intent intent = new Intent(this,WebActivity.class);
        mLlAboutGithub = (LinearLayout) findViewById(R.id.ll_about_github);
        mLlAboutCsdn = (LinearLayout) findViewById(R.id.ll_about_csdn);
        mLlAboutGithub.setOnClickListener(v -> {
            intent.putExtra("url","https://github.com/OkAndGreat");
            startActivity(intent);
        });
        mLlAboutCsdn.setOnClickListener(v -> {
            intent.putExtra("url","https://blog.csdn.net/m0_50262214");
            startActivity(intent);
        });
    }
}
