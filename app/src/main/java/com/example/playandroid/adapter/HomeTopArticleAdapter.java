package com.example.playandroid.adapter;

import android.opengl.Visibility;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.utils.HtmlUtils;
import com.example.playandroid.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class HomeTopArticleAdapter extends RecyclerView.Adapter<HomeTopArticleAdapter.ViewHolder> {
    ArrayList<TopHomeArticleBean.DataDTO> mTopArticle;
    private static final String TAG = "HomeTopArticleAdapter";


    public void setData(ArrayList<TopHomeArticleBean.DataDTO> TopArticle) {
        this.mTopArticle = TopArticle;
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TopHomeArticleBean.DataDTO item = mTopArticle.get(position);
        Boolean fresh = item.getFresh();
        if (!fresh) {
            holder.mTv_new.setVisibility(View.GONE);
        }
        String author = item.getAuthor();
        String shareUser = item.getShareUser();
        holder.mTv_author_name.setText(author == null ? shareUser : author);
        holder.mTv_project.setVisibility(View.GONE);
        holder.mTv_publish.setVisibility(View.GONE);
        holder.mTv_accounts.setVisibility(View.GONE);
        String title = item.getTitle();
        List<?> tags = item.getTags();
        if (tags.toString().contains("本站发布"))
            holder.mTv_publish.setVisibility(View.VISIBLE);
            //对字符串中可能存在的HTML特殊字符进行Replace
            String etitle = HtmlUtils.escapeHtml(title);
        holder.mTv_title.setText(etitle);
        String desc = item.getDesc();
        if (desc == null)
            holder.mTv_detail.setVisibility(View.GONE);
        else {
            String detail = HtmlUtils.escapeHtml(desc);
            holder.mTv_detail.setText(detail);
        }

        String niceDate = item.getNiceDate();
        holder.mTv_time.setText(niceDate);
        holder.mIv_show.setVisibility(View.GONE);
        String superChapterName = item.getSuperChapterName();
        String chapterName = item.getChapterName();
        holder.mTv_chapter.setText(superChapterName + "&" + chapterName);
    }


    @Override
    public int getItemCount() {
        return mTopArticle.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        private final TextView mTv_new;
        private final TextView mTv_author_name;
        private final TextView mTv_publish;
        private final TextView mTv_project;
        private final TextView mTv_accounts;
        private final TextView mTv_time;
        private final ImageView mIv_show;
        private final TextView mTv_title;
        private final TextView mTv_detail;
        private final TextView mTv_top;
        private final TextView mTv_chapter;
        private final ImageView mIv_collect;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv_new = (TextView) itemView.findViewById(R.id.tv_new);
            mTv_author_name = (TextView) itemView.findViewById(R.id.tv_author_name);
            mTv_publish = (TextView) itemView.findViewById(R.id.tv_publish);
            mTv_project = (TextView) itemView.findViewById(R.id.tv_project);
            mTv_accounts = (TextView) itemView.findViewById(R.id.tv_accounts);
            mTv_time = (TextView) itemView.findViewById(R.id.tv_time);
            mIv_show = (ImageView) itemView.findViewById(R.id.iv_show);
            mTv_title = (TextView) itemView.findViewById(R.id.tv_title);
            mTv_detail = (TextView) itemView.findViewById(R.id.tv_detail);
            mTv_top = (TextView) itemView.findViewById(R.id.tv_top);
            mTv_chapter = (TextView) itemView.findViewById(R.id.tv_chapter);
            mIv_collect = (ImageView) itemView.findViewById(R.id.iv_collect);
        }
    }
}
