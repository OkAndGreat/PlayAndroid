package com.example.playandroid.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.presenter.impl.PostArticlePresenterImpl;
import com.example.playandroid.view.PostArticleCallback;

public class PostArticleActivity extends BaseActivity implements View.OnClickListener, PostArticleCallback {
    private ImageView mIvShareBack;
    private EditText mEtShareTitle;
    private EditText mEtShareLink;
    private Button mBtnShare;
    private PostArticlePresenterImpl mPostArticlePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_article_activity);
        mPostArticlePresenter = new PostArticlePresenterImpl();
        mPostArticlePresenter.registerViewCallback(this);
        initView();
        initListener();
    }

    private void initListener() {
        mBtnShare.setOnClickListener(this);
        mIvShareBack.setOnClickListener(this);
    }

    private void initView() {
        mIvShareBack = (ImageView) findViewById(R.id.iv_share_back);
        mEtShareTitle = (EditText) findViewById(R.id.et_share_title);
        mEtShareLink = (EditText) findViewById(R.id.et_share_link);
        mBtnShare = (Button) findViewById(R.id.btn_share);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.iv_share_back) {
            finish();
        } else if (id == R.id.btn_share) {
            mPostArticlePresenter.PostArticleData(mEtShareTitle.getText().toString(), mEtShareLink.getText().toString(), this);
        }
    }

    @Override
    public void PostArticleSuccess() {
        Toast.makeText(this, "分享文章成功!", Toast.LENGTH_LONG).show();
    }
}