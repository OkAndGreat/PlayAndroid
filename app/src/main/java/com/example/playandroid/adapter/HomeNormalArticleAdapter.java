package com.example.playandroid.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;

import java.util.List;

public class HomeNormalArticleAdapter extends RecyclerView.Adapter<HomeNormalArticleAdapter.ViewHolder> {
    List<HomeArticleBean.DataDTO.DatasDTO> mNormalArticle;

    public void setData(List<HomeArticleBean.DataDTO.DatasDTO> NormalArticle) {
        this.mNormalArticle=NormalArticle;
        this.notifyDataSetChanged();
    }
    @NonNull
    @Override
    public HomeNormalArticleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeNormalArticleAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
