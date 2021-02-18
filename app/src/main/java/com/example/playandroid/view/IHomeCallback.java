package com.example.playandroid.view;

import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;

import java.util.ArrayList;

/**
 * @author OkAndGreat
 */
public interface IHomeCallback {

    /**
     * 获取推荐内容的结果
     * @param normalArticle
     * @param topArticle
     */
    void onHomeArticleLoaded(ArrayList<HomeArticleBean.DataDTO.DatasDTO> normalArticle, ArrayList<TopHomeArticleBean.DataDTO> topArticle);
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
