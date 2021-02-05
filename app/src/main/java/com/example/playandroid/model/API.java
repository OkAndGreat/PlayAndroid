package com.example.playandroid.model;

import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("/article/list/{page}/json")
    Call<HomeArticleBean> getHomeArticle(@Path("page")int page);

    @GET("/article/top/json")
    Call<TopHomeArticleBean> getTopHomeArticle();

}
