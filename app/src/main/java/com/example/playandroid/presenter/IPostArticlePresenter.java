package com.example.playandroid.presenter;

import android.content.Context;

import com.example.playandroid.base.IBasePresenter;
import com.example.playandroid.view.PostArticleCallback;

public interface IPostArticlePresenter extends IBasePresenter<PostArticleCallback> {
    /**
     * 获得上传文章返回的数据
     */
    void PostArticleData(String title, String link, Context context);
}
