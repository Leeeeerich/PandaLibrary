package com.betelgeze.lerich.pandalibrary.model.library;

import android.util.Log;

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

public class ParserPreviewBook {

    private Document documentPage;
    private Elements elements;
    public String keywords = "";
    //public String url = Constants.URL_NOVELTY_LITMIR;
    public String baseURL = "https://www.litmir.me";
    public String userAgent = null;

    //public List bookList = new ArrayList<>();

    private Book book;

    public int numberOfItems = 0;

    public ParserPreviewBook(){

    }

    /*
     *
     * Наблюдатель "Метод" возвращающий массив (список) треков
     * @param url
     * @param keywords
     * @return
     */
    public Observable getPreviewBook(final String URL) {

        final Observable<Book> observable =
                Observable.create(new ObservableOnSubscribe<Book>() {
                                      @Override
                                      public void subscribe(ObservableEmitter<Book> e) throws Exception {
                                          DownloadPage downloadpage = new DownloadPage();
                                          documentPage = downloadpage.getPage(URL, keywords);
                                          //bookList.clear();
                                          book = previewBook(documentPage);
                                          e.onNext(book);
                                          e.onComplete();
                                      }
                                  }
                ).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        return observable;
    }

    /*
        Метод парсинга списка треков
     */
    public Book previewBook(Document documentPage) {
        try {

            Elements searchContainer = documentPage.select("div [class=\"right_content\"]");
            Log.d("ParserPageZFFM", "Container = " + searchContainer);

            //Адрес обложки книги
            Element coverBookContainer = documentPage.select("div [jq=\"BookCover\"]").first();
            String coverBook = coverBookContainer.absUrl("src");

            //Заголовок книги
            Element titleBook = searchContainer.select("div [itemprop=\"name\"]").first();
/*
            //Автор книги
            Elements authorBook = searchContainer.select("div [itemprop=\"author\"]").next();

            //Жанры книги
            String genresBook = "";
            Elements genresBookElements = searchContainer.select("div [itemprop=\"genre\"]");
            for (int i = 0; i < genresBookElements.size(); i++) {
                if(i==0) {
                    genresBook = genresBookElements.get(i).text();
                }
                else {
                    genresBook = genresBook + ", " + genresBookElements.get(i).text();
                }
            }
*/
            //Серия книг
            String seriesBook = "";
            Elements seriesBookElements = searchContainer.select("td [class=\"bd_desc2\"]");
            Elements seriesBookElements2 = seriesBookElements.
                    select("div");
            String seriesBookElements3;
            String author = "";
            String genre = "";
            String series = "";
            String language = "";
            String pages = "";
            String year = "";
            Boolean bookOfComplete = true;

            for(int i = 0; i < seriesBookElements2.size(); i++){
                seriesBookElements3 = seriesBookElements2.get(i).text();
                if(seriesBookElements3.contains("Автор:")) author = seriesBookElements3.substring(7);
                if(seriesBookElements3.contains("Жанр:")) genre = seriesBookElements3.substring(6);
                if(seriesBookElements3.contains("Серии:")) series = seriesBookElements3.substring(7);
                if(seriesBookElements3.contains("Количество страниц:")) pages = seriesBookElements3.substring(20);
                if(seriesBookElements3.contains("Доступен ознакомительный фрагмент")) bookOfComplete = false;
                if(seriesBookElements3.contains("Язык книги:")) language = seriesBookElements3.substring(12);
                if(seriesBookElements3.contains("Год печати:")) year = seriesBookElements3.substring(12);

            }

            Elements description = searchContainer.select("div [jq=\"BookAnnotationText\"]");
            Log.d("ParserPageZFFM", "Pizdato = " + author + " " + genre + " " + series + " " + pages + " " + bookOfComplete + " " + language + " " + year);
            Log.d("ParserPageZFFM", "NumCoverBook = " + seriesBookElements.size());
            Log.d("ParserPageZFFM", "CoverBook = " + description.text());



                Book book = new Book(
                        titleBook.text(),
                        "",
                        author,
                        genre,
                        series,
                        year,
                        pages,
                        language,
                        description.text(),
                        baseURL + coverBook
                );




        }  catch (Exception e) {
            e.printStackTrace();
        }
        //   Log.d("ParserPageZFFM", "11 " + objectTrackList);
        return book;
    }

}
