package com.example.playandroid.view;

/**
 * @author OkAndGreat
 */
public interface IRestCallback {
    /**
     * 加载美女图片的回调
     */
    void onGirlPicLoaded();

    /**
     * 加载笑话的回调
     */
    void onJokesLoaded();

    /**
     * 加载那年今日数据的回调
     */
    void onHistoryLoaded();
}
