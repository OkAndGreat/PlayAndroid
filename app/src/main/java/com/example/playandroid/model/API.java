package com.example.playandroid.model;

import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.GirlPicBean;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.JokesBean;
import com.example.playandroid.model.bean.ThatDayBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

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

    /**
     * 获取那年今日数据
     * @param type 返回数据的类型
     * @param app_id 验证请求用户
     * @param app_secret 验证请求用户
     * @return
     */
    @GET("/api/history/today")
    Call<ThatDayBean> getThatDayData(@Query("id") int type,@Query("app_id") String app_id,@Query("app_secret")String app_secret);

    /**获取美图pic
     *
     * @param page 获取图片的第几页
     * @param app_id 验证请求用户
     * @param app_secret 验证请求用户
     * @return
     */
    @GET("/api/image/girl/list")
    Call<GirlPicBean> getGirlPicData(@Query("page") int page,@Query("app_id") String app_id,@Query("app_secret")String app_secret);

    /**获取笑话数据
     *
     * @param page 获取图片的第几页
     * @param app_id 验证请求用户
     * @param app_secret 验证请求用户
     * @return
     */
    @GET("/api/jokes/list")
    Call<JokesBean> getJokesData(@Query("page") int page,@Query("app_id") String app_id,@Query("app_secret")String app_secret);
}
