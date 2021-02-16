package com.example.playandroid.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.adapter.HistoryListAdapter;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.ui.fragment.ArticleFragment;
import com.google.android.material.snackbar.Snackbar;

public class HistoryActivity extends BaseActivity {
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
        .setAction("确认", v1 ->deleteDb()).show());
    }

    private void initView() {
        mBack = findViewById(R.id.iv_history_back);
        RecyclerView RvHistory = (RecyclerView) findViewById(R.id.rv_history);
        mHistoryListAdapter = new HistoryListAdapter();
        mHistoryListAdapter.getData();
        RvHistory.setAdapter(mHistoryListAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        RvHistory.setLayoutManager(linearLayoutManager);
        mTvClear = findViewById(R.id.tv_history_clear);
        mDb = MainActivity.getDb();
    }

    private void deleteDb(){
        mDb.delete("item","id>?",new String[]{"0"});
        mHistoryListAdapter.getArticleDataList().clear();
        mHistoryListAdapter.notifyDataSetChanged();
        Toast.makeText(this,"您已删除所有数据!",Toast.LENGTH_LONG).show();
    }
}