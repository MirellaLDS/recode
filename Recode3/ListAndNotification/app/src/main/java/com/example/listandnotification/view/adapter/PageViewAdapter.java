package com.example.listandnotification.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.listandnotification.view.BlankFragment2;
import com.example.listandnotification.view.ScreenSlidePageFragment;

public class PageViewAdapter extends FragmentStatePagerAdapter {

    public PageViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//
//        switch (position) {
//            case 0:
                return new ScreenSlidePageFragment(position+1);
//            case 1:
//                return new BlankFragment2();
//            default:
//                return new BlankFragment2();
//        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
