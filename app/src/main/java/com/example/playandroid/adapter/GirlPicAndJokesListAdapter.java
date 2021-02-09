package com.example.playandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.playandroid.R;
import com.example.playandroid.model.bean.GirlPicBean;
import com.example.playandroid.model.bean.JokesBean;

import java.util.List;

public class GirlPicAndJokesListAdapter extends RecyclerView.Adapter<GirlPicAndJokesListAdapter.ViewHolder> {
    private List<GirlPicBean.DataDTO.ListDTO> mGirlPicList;
    private List<JokesBean.DataDTO.ListDTO> mJokesList;
    private Context mContext;

    public void setData(List<GirlPicBean.DataDTO.ListDTO> mGirlPicList, List<JokesBean.DataDTO.ListDTO> mJokesList) {
        this.mGirlPicList = mGirlPicList;
        this.mJokesList = mJokesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_girlsandjokes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(mGirlPicList.get(position).getImageUrl()).into(holder.mIvGirl);
        holder.mTvJokes.setText(mJokesList.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return mGirlPicList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView mIvGirl;
        private final TextView mTvJokes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIvGirl = (ImageView) itemView.findViewById(R.id.iv_girl);
            mTvJokes = (TextView) itemView.findViewById(R.id.tv_jokes);
        }
    }
}
