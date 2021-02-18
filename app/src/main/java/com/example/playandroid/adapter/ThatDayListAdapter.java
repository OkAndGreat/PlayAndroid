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
import com.example.playandroid.model.bean.ThatDayBean;
import com.example.playandroid.utils.LogUtil;

import java.util.List;


public class ThatDayListAdapter extends RecyclerView.Adapter<ThatDayListAdapter.ViewHolder> {
    private static final String TAG = "ThatDayListAdapter";
    List<ThatDayBean.DataDTO> mData;
    private Context mContext;

    public void setData(List<ThatDayBean.DataDTO> data) {
        mData = data;
        LogUtil.d(TAG,data.toString());
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_that_day, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTvThatDay.setText(mData.get(position).getTitle());
        //图片服务器不稳定,让Glide多请求几次
        for(int i=0;i<100;i++){
            Glide.with(mContext).load(mData.get(position).getPicUrl()).dontAnimate().placeholder(R.drawable.loading).error(R.drawable.error).into(holder.mIvThatDay);
        }
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView mTvThatDay;
        private final ImageView mIvThatDay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mIvThatDay = (ImageView) itemView.findViewById(R.id.iv_that_day);
            mTvThatDay = (TextView) itemView.findViewById(R.id.tv_that_day);
        }
    }
}
