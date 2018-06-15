package com.betelgeze.lerich.pandalibrary.presenter;

import android.util.Log;

import com.betelgeze.lerich.pandalibrary.Constants;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.model.library.ParserBooksNovelty;
import com.betelgeze.lerich.pandalibrary.view.BaseFragment;
import com.betelgeze.lerich.pandalibrary.view.BookListAdapter;
import com.betelgeze.lerich.pandalibrary.view.library_activity.NoveltyFrag;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PresenterLibraryNoveltyFrag {



    private List<Book> bookList = new ArrayList<>();
    ParserBooksNovelty parserBooksNovelty = new ParserBooksNovelty();

    public interface Callback{
        void callingBack(List<Book> bookList);
    }

    private Callback callback;

    public void registerCallBack(Callback callback){
        this.callback = callback;
    }


    public PresenterLibraryNoveltyFrag(){

    }

    private void getBookList (String URL){

        Observer<List<Book>> observer = new Observer<List<Book>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("RxJavaX", "onSubscribe: ");
            }

            @Override
            public void onNext(List value) {

                bookList = value;

                Log.e("RxJavaX", "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("RxJavaX", "onError: Names");
            }

            @Override
            public void onComplete() {


                callback.callingBack(bookList);
                Log.e("Pifda", " " + bookList.get(3).getUrlBook());


            }
        };
//Create our subscription//
        parserBooksNovelty.getBookNoveltyList(URL).subscribe(observer);
    }


    public List<Book> getListBook(String URL){

        getBookList(URL);
        return bookList;
    }

}
