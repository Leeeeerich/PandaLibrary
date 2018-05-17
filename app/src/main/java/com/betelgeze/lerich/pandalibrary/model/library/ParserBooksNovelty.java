package com.betelgeze.lerich.pandalibrary.model.library;

import android.util.Log;

import com.betelgeze.lerich.pandalibrary.Constants;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.model.DownloadPage;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ParserBooksNovelty {

    private Document documentPage;
    private Elements elements;
    public String keywords = "";
    //public String url = Constants.URL_NOVELTY_LITMIR;
    public String baseURL = "https://www.litmir.me";
    public String userAgent = null;

    public List bookList = new ArrayList<>();

    public int numberOfItems = 0;


    public ParserBooksNovelty() {

    }

    /*
     *
     * Наблюдатель "Метод" возвращающий массив (список) треков
     * @param url
     * @param keywords
     * @return
     */
    public Observable getBookNoveltyList(final String URL) {

        final Observable<List<Book>> observable =
                Observable.create(new ObservableOnSubscribe<List<Book>>() {
                                      @Override
                                      public void subscribe(ObservableEmitter<List<Book>> e) throws Exception {
                                          DownloadPage downloadpage = new DownloadPage();
                                          documentPage = downloadpage.getPage(URL, keywords);
                                          bookList.clear();
                                          bookList = trackList(documentPage);
                                          e.onNext(bookList);
                                          e.onComplete();
                                      }
                                  }
                ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /*
        Метод парсинга списка треков
     */
    public List trackList(Document documentPage) {
        try {

            Elements searchContainer = documentPage.select("div [jq=\"BookList\"]");
            //  player-in-playlist-holder
            //   Elements elementsNumberOfItems = documentPage.select("b.grey");
            //    numberOfItems = Integer.parseInt(elementsNumberOfItems.text());
            //    Log.e("RxJavaX", "numberOfItems = " + numberOfItems);
            Log.d("ParserPageZFFM", "2.1 " + searchContainer);
            Elements itemBookElements = searchContainer.select("div [class=\"island\"]");
            Log.d("ParserPageZFFM", "2.2 " + itemBookElements);
            int numItemTrackElements = searchContainer.select("div [class=\"island\"]").size();
            Log.d("ParserPageZFFM", "num = " + numItemTrackElements);
            for (int i = 0; i < numItemTrackElements; i++) {
                Log.d("ParserPageZFFM", "i = " + i);

                Element itemBookElement = itemBookElements.get(i);
                //Log.d("ParserPageZFFM", "preCoverBookContainer = " + preCoverBookContainer);

                Element titleBook = itemBookElements.select("div [class=\"book_name\"]").get(i);

                Element coverBookContainer = itemBookElement.select("img").first();
                String coverBook = coverBookContainer.attr("data-src");
/*
                Element authorBook = itemBookElements.select("div [class=\"book_name\"]").get(i);
                Log.d("ParserPageZFFM", "titleBook = " + titleBook.text());
*/

                Element authorGenreSeriesComplateBookContainer = itemBookElements.select("div [class=\"desc_container\"]").get(i);
                Log.d("ParserPageZFFM", "authorGenreSeriesComplateBookContainer = " + authorGenreSeriesComplateBookContainer);

                Element authorBook = authorGenreSeriesComplateBookContainer.select("div [class=\"desc_box\"]").get(0);
                Log.d("ParserPageZFFM", "authorBook = " + authorBook.text());

                Element genre = authorGenreSeriesComplateBookContainer.select("div [class=\"desc_box\"]").get(1);
                Log.d("ParserPageZFFM", "genre = " + genre.text());

                Element series = authorGenreSeriesComplateBookContainer.select("div [class=\"desc_box\"]").get(2);
                Log.d("ParserPageZFFM", "series = " + series.text());

                Element description = itemBookElement.select("div [itemprop=\"description\"]").first();
                Log.d("ParserPageZFFM", "description = " + description.text());



               // Log.d("ParserPageZFFM", "3 = " + titleBookAndCoverContainer.text());
                Book book = new Book(
                        titleBook.text(),
                        "",
                        authorBook.text(),
                        genre.text(),
                        series.text(),
                        "",
                        "",
                        "",
                        description.text(),
                        baseURL + coverBook
                );


                //Log.d("ParserPageZFFM", "10 " + popSongs.getTrackArtist());
                bookList.add(book);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
     //   Log.d("ParserPageZFFM", "11 " + objectTrackList);
        return bookList;
    }

}
