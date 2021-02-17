package com.example.playandroid.presenter.impl;

import android.content.Context;
import android.widget.Toast;

import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.PointBean;
import com.example.playandroid.model.bean.PointDetailBean;
import com.example.playandroid.presenter.IPointPresenter;
import com.example.playandroid.utils.LogUtil;
import com.example.playandroid.utils.RetrofitManger;
import com.example.playandroid.view.IPointCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IPointPresenterImpl implements IPointPresenter {
    IPointCallback mIPointCallback;
    private static final String TAG = "IPointPresenterImpl";

    @Override
    public void getPointsData(Context context) {
        RetrofitManger.getInstance().createMainRetrofit().create(API.class).getPointData().enqueue(new Callback<PointBean>() {
            @Override
            public void onResponse(Call<PointBean> call, Response<PointBean> response) {
                LogUtil.d(TAG,"PointData-->"+response.body().toString());
                mIPointCallback.onPointsDataLoaded(response.body());
            }

            @Override
            public void onFailure(Call<PointBean> call, Throwable t) {
                Toast.makeText(context, "获取积分数据失败!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void getPointsDetailData(Context context) {
        RetrofitManger.getInstance().createMainRetrofit().create(API.class).getPointDetailData().enqueue(new Callback<PointDetailBean>() {
            @Override
            public void onResponse(Call<PointDetailBean> call, Response<PointDetailBean> response) {
                mIPointCallback.onPointsDetailLoaded(response.body());
            }

            @Override
            public void onFailure(Call<PointDetailBean> call, Throwable t) {
                Toast.makeText(context, "获取积分详细数据失败!", Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void registerViewCallback(IPointCallback iPointCallback) {
        mIPointCallback = iPointCallback;
    }

    @Override
    public void unRegisterViewCallback(IPointCallback iPointCallback) {
        mIPointCallback = null;
    }
}
