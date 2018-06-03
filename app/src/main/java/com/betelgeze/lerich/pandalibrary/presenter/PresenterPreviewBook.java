package com.betelgeze.lerich.pandalibrary.presenter;

import android.util.Log;

import com.betelgeze.lerich.pandalibrary.model.Book;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PresenterPreviewBook {

    Book book = new Book();

    public interface Callback{
        void callingBack(Book book);
    }

    private PresenterPreviewBook.Callback callback;

    public void registerCallBack(PresenterPreviewBook.Callback callback){
        this.callback = callback;
    }


    public void getPreviewBook (String keywords) {

        Log.e("RxJavaX", "keywords: " + keywords);


        Observer<Book> observer = new Observer<Book>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("RxJavaX", "onSubscribe: ");
            }

            @Override
            public void onNext(Book value) {
                book = value;
                Log.e("RxJavaX", "onNext: " + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("RxJavaX", "onError: Names");
            }

            @Override
            public void onComplete() {
                callback.callingBack(book);
            }
        };
    }
}
