package com.example.playandroid.presenter;

import com.example.playandroid.base.IBasePresenter;
import com.example.playandroid.view.IHomeCallback;

/**
 * @author OkAndGreat
 */
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
