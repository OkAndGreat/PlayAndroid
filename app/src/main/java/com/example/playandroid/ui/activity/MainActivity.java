package com.example.playandroid.ui.activity;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.example.playandroid.adapter.*;


/**
 * @author OkAndGreat
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    String[] datas = {"首页", "问答", "体系", "休息"};
    int[] imageSrcNormal = {R.drawable.home_normal, R.drawable.question_normal, R.drawable.system_normal, R.drawable.rest_normal};
    int[] imageSrcSelected = {R.drawable.home_selected, R.drawable.question_selected, R.drawable.system_selected, R.drawable.rest_selected};
    private TabLayout mMainContentTabLayout;
    private NavigationView mNavView;
    private DrawerLayout mDrawerLayout;
    private ImageView mIvHome;
    private TextView mTvBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininView();
        initListener();

    }

    private void ininView() {
        //ViewPager+Fragment+TabLayoou组合
        mMainContentTabLayout = (TabLayout) findViewById(R.id.Main_Content_TabLayout);
        ViewPager mainContentPager = (ViewPager) findViewById(R.id.Main_Content_Pager);
        //暂时解决了奔溃问题,但这样做可能让程序效率变慢
        //TODO:如何有效解决崩溃问题?
        mainContentPager.setOffscreenPageLimit(4);
        MainContentPagerAdapter mainContentPagerAdapter = new MainContentPagerAdapter(getSupportFragmentManager(), MainContentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mainContentPager.setAdapter(mainContentPagerAdapter);
        mMainContentTabLayout.setupWithViewPager(mainContentPager);
        //自定义Tab
        for (int i = 0; i < mMainContentTabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = mMainContentTabLayout.getTabAt(i);
            if (tab != null) {
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_main_content_tab, null);
                TextView tv = view.findViewById(R.id.tab_item_text);
                ImageView image = view.findViewById(R.id.tab_item_image);
                tv.setText(datas[i]);
                image.setImageDrawable(getResources().getDrawable(imageSrcNormal[i]));
                if (i == 0) {
                    tv.setTextColor(getResources().getColor(R.color.tabtext_bg_color_selected));
                    image.setImageResource(imageSrcSelected[i]);
                }
                tab.setCustomView(view);
            }
        }
        mNavView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mIvHome = (ImageView) findViewById(R.id.iv_home);
        mTvBar = (TextView) findViewById(R.id.tv_Bar);
    }


    private void initListener() {

        mMainContentTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                ImageView icon = tab.getCustomView().findViewById(R.id.tab_item_image);
                TextView tabText = tab.getCustomView().findViewById(R.id.tab_item_text);
                tabText.setTextColor(getResources().getColor(R.color.tabtext_bg_color_selected));
                icon.setImageResource(imageSrcSelected[tab.getPosition()]);
                mTvBar.setText(tabText.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                ImageView icon = tab.getCustomView().findViewById(R.id.tab_item_image);
                TextView tabText = tab.getCustomView().findViewById(R.id.tab_item_text);
                icon.setImageResource(imageSrcNormal[tab.getPosition()]);
                tabText.setTextColor(getResources().getColor(R.color.tabtext_bg_color_normal));
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mNavView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            private Intent intent;
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_collection:
                        break;
                    case R.id.nav_github:
                        intent = new Intent(MainActivity.this, OpenProjectActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_history:
                        break;
                    case R.id.nav_info:
                        this.intent = new Intent(MainActivity.this, AboutAuthorActivity.class);
                        startActivity(this.intent);
                        break;
                    case R.id.nav_point:
                        break;
                    case R.id.nav_setting:
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return true;
            }
        });
        mIvHome.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.iv_home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }
}

