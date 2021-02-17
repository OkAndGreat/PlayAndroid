package com.example.playandroid.presenter;

import android.content.Context;

import com.example.playandroid.base.IBasePresenter;
import com.example.playandroid.view.IPointCallback;

public interface IPointPresenter extends IBasePresenter<IPointCallback> {
    /**
     * 获取积分数据
     */
    void getPointsData(Context context);

    /**
     * 获取详细的积分登陆数据
     */
    void getPointsDetailData(Context context);
}
