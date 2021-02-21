package com.example.playandroid.ui.activity;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.adapter.HistoryListAdapter;
import com.example.playandroid.base.BaseActivity;
import com.google.android.material.snackbar.Snackbar;

public class HistoryActivity extends BaseActivity implements HistoryListAdapter.OnArticleUrlClickListener {
    private View mBack;
    private View mTvClear;
    private SQLiteDatabase mDb;
    private HistoryListAdapter mHistoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initListener();
    }

    private void initListener() {
        mBack.setOnClickListener(v -> finish());
        mTvClear.setOnClickListener(v -> Snackbar.make(mBack,"确认删除所有数据?",Snackbar.LENGTH_LONG)
        .setAction("确认", v1 ->deleteDb()).setActionTextColor(Color.RED).show());
    }

    private void initView() {
        mBack = findViewById(R.id.iv_history_back);
        RecyclerView rvHistory =  findViewById(R.id.rv_history);
        mHistoryListAdapter = new HistoryListAdapter();
        mHistoryListAdapter.getData();
        mHistoryListAdapter.setOnArticleUrlClickListener(this);
        rvHistory.setAdapter(mHistoryListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvHistory.setLayoutManager(linearLayoutManager);
        mTvClear = findViewById(R.id.tv_history_clear);
        mDb = MainActivity.getDb();
    }

    private void deleteDb(){
        mDb.delete("item","id>?",new String[]{"0"});
        mHistoryListAdapter.getArticleDataList().clear();
        mHistoryListAdapter.notifyDataSetChanged();
        Toast.makeText(this,"您已删除所有数据!",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(String URL) {
        Intent intent = new Intent(this, WebActivity.class);
        intent.putExtra("url",URL);
        startActivity(intent);
    }
}