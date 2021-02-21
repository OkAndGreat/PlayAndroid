package com.example.playandroid.adapter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.ArticleBean;
import com.example.playandroid.ui.activity.MainActivity;
import com.example.playandroid.utils.HtmlUtils;
import com.example.playandroid.utils.LogUtil;

import java.util.ArrayList;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ViewHolder> {
    private ArrayList<ArticleBean.DataDTO.DatasDTO> mArticleDataList=new ArrayList<ArticleBean.DataDTO.DatasDTO>();;
    private OnArticleUrlClickListener mOnArticleUrlClickListener;
    private static final String TAG = "HistoryListAdapter";

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_article, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ArticleBean.DataDTO.DatasDTO item = mArticleDataList.get(position);
        LogUtil.d(TAG,"item.getLink()-->"+item.getLink());
        holder.mll_item_article.setOnClickListener(v -> mOnArticleUrlClickListener.onClick(item.getLink()));
        Boolean fresh = item.getFresh();
        if (!fresh){
            holder.mTv_new.setVisibility(View.GONE);
        }
        String author = item.getAuthor();
        String shareUser = item.getShareUser();
        holder.mTv_author_name.setText(author.equals("") ? shareUser : author);
        holder.mTv_project.setVisibility(View.GONE);
        holder.mTv_publish.setVisibility(View.GONE);
        holder.mTv_accounts.setVisibility(View.GONE);
        holder.mTv_new.setVisibility(View.GONE);
        String title = item.getTitle();
        //对字符串中可能存在的HTML特殊字符进行Replace
        String etitle = HtmlUtils.escapeHtml(title);
        holder.mTv_title.setText(etitle);
        String desc = item.getDesc();
        if (desc == null){
            holder.mTv_detail.setVisibility(View.GONE);
        }
        else {
            String detail = HtmlUtils.escapeHtml(desc);
            holder.mTv_detail.setText(detail);
        }
        String niceDate = item.getNiceDate();
        holder.mTv_time.setText(niceDate);
        String superChapterName = item.getSuperChapterName();
        String chapterName = item.getChapterName();
        holder.mTv_chapter.setText(superChapterName + "&" + chapterName);
    }

    public void getData(){
        SQLiteDatabase db = MainActivity.getDb();
        Cursor cursor = db.query("item", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                // 遍历Cursor对象，取出数据
                ArticleBean.DataDTO.DatasDTO ArticleData=new ArticleBean.DataDTO.DatasDTO();
                ArticleData.setAuthor(cursor.getString((cursor.getColumnIndex("author"))));
                ArticleData.setLink(cursor.getString((cursor.getColumnIndex("link"))));
                ArticleData.setChapterName(cursor.getString((cursor.getColumnIndex("chaptername"))));
                ArticleData.setShareUser(cursor.getString((cursor.getColumnIndex("ShareUser"))));
                ArticleData.setSuperChapterName(cursor.getString((cursor.getColumnIndex("superchaptername"))));
                ArticleData.setDesc(cursor.getString((cursor.getColumnIndex("des"))));
                ArticleData.setFresh("true".equals(cursor.getString((cursor.getColumnIndex("fresh")))));
                ArticleData.setTitle(cursor.getString((cursor.getColumnIndex("title"))));
                ArticleData.setNiceDate(cursor.getString((cursor.getColumnIndex("nicedata"))));
                mArticleDataList.add(ArticleData);
            } while (cursor.moveToNext());
        }
        cursor.close();
        LogUtil.d(TAG,"mArticleDataList.size()-->"+String.valueOf(mArticleDataList.size()));
    }

    @Override
    public int getItemCount() {
        return mArticleDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView mTv_new;
        private final TextView mTv_author_name;
        private final TextView mTv_time;
        private final TextView mTv_title;
        private final TextView mTv_detail;
        private final TextView mTv_chapter;
        private final TextView mTv_publish;
        private final TextView mTv_project;
        private final TextView mTv_accounts;
        private final LinearLayout mll_item_article;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTv_new = (TextView) itemView.findViewById(R.id.tv_new);
            mTv_author_name = (TextView) itemView.findViewById(R.id.tv_author_name);
            mTv_time = (TextView) itemView.findViewById(R.id.tv_time);
            mTv_title = (TextView) itemView.findViewById(R.id.tv_title);
            mTv_detail = (TextView) itemView.findViewById(R.id.tv_detail);
            mTv_chapter = (TextView) itemView.findViewById(R.id.tv_chapter);
            mll_item_article = (LinearLayout) itemView.findViewById(R.id.ll_item_article);
            mTv_publish = (TextView) itemView.findViewById(R.id.tv_publish);
            mTv_project = (TextView) itemView.findViewById(R.id.tv_project);
            mTv_accounts = (TextView) itemView.findViewById(R.id.tv_accounts);
        }
    }

    public void setOnArticleUrlClickListener(OnArticleUrlClickListener onArticleUrlClickListener) {
        mOnArticleUrlClickListener = onArticleUrlClickListener;
    }

    public interface OnArticleUrlClickListener {
        /**
         * 文章点击进入进的页面
         * @param URL
         */
        void onClick(String URL);
    }

    public ArrayList<ArticleBean.DataDTO.DatasDTO> getArticleDataList() {
        return mArticleDataList;
    }

}
