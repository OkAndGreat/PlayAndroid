package com.example.playandroid.view;

import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;

import java.util.List;

//Callback类用来Presenter类和UI类进行通信
public interface IHomeCallback {

    /**
     * 获取推荐内容的结果
     *
     * @param result
     */
    void onHomeArticleLoaded(List<HomeArticleBean> NormalArticle,List<TopHomeArticleBean> TopArticle);
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
