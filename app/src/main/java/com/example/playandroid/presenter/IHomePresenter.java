package com.example.playandroid.presenter;

import com.example.playandroid.base.IBasePresenter;
import com.example.playandroid.view.IHomeCallback;

//Presenter类请求数据并通过Callback类将数据返回UI
public interface IHomePresenter extends IBasePresenter<IHomeCallback> {
    /**
     * 获取文章数据
     */
    void getHomeArticleData();

    /**
     * 获取刷新时的数据
     */
    void getLoadMoreData();
}
