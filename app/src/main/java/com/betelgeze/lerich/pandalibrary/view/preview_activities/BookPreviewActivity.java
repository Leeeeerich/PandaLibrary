package com.betelgeze.lerich.pandalibrary.view.preview_activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.betelgeze.lerich.pandalibrary.BaseActivity;
import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.view.library_activity.LibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyGenreFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyLibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyNotInterestedFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyQueueFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyReadFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyReadingFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MySearchFrag;

import java.util.ArrayList;
import java.util.List;


public class BookPreviewActivity extends PreviewActivity {

    Toolbar toolbar;
    ViewPager viewPager;

    RecyclerView.Adapter adapter;



    int position = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_book);
        Log.e("Billion", "qwertyuiop[poiuytrewertyuio = ");
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);

        Intent intent = getIntent();
        String titleBookLinkName = intent.getStringExtra("link_name");
        String urlBook = intent.getStringExtra("link");
        position = intent.getIntExtra("position", 1);



        setTitle(titleBookLinkName);

        //onLibraryActivity();


    }


/*
    private void setupViewPager(ViewPager viewPager) {
        BookPreviewActivity.ViewPagerAdapter adapter = new MyLibraryActivity.ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new MyReadingFrag(), resources.getString(R.string.reading));
        adapter.addFragment(new MyGenreFrag(), resources.getString(R.string.genre));
        adapter.addFragment(new MySearchFrag(), resources.getString(R.string.search));
        adapter.addFragment(new MyQueueFrag(), resources.getString(R.string.queue));
        adapter.addFragment(new MyReadFrag(), resources.getString(R.string.read));
        adapter.addFragment(new MyNotInterestedFrag(), resources.getString(R.string.not_interested));

        viewPager.setAdapter(adapter);
    }

*/
    public void onLibraryActivity() {


        Intent intent = new Intent(this, LibraryActivity.class);


        intent.putExtra("link_name", "qwertyui");


        //intent.putIntegerArrayListExtra("link_name", );
        this.startActivity(intent);
    }
}
