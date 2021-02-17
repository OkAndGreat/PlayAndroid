package com.example.playandroid.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playandroid.R;
import com.example.playandroid.model.bean.PointDetailBean;

import java.util.List;

public class PointDetailListAdapter extends RecyclerView.Adapter<PointDetailListAdapter.ViewHolder> {
    List<PointDetailBean.DataDTO.DatasDTO> mDatas;

    public void setData(List<PointDetailBean.DataDTO.DatasDTO> datas) {
        mDatas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_point_detail,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PointDetailBean.DataDTO.DatasDTO datasDTO = mDatas.get(position);
        holder.mTvCoincount.setText("+"+String.valueOf(datasDTO.getCoinCount()));
        String[] desc = datasDTO.getDesc().split(",");
        holder.mTvDesc1.setText(desc[1]);
        holder.mTvDesc2.setText(desc[0]);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTvDesc1;
        private TextView mTvDesc2;
        private TextView mTvCoincount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvDesc1 = (TextView) itemView.findViewById(R.id.tv_desc1);
            mTvDesc2 = (TextView) itemView.findViewById(R.id.tv_desc2);
            mTvCoincount = (TextView) itemView.findViewById(R.id.tv_coincount);

        }
    }
}
