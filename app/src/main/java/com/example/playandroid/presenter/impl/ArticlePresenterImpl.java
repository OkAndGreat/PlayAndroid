package com.example.playandroid.presenter.impl;

import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.ShareArticlesBean;
import com.example.playandroid.presenter.IArticlePresenter;
import com.example.playandroid.utils.RetrofitManger;
import com.example.playandroid.view.IArticleCallback;

import java.net.HttpURLConnection;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author OkAndGreat
 */
public class ArticlePresenterImpl implements IArticlePresenter {
    private IArticleCallback mIArticleCallback;

    @Override
    public void registerViewCallback(IArticleCallback iArticleCallback) {
        mIArticleCallback = iArticleCallback;
    }

    @Override
    public void unRegisterViewCallback(IArticleCallback iArticleCallback) {
        mIArticleCallback = null;
    }

    @Override
    public void getQuestionArticleData() {
        mIArticleCallback.onLoading();
        RetrofitManger instance = RetrofitManger.getInstance();
        Retrofit mainRetrofit = instance.createMainRetrofit();
        API api = mainRetrofit.create(API.class);
        Call<ArticleBean> questionArticle = api.getQuestionArticle(0);
        questionArticle.enqueue(new Callback<ArticleBean>() {
            @Override
            public void onResponse(Call<ArticleBean> call, Response<ArticleBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    if (response.body() == null) {
                        //数据为空
                        mIArticleCallback.onEmpty();
                    } else {
                        ArticleBean.DataDTO data = response.body().getData();
                        List<ArticleBean.DataDTO.DatasDTO> datas = data.getDatas();
                        mIArticleCallback.onArticleLoaded(datas);
                    }
                } else {
                    //网络错误,让UILoader去显示网络错误的UI界面
                    mIArticleCallback.onNetworkError();
                }
            }

            @Override
            public void onFailure(Call<ArticleBean> call, Throwable t) {
                mIArticleCallback.onNetworkError();
            }
        });
    }

    @Override
    public void getShareArticleData() {
        mIArticleCallback.onLoading();
        RetrofitManger instance = RetrofitManger.getInstance();
        Retrofit mainRetrofit = instance.createMainRetrofit();
        API api = mainRetrofit.create(API.class);
        Call<ShareArticlesBean> shareArticleData = api.getShareArticleData(1);
        shareArticleData.enqueue(new Callback<ShareArticlesBean>() {
            @Override
            public void onResponse(Call<ShareArticlesBean> call, Response<ShareArticlesBean> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    if (response.body() == null) {
                        //数据为空
                        mIArticleCallback.onEmpty();
                    } else {
                        List<ShareArticlesBean.DataDTO.ShareArticlesDTO.DatasDTO> datas = response.body().getData().getShareArticles().getDatas();
                        mIArticleCallback.onArticleLoaded(datas, 1);
                    }
                } else {
                    //网络错误,让UILoader去显示网络错误的UI界面
                    mIArticleCallback.onNetworkError();
                }
            }

            @Override
            public void onFailure(Call<ShareArticlesBean> call, Throwable t) {
                mIArticleCallback.onNetworkError();
            }
        });
    }

    @Override
    public void getSearchArticleData(String SearchWord) {
        RetrofitManger.getInstance().createMainRetrofit().create(API.class).getSearchArticleData(0, SearchWord).enqueue(new Callback<ArticleBean>() {
            @Override
            public void onResponse(Call<ArticleBean> call, Response<ArticleBean> response) {
                if (response.body() == null) {
                    mIArticleCallback.onEmpty();
                } else {
                    List<ArticleBean.DataDTO.DatasDTO> datas = response.body().getData().getDatas();
                    mIArticleCallback.onArticleLoaded(datas);
                }
            }

            @Override
            public void onFailure(Call<ArticleBean> call, Throwable t) {
                mIArticleCallback.onNetworkError();
            }
        });

    }


    @Override
    public void getLoadMoreData() {

    }
}
