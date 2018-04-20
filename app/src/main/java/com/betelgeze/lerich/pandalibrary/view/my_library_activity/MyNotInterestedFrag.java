package com.betelgeze.lerich.pandalibrary.view.my_library_activity;



import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;

import com.betelgeze.lerich.pandalibrary.Constants;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.view.BaseFragment;

public class MyNotInterestedFrag extends BaseFragment {

    public MyNotInterestedFrag() {
        tekst();
    }


    public void tekst() {

        try {
            image = BitmapFactory.decodeStream(Constants.URLIMAGES.openConnection() .getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
