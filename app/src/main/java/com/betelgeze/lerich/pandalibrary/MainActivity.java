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
import android.widget.ProgressBar;

import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.model.library.ParserBooksNovelty;
import com.betelgeze.lerich.pandalibrary.model.library.ParserPreviewBook;

import com.betelgeze.lerich.pandalibrary.view.library_activity.LibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyLibraryActivity;
import com.betelgeze.lerich.pandalibrary.view.my_library_activity.MyReadingFrag;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;


public class MainActivity extends BaseActivity {

    ParserPreviewBook parserPreviewBook = new ParserPreviewBook();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       //listBook("https://www.litmir.me/bd/?b=42");
       // pKromeProgressBar = (PKromeProgressBar) findViewById(R.id.pkProgressBar);



        //onLibraryActivity();


    }

    private void listBook (String keywords){

        Log.e("RxJavaX", "keywords: " + keywords);


        Observer<Book> observer = new Observer<Book>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("RxJavaX", "onSubscribe: ");
            }

            @Override
            public void onNext(Book value) {

                Log.e("RxJavaX", "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("RxJavaX", "onError: Names");
            }

            @Override
            public void onComplete() {

            }
        };
//Create our subscription//
        parserPreviewBook.getPreviewBook(keywords).subscribe(observer);
    }

    public void onLibraryActivity() {


        Intent intent = new Intent(this, LibraryActivity.class);


        intent.putExtra("link_name", "qwertyui");


        //intent.putIntegerArrayListExtra("link_name", );
        this.startActivity(intent);
    }
}
