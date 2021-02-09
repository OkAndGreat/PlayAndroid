package com.example.playandroid.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.adapter.GirlPicAndJokesListAdapter;
import com.example.playandroid.base.BaseActivity;
import com.example.playandroid.model.API;
import com.example.playandroid.model.bean.GirlPicBean;
import com.example.playandroid.model.bean.JokesBean;
import com.example.playandroid.utils.RetrofitManger;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GirlAndJokesActivity extends BaseActivity implements View.OnClickListener {

    private RecyclerView mRvGirl;
    private ImageView mIvBack;
    private List<GirlPicBean.DataDTO.ListDTO> mGirlPicList;
    private List<JokesBean.DataDTO.ListDTO> mJokesList;
    private GirlPicAndJokesListAdapter mGirlPicAndJokesListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gril);
        initView();
        getData();
        initListener();
    }

    private void setData() {
        mGirlPicAndJokesListAdapter.setData(mGirlPicList,mJokesList);
        mRvGirl.setAdapter(mGirlPicAndJokesListAdapter);
    }

    private void getData() {
        API api = RetrofitManger.getInstance().createRestRetrofit().create(API.class);
        Call<GirlPicBean> girlPicData = api.getGirlPicData(0, "huhpitf1ukunvqvq", "eVh4YXZjTlpDYUU3Vlp4RnEyUWs4UT09");
        girlPicData.enqueue(new Callback<GirlPicBean>() {
            @Override
            public void onResponse(Call<GirlPicBean> call, Response<GirlPicBean> response) {
                GirlPicBean.DataDTO data = response.body().getData();
                mGirlPicList = data.getList();
            }

            @Override
            public void onFailure(Call<GirlPicBean> call, Throwable t) {
                Toast.makeText(GirlAndJokesActivity.this, "请求数据出错!", Toast.LENGTH_LONG).show();
            }
        });

        Call<JokesBean> jokesData = api.getJokesData(0, "huhpitf1ukunvqvq", "eVh4YXZjTlpDYUU3Vlp4RnEyUWs4UT09");
        jokesData.enqueue(new Callback<JokesBean>() {

            @Override
            public void onResponse(Call<JokesBean> call, Response<JokesBean> response) {
                mJokesList = response.body().getData().getList();
                setData();
            }

            @Override
            public void onFailure(Call<JokesBean> call, Throwable t) {
                Toast.makeText(GirlAndJokesActivity.this, "请求数据出错!", Toast.LENGTH_LONG).show();
            }
        });

    }

    private void initView() {
        mRvGirl = (RecyclerView) findViewById(R.id.rv_girl);
        mGirlPicAndJokesListAdapter = new GirlPicAndJokesListAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvGirl.setLayoutManager(linearLayoutManager);
        mIvBack = (ImageView) findViewById(R.id.iv_girl_back);
    }

    private void initListener() {
        mIvBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}