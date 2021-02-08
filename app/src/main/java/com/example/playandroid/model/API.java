package com.example.playandroid.model;

import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @author OkAndGreat
 */
public interface API {
    /**
     * 获得文章数据
     * @param page
     * @return
     */
    @GET("/article/list/{page}/json")
    Call<HomeArticleBean> getHomeArticle(@Path("page")int page);

    /**
     * 获得文章数据
     * @return
     */
    @GET("/article/top/json")
    Call<TopHomeArticleBean> getTopHomeArticle();

    /**
     * 获得问答数据
     * @param page
     * @return
     */
    @GET("/wenda/list/{page}/json")
    Call<ArticleBean> getQuestionArticle(@Path("page")int page);
}
