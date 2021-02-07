package com.example.playandroid.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.HomeArticleAdapter;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.presenter.impl.HomePresenterImpl;
import com.example.playandroid.ui.CustomView.UILoader;
import com.example.playandroid.ui.activity.WebActivity;
import com.example.playandroid.view.IHomeCallback;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements IHomeCallback, UILoader.OnRetryClickListener {
    private static final String TAG = "HomeFragment";
    private UILoader mUiLoader;
    private HomePresenterImpl mHomePresenter;
    private View mRootView;
    ArrayList<HomeArticleBean.DataDTO.DatasDTO> mNormalArticle;
    ArrayList<TopHomeArticleBean.DataDTO> mTopArticle;
    private HomeArticleAdapter mHomeArticleAdapter;

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

        mUiLoader.setOnRetryClickListener(this);

        return mUiLoader;
    }

    private View createSuccessView(LayoutInflater layoutInflater, ViewGroup container) {
        mRootView = layoutInflater.inflate(R.layout.fragment_home, container, false);
        //RecyclerView使用
        RecyclerView rv_home = mRootView.findViewById(R.id.rv_home);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_home.setLayoutManager(linearLayoutManager);
        //设置适配器
        mHomeArticleAdapter = new HomeArticleAdapter();
        rv_home.setAdapter(mHomeArticleAdapter);
        initItemClickEvent();
        return mRootView;
    }

    private void initItemClickEvent() {
        mHomeArticleAdapter.setOnURLClickListener(URL -> {
            Intent intent = new Intent(getContext(), WebActivity.class);
            intent.putExtra("url", URL);
            startActivity(intent);
        });
    }

    @Override
    public void onHomeArticleLoaded(ArrayList<HomeArticleBean.DataDTO.DatasDTO> NormalArticle, ArrayList<TopHomeArticleBean.DataDTO> TopArticle) {
        mUiLoader.updateStatus(UILoader.UIStatus.SUCCESS);
        mTopArticle = TopArticle;
        mNormalArticle = NormalArticle;
        mHomeArticleAdapter.setData(mTopArticle, mNormalArticle);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //取消接口的注册
        mHomePresenter.unRegisterViewCallback(this);
    }

    @Override
    public void onRetryClick() {
        //表示网络不佳的时候，用户点击了重试
        //重新获取数据即可
        mHomePresenter.getHomeArticleData();
    }
}
