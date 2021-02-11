package com.example.playandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.playandroid.R;
import com.example.playandroid.adapter.HistoryListAdapter;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.ui.fragment.ArticleFragment;

public class HistoryActivity extends BaseActivity {
    private View mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initListener();
    }

    private void initListener() {
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initView() {
        mBack = findViewById(R.id.iv_history_back);
        RecyclerView RvHistory = (RecyclerView) findViewById(R.id.rv_history);
        HistoryListAdapter historyListAdapter = new HistoryListAdapter();
        RvHistory.setAdapter(historyListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RvHistory.setLayoutManager(linearLayoutManager);
    }

}