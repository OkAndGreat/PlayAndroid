package com.example.playandroid.presenter.impl;

import android.net.wifi.WifiManager;

import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.presenter.IHomePresenter;
import com.example.playandroid.utils.LogUtil;
import com.example.playandroid.utils.RetrofitManger;
import com.example.playandroid.view.IHomeCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements IHomePresenter {
    private IHomeCallback mIHomeCallback = null;
    private ArrayList<HomeArticleBean.DataDTO.DatasDTO> mNormalArticle;
    private static final String TAG = "HomePresenterImpl";

    @Override
    public void registerViewCallback(IHomeCallback iHomeCallback) {
        mIHomeCallback = iHomeCallback;
    }

    @Override
    public void unRegisterViewCallback(IHomeCallback iHomeCallback) {
        mIHomeCallback = null;
    }

    @Override
    public void getHomeArticleData() {
        mIHomeCallback.onLoading();
        RetrofitManger instance = RetrofitManger.getInstance();
        API api = instance.createMainRetrofit().create(API.class);
        Call<TopHomeArticleBean> topHomeArticle = api.getTopHomeArticle();
        topHomeArticle.enqueue(new Callback<TopHomeArticleBean>() {
            @Override
            public void onResponse(Call<TopHomeArticleBean> call, Response<TopHomeArticleBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    if (response.body() == null) {
                        //数据为空
                        mIHomeCallback.onEmpty();
                    } else {
                        ArrayList<TopHomeArticleBean.DataDTO> data = (ArrayList<TopHomeArticleBean.DataDTO>)response.body().getData();
                        LogUtil.d(TAG,"data.toString()-->"+data.toString());
                        mIHomeCallback.onHomeArticleLoaded(mNormalArticle,data);
                    }
                } else {
                    //网络错误,让UILoader去显示网络错误的UI界面
                    mIHomeCallback.onNetworkError();
                }
            }

            @Override
            public void onFailure(Call<TopHomeArticleBean> call, Throwable t) {
                //网络错误,让UILoader去显示网络错误的UI界面
                mIHomeCallback.onNetworkError();
            }
        });
        Call<HomeArticleBean> homeArticle = api.getHomeArticle(1);
        homeArticle.enqueue(new Callback<HomeArticleBean>() {
            @Override
            public void onResponse(Call<HomeArticleBean> call, Response<HomeArticleBean> response) {
                int code = response.code();
                if (code == HttpURLConnection.HTTP_OK) {
                    if (response.body() == null) {
                        mIHomeCallback.onEmpty();
                    } else {
                        HomeArticleBean.DataDTO data = response.body().getData();
                        mNormalArticle = (ArrayList<HomeArticleBean.DataDTO.DatasDTO>)data.getDatas();
                    }
                } else {
                    mIHomeCallback.onNetworkError();
                }
            }

            @Override
            public void onFailure(Call<HomeArticleBean> call, Throwable t) {
                mIHomeCallback.onNetworkError();
            }
        });

    }

    @Override
    public void getLoadMoreData() {

    }
}
