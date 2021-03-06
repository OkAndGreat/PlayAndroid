package com.example.playandroid.ui.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.ui.fragment.ArticleFragment;
import com.example.playandroid.ui.fragment.SearchFragment;

public class SearchActivity extends BaseActivity implements View.OnClickListener, SearchView.OnQueryTextListener {
    private ImageView mIvBack;
    private FrameLayout mFlSearch;
    private SearchView mSvSearch;
    private SearchFragment mSearchFragment;
    private ArticleFragment mArticleFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mArticleFragment = new ArticleFragment();
        mSearchFragment = new SearchFragment();
        replaceFragment(mSearchFragment);
        initView();
        initListener();
    }

    private void initListener() {
        mIvBack.setOnClickListener(this);
        mSvSearch.setOnQueryTextListener(this);

    }

    private void initView() {
        mIvBack = findViewById(R.id.iv_back);
        mFlSearch = findViewById(R.id.fl_search);
        mSvSearch = findViewById(R.id.sv_search);
        SearchView searchView = findViewById(R.id.sv_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnClickListener(v -> searchView.onActionViewExpanded());

    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        if (TextUtils.isEmpty(query)) {
            Toast.makeText(SearchActivity.this, "请输入查找内容！", Toast.LENGTH_SHORT).show();
        } else {
            mArticleFragment.setSearchWord(query);
            replaceFragment(mArticleFragment);
        }
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }


    public void replaceFragment(Fragment fragment) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_search, fragment);
        fragmentTransaction.commit();
    }
}