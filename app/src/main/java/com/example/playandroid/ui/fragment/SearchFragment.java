package com.example.playandroid.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseFragment;

public class SearchFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //TODO:为热词绑定点击事件的回调
        View view = inflater.inflate(R.layout.fragment_search_normal, container, false);
        return view;
    }
}
