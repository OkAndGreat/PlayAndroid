package com.example.playandroid.view;

import com.example.playandroid.model.bean.ArticleBean;

import java.util.List;

/**
 * @author OkAndGreat
 */
public interface ISearchCallback {

    /**
     * 获取推荐内容的结果
     */
    void onSearchArticleLoaded();

    /**
     * 网络错误
     */
    void onNetworkError();

    /**
     * 数据为空
     */
    void onEmpty();

    /**
     * 正在加载
     */
    void onLoading();

}
