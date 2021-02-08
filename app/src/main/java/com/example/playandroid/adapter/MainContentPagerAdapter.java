package com.example.playandroid.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.playandroid.utils.*;

import static com.example.playandroid.utils.FragmentCreator.getFragment;

/**
 * @author OkAndGreat
 */
public class MainContentPagerAdapter extends FragmentPagerAdapter {
    String[] datas = {"首页", "问答", "体系","休息"};

    public MainContentPagerAdapter(FragmentManager fragmentManager, int behavior) {
        super(fragmentManager, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return getFragment(position);
    }

    @Override
    public int getCount() {
        return Constants.MAIN_CONTENT_PAGER_NUMBER;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return datas[position];
    }
}
