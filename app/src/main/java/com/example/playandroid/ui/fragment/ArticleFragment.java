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
import com.example.playandroid.adapter.ArticleAdapter;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.model.bean.ShareArticlesBean;
import com.example.playandroid.presenter.impl.ArticlePresenterImpl;
import com.example.playandroid.ui.customview.UiLoader;
import com.example.playandroid.ui.activity.WebActivity;
import com.example.playandroid.view.IArticleCallback;

import java.util.List;

/**
 * @author OkAndGreat
 */
public class ArticleFragment extends BaseFragment implements IArticleCallback, UiLoader.OnRetryClickListener {
    private UiLoader mUiLoader;
    private ArticlePresenterImpl mArticlePresenter;
    private View mRootView;
    private ArticleAdapter mArticleAdapter;


    private String SearchWord = null;

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
        //获取推荐列表 用if else来判断增强该类的可复用性
        if (SearchWord == null) {
            mArticlePresenter.getQuestionArticleData();
        } else {
            mArticlePresenter.getSearchArticleData(SearchWord);
        }

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
        mArticleAdapter.setOnArticleUrlClickListener(URL -> {
            Intent intent = new Intent(getContext(), WebActivity.class);
            intent.putExtra("url", URL);
            startActivity(intent);
        });
    }


    @Override
    public void onArticleLoaded(List<ArticleBean.DataDTO.DatasDTO> ArticleData) {
        mArticleAdapter.setData(ArticleData);
        mUiLoader.updateStatus(UiLoader.UIStatus.SUCCESS);
    }

    @Override
    public void onArticleLoaded(List<ShareArticlesBean.DataDTO.ShareArticlesDTO.DatasDTO> ArticleData, int type) {

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
    public void onDestroyView() {
        super.onDestroyView();
        //取消接口的注册
        mArticlePresenter.unRegisterViewCallback(this);
    }

    @Override
    public void onRetryClick() {
        //表示网络不佳的时候，用户点击了重试
        //重新获取数据即可
        mArticlePresenter.getQuestionArticleData();
    }

    public String getSearchWord() {
        return SearchWord;
    }

    public void setSearchWord(String searchWord) {
        SearchWord = searchWord;
    }
}
