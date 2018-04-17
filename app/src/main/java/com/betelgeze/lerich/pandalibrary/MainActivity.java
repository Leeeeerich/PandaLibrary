package com.betelgeze.lerich.pandalibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.betelgeze.lerich.pandalibrary.view.library_activity.LibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyLibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyReadingFrag;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //onLibraryActivity();


    }

    public void onLibraryActivity() {


        Intent intent = new Intent(this, LibraryActivity.class);


        intent.putExtra("link_name", "qwertyui");


        //intent.putIntegerArrayListExtra("link_name", );
        this.startActivity(intent);
    }
}
