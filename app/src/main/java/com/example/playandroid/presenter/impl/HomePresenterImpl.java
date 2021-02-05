package com.example.playandroid.presenter.impl;

import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.presenter.IHomePresenter;
import com.example.playandroid.utils.RetrofitManger;
import com.example.playandroid.view.IHomeCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements IHomePresenter {
private IHomeCallback mIHomeCallback=null;


    @Override
    public void registerViewCallback(IHomeCallback iHomeCallback) {
        mIHomeCallback=iHomeCallback;
    }

    @Override
    public void unRegisterViewCallback(IHomeCallback iHomeCallback) {
        mIHomeCallback=null;
    }

    @Override
    public void getHomeArticleData() {
        RetrofitManger instance = RetrofitManger.getInstance();
        API api = instance.createMainRetrofit().create(API.class);
        Call<TopHomeArticleBean> topHomeArticle = api.getTopHomeArticle();
        topHomeArticle.enqueue(new Callback<TopHomeArticleBean>() {
            @Override
            public void onResponse(Call<TopHomeArticleBean> call, Response<TopHomeArticleBean> response) {

            }

            @Override
            public void onFailure(Call<TopHomeArticleBean> call, Throwable t) {
                mIHomeCallback.onNetworkError();

            }
        });
        Call<HomeArticleBean> homeArticle = api.getHomeArticle(1);
        homeArticle.enqueue(new Callback<HomeArticleBean>() {
            @Override
            public void onResponse(Call<HomeArticleBean> call, Response<HomeArticleBean> response) {

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
