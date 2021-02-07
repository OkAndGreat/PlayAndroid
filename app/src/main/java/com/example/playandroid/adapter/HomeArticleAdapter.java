package com.example.playandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.HomeArticleBean;
import com.example.playandroid.model.bean.TopHomeArticleBean;
import com.example.playandroid.utils.HtmlUtils;

import java.util.ArrayList;
import java.util.List;

public class HomeArticleAdapter extends RecyclerView.Adapter<HomeArticleAdapter.ViewHolder> {
    ArrayList<TopHomeArticleBean.DataDTO> mTopArticle;
    ArrayList<HomeArticleBean.DataDTO.DatasDTO> mNormalArticle;
    OnURLClickListener monURLClickListener;
    private static final String TAG = "HomeTopArticleAdapter";

    /**
     * 因为置顶文章和普通文章不同因此传入俩组数据
     *
     * @param TopArticle
     * @param NormalArticle
     */
    public void setData(ArrayList<TopHomeArticleBean.DataDTO> TopArticle, ArrayList<HomeArticleBean.DataDTO.DatasDTO> NormalArticle) {
        this.mTopArticle = TopArticle;
        mNormalArticle = NormalArticle;
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
        if (position + 1 > mTopArticle.size()) {
            position = position - mTopArticle.size();
            holder.mTv_top.setVisibility(View.GONE);
            HomeArticleBean.DataDTO.DatasDTO item = mNormalArticle.get(position);
            //处理item点击事件
            holder.mll_item_article.setOnClickListener(v -> monURLClickListener.OnClick(item.getLink()));

            Boolean fresh = item.getFresh();
            if (!fresh)
                holder.mTv_new.setVisibility(View.GONE);
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
            if (tags.toString().contains("项目"))
                holder.mTv_project.setVisibility(View.VISIBLE);
            if (tags.toString().contains("公众号"))
                holder.mTv_accounts.setVisibility(View.VISIBLE);
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
        } else {
            TopHomeArticleBean.DataDTO item = mTopArticle.get(position);
            //处理item点击事件
            holder.mll_item_article.setOnClickListener(v -> monURLClickListener.OnClick(item.getLink()));
            Boolean fresh = item.getFresh();
            if (!fresh)
                holder.mTv_new.setVisibility(View.GONE);
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
    }


    @Override
    public int getItemCount() {
        return mTopArticle.size() + mNormalArticle.size();
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
        private final LinearLayout mll_item_article;

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
            mll_item_article = (LinearLayout) itemView.findViewById(R.id.ll_item_article);
        }

    }

    public void setOnURLClickListener(OnURLClickListener onURLClickListener) {
        this.monURLClickListener = onURLClickListener;
    }

    public interface OnURLClickListener {
        public void OnClick(String URL);
    }
}
