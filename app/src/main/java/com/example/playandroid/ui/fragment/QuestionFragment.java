package com.example.playandroid.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.ArticleAdapter;
import com.example.playandroid.adapter.HomeArticleAdapter;
import com.example.playandroid.base.BaseApplication;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.presenter.impl.HomePresenterImpl;
import com.example.playandroid.presenter.impl.QuestionPresenterImpl;
import com.example.playandroid.ui.CustomView.UILoader;
import com.example.playandroid.ui.activity.WebActivity;
import com.example.playandroid.view.IQuestionCallback;

import java.util.List;

public class QuestionFragment extends BaseFragment implements IQuestionCallback, UILoader.OnRetryClickListener {
    private UILoader mUiLoader;
    private QuestionPresenterImpl mQuestionPresenter;
    private View mRootView;
    private ArticleAdapter mArticleAdapter;

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
        mQuestionPresenter = new QuestionPresenterImpl();
        //设置通知接口的注册
        mQuestionPresenter.registerViewCallback(this);
        //获取推荐列表
        mQuestionPresenter.getQuestionArticleData();

        if (mUiLoader.getParent() instanceof ViewGroup) {
            ((ViewGroup) mUiLoader.getParent()).removeView(mUiLoader);
        }

        mUiLoader.setOnRetryClickListener(this);

        return mUiLoader;
    }

    private View createSuccessView(LayoutInflater inflater, ViewGroup container) {
        mRootView = inflater.inflate(R.layout.fragment_question, container, false);
        //RecyclerView使用
        RecyclerView rv_question = mRootView.findViewById(R.id.rv_question);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rv_question.setLayoutManager(linearLayoutManager);
        //设置适配器
        mArticleAdapter = new ArticleAdapter();
        rv_question.setAdapter(mArticleAdapter);
        initItemClickEvent();
        return mRootView;
    }

    private void initItemClickEvent() {
        mArticleAdapter.setOnArticleURLClickListener(URL -> {
            Intent intent = new Intent(getContext(), WebActivity.class);
            intent.putExtra("url", URL);
            startActivity(intent);
        });
    }


    @Override
    public void onHomeArticleLoaded(List<ArticleBean.DataDTO.DatasDTO> QuestionArticleData) {
        mArticleAdapter.setData(QuestionArticleData);
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //取消接口的注册
        mQuestionPresenter.unRegisterViewCallback(this);
    }

    @Override
    public void onRetryClick() {
        //表示网络不佳的时候，用户点击了重试
        //重新获取数据即可
        mQuestionPresenter.getQuestionArticleData();
    }
}
