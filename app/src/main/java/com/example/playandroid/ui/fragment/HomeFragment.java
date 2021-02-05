package com.example.playandroid.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseApplication;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.presenter.impl.HomePresenterImpl;
import com.example.playandroid.ui.CustomView.UILoader;
import com.example.playandroid.view.IHomeCallback;

import java.util.List;
import java.util.zip.Inflater;

public class HomeFragment extends BaseFragment implements IHomeCallback {

    private UILoader mUiLoader;
    private HomePresenterImpl mHomePresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mUiLoader = new UILoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(inflater, container);
            }
        };
        //获取到逻辑层的对象
        mHomePresenter = new HomePresenterImpl();
        //设置通知接口的注册
        mHomePresenter.registerViewCallback(this);
        //获取推荐列表
        mHomePresenter.getHomeArticleData();

        if (mUiLoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUiLoader.getParent()).removeView(mUiLoader);
        }

        return mUiLoader;
    }

private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container){
        return null;
}
    @Override
    public void onHomeArticleLoaded(List<HomeArticleBean> NormalArticle, List<TopHomeArticleBean> TopArticle) {
        mUiLoader.updateStatus(UILoader.UIStatus.SUCCESS);
    }

    @Override
    public void onNetworkError() {
        mUiLoader.updateStatus(UILoader.UIStatus.NETWORK_ERROR);
    }

    @Override
    public void onEmpty() {
        mUiLoader.updateStatus(UILoader.UIStatus.EMPTY);
    }

    @Override
    public void onLoading() {
        mUiLoader.updateStatus(UILoader.UIStatus.LOADING);
    }
}
