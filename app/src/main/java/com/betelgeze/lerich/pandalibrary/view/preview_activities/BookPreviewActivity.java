package com.betelgeze.lerich.pandalibrary.view.preview_activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import com.betelgeze.lerich.pandalibrary.BaseActivity;
import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.view.library_activity.LibraryActivity;


public class BookPreviewActivity extends BaseActivity {

    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);



        Intent intent = getIntent();
        String titleBookLinkName = intent.getStringExtra("link_name");
        String urlBook = intent.getStringExtra("link");
        setTitle(titleBookLinkName);
        //onLibraryActivity();


    }

    public void onLibraryActivity() {


        Intent intent = new Intent(this, LibraryActivity.class);


        intent.putExtra("link_name", "qwertyui");


        //intent.putIntegerArrayListExtra("link_name", );
        this.startActivity(intent);
    }
}
