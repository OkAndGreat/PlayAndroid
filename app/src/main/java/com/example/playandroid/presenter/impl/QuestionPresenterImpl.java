package com.example.playandroid.presenter.impl;

import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.presenter.IQuestionPresenter;
import com.example.playandroid.utils.RetrofitManger;
import com.example.playandroid.view.IQuestionCallback;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenterImpl implements IQuestionPresenter {
    private IQuestionCallback mIquestionCallback;

    @Override
    public void registerViewCallback(IQuestionCallback iQuestionCallback) {
        mIquestionCallback = iQuestionCallback;
    }

    @Override
    public void unRegisterViewCallback(IQuestionCallback iQuestionCallback) {
        mIquestionCallback = null;
    }

    @Override
    public void getQuestionArticleData() {
        mIquestionCallback.onLoading();
        RetrofitManger instance = RetrofitManger.getInstance();
        API api = instance.createMainRetrofit().create(API.class);
        Call<ArticleBean> questionArticle = api.getQuestionArticle(0);
        questionArticle.enqueue(new Callback<ArticleBean>() {
            @Override
            public void onResponse(Call<ArticleBean> call, Response<ArticleBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    if (response.body() == null) {
                        //数据为空
                        mIquestionCallback.onEmpty();
                    } else {
                        ArticleBean.DataDTO data = response.body().getData();
                        List<ArticleBean.DataDTO.DatasDTO> datas = data.getDatas();
                            mIquestionCallback.onHomeArticleLoaded(datas);
                    }
                } else {
                    //网络错误,让UILoader去显示网络错误的UI界面
                    mIquestionCallback.onNetworkError();
                }
            }

            @Override
            public void onFailure(Call<ArticleBean> call, Throwable t) {
                mIquestionCallback.onNetworkError();
            }
        });

    }

    @Override
    public void getLoadMoreData() {

    }
}
