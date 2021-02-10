package com.example.playandroid.view;


import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.ShareArticlesBean;

import java.util.List;

/**
 * @author OkAndGreat
 */
public interface IArticleCallback {
    /**
     * 获取问答文章及搜索内容的结果
     * @param ArticleData
     */
    void onArticleLoaded(List<ArticleBean.DataDTO.DatasDTO> ArticleData);

    /**
     * 获取分享文章的结果.type参数没有实际效果,仅为与上面onArticleLoaded方法进行区分
     * @param ArticleData
     * @param type
     */
    void onArticleLoaded(List<ShareArticlesBean.DataDTO.ShareArticlesDTO.DatasDTO> ArticleData,int type);
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
