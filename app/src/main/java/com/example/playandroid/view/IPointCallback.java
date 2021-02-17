package com.example.playandroid.view;

import com.example.playandroid.model.bean.PointBean;
import com.example.playandroid.model.bean.PointDetailBean;

public interface IPointCallback {
    /**
     * 积分数据的回调
     * @param pointBean
     */
    void onPointsDataLoaded(PointBean pointBean);

    /**
     * 详细积分数据的回调
     * @param pointDetailBean
     */
    void onPointsDetailLoaded(PointDetailBean pointDetailBean);
}
