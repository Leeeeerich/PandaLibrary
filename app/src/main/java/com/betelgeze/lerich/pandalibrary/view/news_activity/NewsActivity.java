package com.betelgeze.lerich.pandalibrary.view.news_activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.betelgeze.lerich.pandalibrary.BaseActivity;
import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.view.library_activity.GenreFrag;
import com.betelgeze.lerich.pandalibrary.view.library_activity.NoveltyFrag;
import com.betelgeze.lerich.pandalibrary.view.library_activity.SearchFrag;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.news_activity_name);

        resources = getResources();

        Intent intent = getIntent();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);     //???????????????????????????????????????

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        NewsActivity.ViewPagerAdapter adapter = new NewsActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new NewsFrag(), resources.getString(R.string.news));
        adapter.addFragment(new NoveltyFrag(), resources.getString(R.string.noveltyFrag));
        adapter.addFragment(new GenreFrag(), resources.getString(R.string.genre));
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}