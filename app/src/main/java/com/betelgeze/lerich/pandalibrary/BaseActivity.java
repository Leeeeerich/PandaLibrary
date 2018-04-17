package com.betelgeze.lerich.pandalibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.betelgeze.lerich.pandalibrary.view.library_activity.LibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyLibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.news_activity.NewsActivity;


public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    protected Toolbar toolbar;
 /*   private TabLayout tabLayout;
    private ViewPager viewPager;

    private Context context;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appBarLayout);
        toolbar = appBarLayout.findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);   //???????????????????????????????????????

        initNavigationBar();

    }

/*
    public BaseActivity() {
        initNavigationBar();
    }
*//*
    public void initFloatingActionButton() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
*/
    public void initNavigationBar() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.library) {

            Intent intent = new Intent(this, LibraryActivity.class);

            intent.putExtra("link_name", "qwertyui");

            //intent.putIntegerArrayListExtra("link_name", );
            this.startActivity(intent);
            // Handle the camera action
        } else if (id == R.id.my_library) {

            Intent intent = new Intent(this, MyLibraryActivity.class);

            intent.putExtra("link_name", "qwertyui");

            //intent.putIntegerArrayListExtra("link_name", );
            this.startActivity(intent);

        } else if (id == R.id.news) {

            Intent intent = new Intent(this, NewsActivity.class);

            intent.putExtra("link_name", "qwertyui");

            //intent.putIntegerArrayListExtra("link_name", );
            this.startActivity(intent);

        } else if (id == R.id.open_book) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}