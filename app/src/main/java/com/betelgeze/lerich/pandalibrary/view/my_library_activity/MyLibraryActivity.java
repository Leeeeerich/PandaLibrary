package com.betelgeze.lerich.pandalibrary.view.my_library_activity;

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

import java.util.ArrayList;
import java.util.List;

public class MyLibraryActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private Resources resources;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle(R.string.my_library);

        resources = getResources();

        Intent intent = getIntent();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);      //???????????????????????????????????????

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


    }

    private void setupViewPager(ViewPager viewPager) {
        MyLibraryActivity.ViewPagerAdapter adapter = new MyLibraryActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyReadingFrag(), resources.getString(R.string.reading));
        adapter.addFragment(new MyGenreFrag(), resources.getString(R.string.genre));
        adapter.addFragment(new MySearchFrag(), resources.getString(R.string.search));
        adapter.addFragment(new MyQueueFrag(), resources.getString(R.string.queue));
        adapter.addFragment(new MyReadFrag(), resources.getString(R.string.read));
        adapter.addFragment(new MyNotInterestedFrag(), resources.getString(R.string.not_interested));

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