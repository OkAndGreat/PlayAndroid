package com.example.playandroid.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.playandroid.R;
import com.example.playandroid.base.BaseFragment;
import com.example.playandroid.ui.activity.GirlAndJokesActivity;
import com.example.playandroid.ui.activity.ThatDayActivity;

/**
 * @author OkAndGreat
 */
public class RestFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout mThatDay;
    private LinearLayout mLookGirl;
    private LinearLayout mLookJokes;
    private View mCvPlease;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_rest, null);
        initView(mView);
        initListener();
        return mView;
    }

    private void initListener() {
        mThatDay.setOnClickListener(this);
        mLookJokes.setOnClickListener(this);
        mLookGirl.setOnClickListener(this);
        mCvPlease.setOnClickListener(this);

    }

    private void initView(View view) {
        mThatDay = view.findViewById(R.id.cv_look_history);
        mLookGirl = view.findViewById(R.id.cv_look_girl);
        mLookJokes = view.findViewById(R.id.cv_look_jokes);
        mCvPlease = view.findViewById(R.id.cv_please);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.cv_look_history:
                intent = new Intent(getContext(), ThatDayActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_look_girl:
                intent = new Intent(getContext(), GirlAndJokesActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_look_jokes:
                intent = new Intent(getContext(), GirlAndJokesActivity.class);
                startActivity(intent);
                break;
            case R.id.cv_please:
                Toast.makeText(getContext(),"更多功能 敬请期待...",Toast.LENGTH_SHORT).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }
    }
}
