package com.example.playandroid.presenter;

import com.example.playandroid.base.IBasePresenter;
import com.example.playandroid.view.IQuestionCallback;

public interface IQuestionPresenter extends IBasePresenter<IQuestionCallback> {
    /**
     * 获取文章数据
     */
    void getQuestionArticleData();

    /**
     * 获取刷新时的数据
     */
    void getLoadMoreData();
}
