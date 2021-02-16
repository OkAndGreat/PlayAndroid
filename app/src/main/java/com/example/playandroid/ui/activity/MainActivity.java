package com.example.playandroid.ui.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.utils.DatabaseHelper;
import com.example.playandroid.utils.LogUtil;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.example.playandroid.adapter.*;
/**
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG

 */


/**
 * @author OkAndGreat
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    String[] datas = {"首页", "问答", "分享", "休息"};
    int[] imageSrcNormal = {R.drawable.home_normal, R.drawable.question_normal, R.drawable.system_normal, R.drawable.rest_normal};
    int[] imageSrcSelected = {R.drawable.home_selected, R.drawable.question_selected, R.drawable.system_selected, R.drawable.rest_selected};
    private TabLayout mMainContentTabLayout;
    private NavigationView mNavView;
    private DrawerLayout mDrawerLayout;
    private ImageView mIvHome;
    private TextView mTvBar;
    private TextView mTvUserName;
    private View mIconImage;
    private static boolean mLogin = false;
    private ImageView mIvSearch;
    private TextView mTvId;
    private View mTvNavLogin;
    private View mLlNavLogined;
    private View mNavGroup;
    private View mTvNavExit;
    private static int mId;
    private static SQLiteDatabase mDb;
    private View mHeaderLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ininView();
        initListener();
        initDb();
    }

    private void initDb() {
        DatabaseHelper databaseHelper = new DatabaseHelper(this, "History.db", null, 1);
        mDb = databaseHelper.getWritableDatabase();
    }

    private void ininView() {
        //ViewPager+Fragment+TabLayoou组合
        mMainContentTabLayout = (TabLayout) findViewById(R.id.Main_Content_TabLayout);
        ViewPager mainContentPager = (ViewPager) findViewById(R.id.Main_Content_Pager);
        mainContentPager.setOffscreenPageLimit(3);
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
        mHeaderLayout = mNavView.getHeaderView(0);
        mIconImage = mHeaderLayout.findViewById(R.id.icon_image);
        mTvUserName = mHeaderLayout.findViewById(R.id.tv_username);
        mTvNavLogin = mHeaderLayout.findViewById(R.id.tv_nav_login);
        mLlNavLogined = mHeaderLayout.findViewById(R.id.ll_nav_logined);
        mTvNavExit = mHeaderLayout.findViewById(R.id.tv_nav_exit);
        mTvId = (TextView) mHeaderLayout.findViewById(R.id.tv_id);
        mIvSearch = (ImageView) findViewById(R.id.iv_home_search);

    }


    private void initListener() {

        //TabLayout的监听
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

        //NavigationView的监听
        mNavView.setNavigationItemSelectedListener(new OnNavigationItemSelectedListener() {
            private Intent intent;

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_github:
                        intent = new Intent(MainActivity.this, OpenProjectActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_history:
                        intent = new Intent(MainActivity.this, HistoryActivity.class);
                        startActivity(this.intent);
                        break;
                    case R.id.nav_info:
                        intent = new Intent(MainActivity.this, AboutAuthorActivity.class);
                        startActivity(this.intent);
                        break;
                    case R.id.nav_point:
                        intent = new Intent(MainActivity.this, PointActivity.class);
                        startActivity(this.intent);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + item.getItemId());
                }
                return true;
            }
        });
        mIvSearch.setOnClickListener(this);
        //点击IvHome打开Drawer的监听
        mIvHome.setOnClickListener(this);
        //进入Drawer界面的监听
        mIconImage.setOnClickListener(this);
        mTvNavLogin.setOnClickListener(this);
        mTvUserName.setOnClickListener(this);
        mTvId.setOnClickListener(this);
        mTvNavExit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.iv_home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.icon_image:
            case R.id.tv_nav_login:
                if (mLogin == false) {
                    intent = new Intent(this, LoginActivity.class);
                    startActivityForResult(intent, 1);
                }
                break;
            case R.id.iv_home_search:
                intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_nav_exit:
                mTvNavExit.setVisibility(View.INVISIBLE);
                mTvNavLogin.setVisibility(View.VISIBLE);
                mLlNavLogined.setVisibility(View.INVISIBLE);
                mLogin=false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }

    //用来判断当前是否登录以便显示不同的界面

    /**
     * 判断是否登录以显示不同界面
     *
     * @return
     */
    public static boolean isLogin() {
        return mLogin;
    }

    public static void setLogin(boolean login) {
        mLogin = login;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    mId = data.getIntExtra("id", 10000);
                    String username = data.getStringExtra("username");
                    mTvNavExit.setVisibility(View.VISIBLE);
                    mTvNavLogin.setVisibility(View.INVISIBLE);
                    mLlNavLogined.setVisibility(View.VISIBLE);
                    mTvUserName.setText("用户名:" + "  " + username);
                    mTvId.setText("Id:" + "  " + mId);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + requestCode);
        }
    }

    public static SQLiteDatabase getDb() {
        return mDb;
    }

    public static int getId() {
        return mId;
    }
}

