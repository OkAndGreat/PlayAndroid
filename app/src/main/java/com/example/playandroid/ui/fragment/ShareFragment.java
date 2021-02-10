package com.example.playandroid.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ArticleAdapter;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.ShareArticlesBean;
import com.example.playandroid.presenter.impl.ArticlePresenterImpl;
import com.example.playandroid.ui.activity.PostArticleActivity;
import com.example.playandroid.ui.activity.WebActivity;
import com.example.playandroid.ui.customview.UiLoader;
import com.example.playandroid.view.IArticleCallback;

import java.util.List;

/**
 * @author OkAndGreat
 */
public class ShareFragment extends BaseFragment implements UiLoader.OnRetryClickListener, IArticleCallback, View.OnClickListener {
    private UiLoader mUiLoader;
    private ArticlePresenterImpl mArticlePresenter;
    private View mRootView;
    private ArticleAdapter mArticleAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mUiLoader = new UiLoader(getContext()) {
            @Override
            protected View getSuccessView(ViewGroup container) {
                return createSuccessView(inflater, container);
            }
        };
        //获取到逻辑层的对象
        mArticlePresenter = new ArticlePresenterImpl();
        //设置通知接口的注册
        mArticlePresenter.registerViewCallback(this);
        //获取分享文章列表
        mArticlePresenter.getShareArticleData();


        if (mUiLoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUiLoader.getParent()).removeView(mUiLoader);
        }

        mUiLoader.setOnRetryClickListener(this);
        return mUiLoader;
    }


    private View createSuccessView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_share, container, false);
        //RecyclerView使用
        RecyclerView rv_share = mRootView.findViewById(R.id.rv_share);
        RelativeLayout llShare = (RelativeLayout) mRootView.findViewById(R.id.ll_share);
        llShare.setOnClickListener(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_share.setLayoutManager(linearLayoutManager);
        //设置适配器
        mArticleAdapter = new ArticleAdapter();
        rv_share.setAdapter(mArticleAdapter);
        initItemClickEvent();
        return mRootView;
    }

    private void initItemClickEvent() {
        mArticleAdapter.setOnArticleUrlClickListener(URL -> {
            Intent intent = new Intent(getContext(), WebActivity.class);
            intent.putExtra("url", URL);
            startActivity(intent);
        });
    }

    @Override
    public void onRetryClick() {
        //表示网络不佳的时候，用户点击了重试
        //重新获取数据即可
        mArticlePresenter.getShareArticleData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //取消接口的注册
        mArticlePresenter.unRegisterViewCallback(this);
    }

    @Override
    public void onArticleLoaded(List<ArticleBean.DataDTO.DatasDTO> ArticleData) {
    }

    @Override
    public void onArticleLoaded(List<ShareArticlesBean.DataDTO.ShareArticlesDTO.DatasDTO> ArticleData, int type) {
        mArticleAdapter.setData(ArticleData,1);
        mUiLoader.updateStatus(UiLoader.UIStatus.SUCCESS);
    }

    @Override
    public void onNetworkError() {
        mUiLoader.updateStatus(UiLoader.UIStatus.NETWORK_ERROR);
    }

    @Override
    public void onEmpty() {
        mUiLoader.updateStatus(UiLoader.UIStatus.EMPTY);
    }

    @Override
    public void onLoading() {
        mUiLoader.updateStatus(UiLoader.UIStatus.LOADING);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getContext(), PostArticleActivity.class);
        startActivity(intent);
    }
}
