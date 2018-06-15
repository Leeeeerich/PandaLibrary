package com.betelgeze.lerich.pandalibrary.view.preview_activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.betelgeze.lerich.pandalibrary.BaseActivity;
import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.presenter.PresenterPreviewBook;
import com.betelgeze.lerich.pandalibrary.view.BookListAdapter;
import com.betelgeze.lerich.pandalibrary.view.library_activity.LibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyGenreFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyLibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyNotInterestedFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyQueueFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyReadFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyReadingFrag;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MySearchFrag;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class BookPreviewActivity extends AppCompatActivity implements PresenterPreviewBook.Callback {

    Toolbar toolbar;

    ViewPager viewPager;

    Context context;

    ContentFrameLayout contentFrameLayout;

    int position = 1;
    PresenterPreviewBook presenterPreviewBook = new PresenterPreviewBook();

    private TextView titleBook;
    private TextView author, genre, series, year, pages, languageBook, descriptionBook;
    private ImageView imageBook, imReading, imQueue, imRead, imNotInterest;
    private CardView onClickCardView, onClickReading, onClickQueue, onClickRead, onClickNotInterest;

    private Drawable drNotReading, drReading, drNotQueue, drQueue, drNotRead, drRead, drNotInterestOFF, drNotInterestON;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_book);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        contentFrameLayout = (ContentFrameLayout) findViewById(R.id.contentFrameLayout);


        initLayout();


        presenterPreviewBook.registerCallBack(this);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        //setupViewPager(viewPager);

        Intent intent = getIntent();
        String titleBookLinkName = intent.getStringExtra("link_name");
        String urlBook = intent.getStringExtra("link");
        position = intent.getIntExtra("position", 1);

        Log.e("Billion", "qwertyuiop[poiuytrewertyuio = " + urlBook);

        setTitle(titleBookLinkName);

        presenterPreviewBook.getPreviewBook(urlBook);





    }

    public void initLayout() {
        titleBook = (TextView) findViewById(R.id.titleBook);

        author = (TextView) findViewById(R.id.authorBook);
        genre = (TextView) findViewById(R.id.genreBook);
        series = (TextView) findViewById(R.id.seriesBook);
        year = (TextView) findViewById(R.id.yearBook);
        pages = (TextView) findViewById(R.id.pagesBook);
        languageBook = (TextView) findViewById(R.id.languageBook);
        descriptionBook = (TextView) findViewById(R.id.descriptionBook);
        //count = (TextView) findViewById(R.id.count);
        imageBook = (ImageView) findViewById(R.id.coverBook);

        imReading = (ImageView) findViewById(R.id.imReading);
        imQueue = (ImageView) findViewById(R.id.imQueue);
        imRead = (ImageView) findViewById(R.id.imRead);
        imNotInterest = (ImageView) findViewById(R.id.imNotInterest);

        onClickReading = (CardView) findViewById(R.id.reading);
        onClickQueue = (CardView) findViewById(R.id.queue);
        onClickRead = (CardView) findViewById(R.id.read);
        onClickNotInterest = (CardView) findViewById(R.id.notInterest);

        drNotReading = getResources().getDrawable(R.drawable.ic_not_reading_v1);
        drReading = getResources().getDrawable(R.drawable.ic_reading);
        drNotQueue = getResources().getDrawable(R.drawable.ic_not_queue);
        drQueue = getResources().getDrawable(R.drawable.ic_queue);
        drNotRead = getResources().getDrawable(R.drawable.ic_not_complete);
        drRead = getResources().getDrawable(R.drawable.ic_complete);
        drNotInterestOFF = getResources().getDrawable(R.drawable.ic_not_interest_off);
        drNotInterestON = getResources().getDrawable(R.drawable.ic_not_interest_on);

        onClickReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imReading.setImageDrawable(drReading);
            }
        });

        onClickQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imQueue.setImageDrawable(drQueue);
            }
        });

        onClickRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imRead.setImageDrawable(drRead);
            }
        });

        onClickNotInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imNotInterest.setImageDrawable(drNotInterestON);
            }
        });

    }



    public void setData(Book book) {
        titleBook.setText(book.getTitleBook());
        author.setText(book.getAuthor());
        genre.setText(book.getGenre());
        series.setText(book.getSeries());
        year.setText(book.getYear());
        pages.setText(book.getPages());
        descriptionBook.setText(book.getDescriptionBook());

        imReading.setImageDrawable(drNotReading);
        imQueue.setImageDrawable(drNotQueue);
        imRead.setImageDrawable(drNotRead);
        imNotInterest.setImageDrawable(drNotInterestOFF);


        String imageBookURL = book.getImageBook();

        Glide
                .with(this)
                .load(imageBookURL)
                .into(imageBook);
    }


    @Override
    public void callingBack(Book book) {

        Log.e("book", "  " + book.getTitleBook());
        setData(book);
        contentFrameLayout.invalidate();

    }
}
