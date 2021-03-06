package com.betelgeze.lerich.pandalibrary.view.library_activity;



import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.betelgeze.lerich.pandalibrary.Constants;
import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.presenter.ListBookInterface;
import com.betelgeze.lerich.pandalibrary.presenter.PresenterLibraryNoveltyFrag;
import com.betelgeze.lerich.pandalibrary.view.BaseFragment;
import com.betelgeze.lerich.pandalibrary.view.EndlessRecyclerViewScrollListener;

import java.util.List;



public class NoveltyFrag extends BaseFragment implements PresenterLibraryNoveltyFrag.Callback {

    private int numberPage = 1;
    ProgressBar progressBar;
    PresenterLibraryNoveltyFrag presenterLibraryNoveltyFrag = new PresenterLibraryNoveltyFrag();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment, container, false);

        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        Log.e("view", "" + progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        initInit();
        return view;
    }

    public NoveltyFrag() {
        presenterLibraryNoveltyFrag.registerCallBack(this);

        presenterLibraryNoveltyFrag.getListBook(Constants.URL_NOVELTY_LITMIR + numberPage);



        //tekst();
    }


    @Override
    public void setActEndlessRVScrollListener(int page, int numberOfPages) {
        super.setActEndlessRVScrollListener(page, numberOfPages);
        numberPage++;
        progressBar.setVisibility(ProgressBar.VISIBLE);
        presenterLibraryNoveltyFrag.getListBook(Constants.URL_NOVELTY_LITMIR + numberPage);
    }

    public void tekst() {

        image = Constants.URLIMAGES;
        for (int i = 0; i <= 10; i++) {


            Book book = new Book(
                    "Заголовок " + i,
                    "Ссылка " + i,
                    "Автор " + i,
                    "Жанр " + i,
                    "Серия " + i,
                    "Год " + i,
                    "Страниц " + i,
                    "Язык " + i,
                    "Описание " + i,
                    image);

            bookList.add(book);
        }
        Log.e("Hrre ","qwertyuio " + bookList.get(2).getAuthor());
        setBookList(bookList);
        //updateList();


      //  return bookList;
    }


    @Override
    public void callingBack(List<Book> bookList) {

        setupAdapter(context, bookList);

        //progressBar.setVisibility(ProgressBar.INVISIBLE);
        //this.bookList = bookList;
        //Log.e("Hrre ","qwertyuio " + bookList.get(2).getAuthor());


        //this.updateList();
        //updateList();
    }
}
