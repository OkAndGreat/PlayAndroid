package com.example.playandroid.presenter;

import com.example.playandroid.base.IBasePresenter;
import com.example.playandroid.view.IArticleCallback;

/**
 * @author OkAndGreat
 */
public interface IArticlePresenter extends IBasePresenter<IArticleCallback> {
    /**
     * 获取问题文章数据
     */
    void getQuestionArticleData();

    /**
     * 获取分享页面文章数据
     */
    void getShareArticleData();

    /**
     * 获取搜索页面文章数据
     * @param SearchWord 搜索关键字
     */
    void getSearchArticleData(String SearchWord);

    /**
     * 获取刷新时的数据
     */
    void getLoadMoreData();
}
