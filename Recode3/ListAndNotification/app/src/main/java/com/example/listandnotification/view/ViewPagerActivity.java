package com.example.listandnotification.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.listandnotification.R;
import com.example.listandnotification.view.adapter.PageViewAdapter;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mPager;

    private PageViewAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = findViewById(R.id.viewPager);
        pagerAdapter = new PageViewAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

    }
}