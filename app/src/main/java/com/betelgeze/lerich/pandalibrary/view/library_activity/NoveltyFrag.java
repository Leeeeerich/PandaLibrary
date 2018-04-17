package com.betelgeze.lerich.pandalibrary.view.library_activity;



import android.net.Uri;
import android.util.Log;

import com.betelgeze.lerich.pandalibrary.Constants;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.view.BaseFragment;

public class NoveltyFrag extends BaseFragment {

    public NoveltyFrag() {
        tekst();
    }


    public void tekst() {

        Uri image = Constants.URLIMAGES;
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

}
