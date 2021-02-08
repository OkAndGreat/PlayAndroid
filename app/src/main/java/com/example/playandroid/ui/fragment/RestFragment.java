package com.example.playandroid.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.ui.activity.GirlActivity;
import com.example.playandroid.ui.activity.JokesActivity;
import com.example.playandroid.ui.activity.ThatDayActivity;

/**
 * @author OkAndGreat
 */
public class RestFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rest, null);
        return view;
    }

}
