package com.betelgeze.lerich.pandalibrary.view.news_activity;



import android.net.Uri;
import android.util.Log;

import com.betelgeze.lerich.pandalibrary.Constants;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.model.News;
import com.betelgeze.lerich.pandalibrary.view.BaseFragment;
import com.betelgeze.lerich.pandalibrary.view.BookListAdapter;
import com.betelgeze.lerich.pandalibrary.view.NewsListAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsFrag extends BaseFragment {
    public List<News> newsList = new ArrayList<>();

    public NewsFrag() {

        tekst();
    }

    @Override
    public void setAdapter() {
        Adapter = new NewsListAdapter(getActivity(), newsList);
    }




    public void tekst() {

        Uri image = Constants.URLIMAGES;
        for (int i = 0; i <= 10; i++) {


            News news = new News(
                    "Заголовок " + i,
                    "Дата опубликования новости " + i,
                    "Ссылка " + i,
                    "Автор Новости " + i,
                    "Автор " + i,
                    "Описание " + i,
                    image);

            newsList.add(news);
        }
        //Log.e("Hrre ","qwertyuio " + bookList.get(2).getAuthor());
        //setBookList(newsList);
        //updateList();


      //  return bookList;
    }

}
