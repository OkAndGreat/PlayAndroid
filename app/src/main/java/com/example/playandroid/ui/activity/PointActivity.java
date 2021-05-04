package com.example.playandroid.ui.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.PointDetailListAdapter;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.bean.PointBean;
import com.example.playandroid.model.bean.PointDetailBean;
import com.example.playandroid.presenter.impl.IPointPresenterImpl;
import com.example.playandroid.view.IPointCallback;


public class PointActivity extends BaseActivity implements IPointCallback {
    private ImageView mIvPointBack;
    private ImageView mIvPointRule;
    private IPointPresenterImpl mIPointPresenter;
    private RecyclerView mRvPoint;
    private Integer mCoinCount;
    private Integer CoinCount = 0;
    Handler mHandler = new Handler();
    private TextView mTvPoint;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mTvPoint.setText(String.valueOf(CoinCount<=mCoinCount?CoinCount:mCoinCount));
            if (CoinCount <= mCoinCount) {
                CoinCount+=6;
                mHandler.postAtTime(runnable, SystemClock.uptimeMillis() + 3);
            }
        }
    };
    private PointDetailListAdapter mPointDetailListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        initView();
        initListener();
        mIPointPresenter = new IPointPresenterImpl();
        mIPointPresenter.registerViewCallback(this);
        mIPointPresenter.getPointsData(this);
        mIPointPresenter.getPointsDetailData(this);
    }

    private void initListener() {
        mIvPointBack.setOnClickListener(v -> finish());
        mIvPointRule.setOnClickListener(v -> {
            Intent intent = new Intent(PointActivity.this, WebActivity.class);
            intent.putExtra("url", "https://www.wanandroid.com/blog/show/2653");
            startActivity(intent);
        });
    }

    private void initView() {
        mIvPointBack = (ImageView) findViewById(R.id.iv_point_back);
        mIvPointRule = (ImageView) findViewById(R.id.iv_point_rule);
        mTvPoint = (TextView) findViewById(R.id.tv_point);
        mRvPoint = (RecyclerView) findViewById(R.id.rv_point);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvPoint.setLayoutManager(linearLayoutManager);
        mPointDetailListAdapter = new PointDetailListAdapter();
    }

    @Override
    public void onPointsDataLoaded(PointBean pointBean) {
        mCoinCount = pointBean.getData().getCoinCount();
        //mHandler.postAtTime(runnable, SystemClock.uptimeMillis() + 1);
        mHandler.post(runnable);
    }

    @Override
    public void onPointsDetailLoaded(PointDetailBean pointDetailBean) {
        mPointDetailListAdapter.setData(pointDetailBean.getData().getDatas());
        mRvPoint.setAdapter(mPointDetailListAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //注销接口,防止内存泄漏
        mIPointPresenter.unRegisterViewCallback(this);
    }
}