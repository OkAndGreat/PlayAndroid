package com.example.playandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.base.BaseApplication;
import com.example.playandroid.utils.SizeUtils;
import com.google.android.material.tabs.TabLayout;
import com.example.playandroid.adapter.*;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    String[] datas = {"首页", "问答", "体系"};
    int[] imageSrc_normal = {R.drawable.home_normal, R.drawable.question_normal, R.drawable.system_normal};
    int[] imageSrc_selected = {R.drawable.home_selected, R.drawable.question_selected, R.drawable.system_selected};
    private TabLayout mMainContentTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininView();
        initListener();
    }

    private void ininView() {
        //ViewPager+Fragment+TabLayoou组合
        mMainContentTabLayout = (TabLayout) findViewById(R.id.Main_Content_TabLayout);
        ViewPager MainContentPager = (ViewPager) findViewById(R.id.Main_Content_Pager);
        MainContentPagerAdapter mainContentPagerAdapter = new MainContentPagerAdapter(getSupportFragmentManager(), MainContentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        MainContentPager.setAdapter(mainContentPagerAdapter);
        mMainContentTabLayout.setupWithViewPager(MainContentPager);
        //自定义Tab
        for (int i = 0; i < mMainContentTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mMainContentTabLayout.getTabAt(i);
            if (tab != null) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main_content_tab, null);
                TextView tv = view.findViewById(R.id.tab_item_text);
                ImageView image = view.findViewById(R.id.tab_item_image);
                tab.setTag(i);
                //对tab进行微调
//                if(i==0){
//                    LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
//                    lp.setMargins(80, 0, 0, 0);
//                }
//                if(i==1){
//                    ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
//                    layoutParams.height= SizeUtils.dip2px(getApplicationContext(),25);
//                    layoutParams.width= SizeUtils.dip2px(getApplicationContext(),25);
//
//                    image.setLayoutParams(layoutParams);
//                }
//                if(i==2){
//                    ViewGroup.LayoutParams layoutParams = image.getLayoutParams();
//                    layoutParams.height= SizeUtils.dip2px(getApplicationContext(),25);
//                    layoutParams.width= SizeUtils.dip2px(getApplicationContext(),25);
//                    image.setLayoutParams(layoutParams);
//                }
                image.setImageDrawable(getResources().getDrawable(imageSrc_normal[i]));
                tv.setText(datas[i]);
                tab.setCustomView(view);
            }
        }

    }

    private void initListener() {
        mMainContentTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView icon = tab.getCustomView().findViewById(R.id.tab_item_image);
                icon.setImageResource(imageSrc_selected[tab.getPosition()]);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView icon = tab.getCustomView().findViewById(R.id.tab_item_image);
                icon.setImageResource(imageSrc_normal[tab.getPosition()]);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


}

