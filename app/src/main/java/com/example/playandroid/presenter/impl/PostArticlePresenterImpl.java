package com.example.playandroid.presenter.impl;

import android.content.Context;
import android.widget.Toast;

import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.PostArticleBean;
import com.example.playandroid.presenter.IPostArticlePresenter;
import com.example.playandroid.utils.RetrofitManger;
import com.example.playandroid.view.PostArticleCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostArticlePresenterImpl implements IPostArticlePresenter {
    private PostArticleCallback mPostArticleCallback;


    @Override
    public void PostArticleData(String title, String link, Context context) {
        API api = RetrofitManger.getInstance().createMainRetrofit().create(API.class);
        api.postArticles(title,link).enqueue(new Callback<PostArticleBean>() {
            @Override
            public void onResponse(Call<PostArticleBean> call, Response<PostArticleBean> response) {
                if (response.body().getErrorCode()!=0) {
                    Toast.makeText(context,response.body().getErrorMsg(),Toast.LENGTH_LONG).show();
                }
                else {
                    mPostArticleCallback.PostArticleSuccess();
                }
            }

            @Override
            public void onFailure(Call<PostArticleBean> call, Throwable t) {
                Toast.makeText(context,"网络可能有问题哦~",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void registerViewCallback(PostArticleCallback postArticleCallback) {
        mPostArticleCallback = postArticleCallback;
    }

    @Override
    public void unRegisterViewCallback(PostArticleCallback postArticleCallback) {
        mPostArticleCallback = null;
    }
}
