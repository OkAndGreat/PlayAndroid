package com.example.playandroid.ui.activity;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ThatDayListAdapter;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.ThatDayBean;
import com.example.playandroid.utils.LogUtil;
import com.example.playandroid.utils.RetrofitManger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 因为Rest模块下的逻辑都比较简单,所以就不用MVP了!
 */
public class ThatDayActivity extends BaseActivity implements View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private static final String TAG = "ThatDayActivity";
    private List<ThatDayBean.DataDTO> mThatDayData;
    private RecyclerView mThatDayList;
    private ThatDayListAdapter mThatDayListAdapter;
    private View mIvBack;
    private SwipeRefreshLayout mRefreshThatDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_that_day);
        initView();
        getData();
        initListener();
    }

    private void initListener() {
        mIvBack.setOnClickListener(this);
        mRefreshThatDay.setOnRefreshListener(this);
    }

    private void getData() {
        API api = RetrofitManger.getInstance().createRestRetrofit().create(API.class);
        Call<ThatDayBean> thatDayData = api.getThatDayData(0, "huhpitf1ukunvqvq", "eVh4YXZjTlpDYUU3Vlp4RnEyUWs4UT09");
        thatDayData.enqueue(new Callback<ThatDayBean>() {
            @Override
            public void onResponse(Call<ThatDayBean> call, Response<ThatDayBean> response) {
                LogUtil.d(TAG,"response.body().toString()-->"+response.body().getData().toString());
                mThatDayData = response.body().getData();
                mThatDayList.setAdapter(mThatDayListAdapter);
                mThatDayListAdapter.setData(mThatDayData);
                mRefreshThatDay.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<ThatDayBean> call, Throwable t) {
                Toast.makeText(ThatDayActivity.this, "请求数据出错!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initView() {
        mThatDayList = findViewById(R.id.rv_that_day);
        mIvBack = findViewById(R.id.iv_thatday_back);
        mThatDayListAdapter = new ThatDayListAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mThatDayList.setLayoutManager(gridLayoutManager);
        mRefreshThatDay = (SwipeRefreshLayout) findViewById(R.id.refresh_that_day);
        mRefreshThatDay.setColorSchemeColors(Color.rgb(56,128,253));
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    @Override
    public void onRefresh() {
        getData();
    }
}