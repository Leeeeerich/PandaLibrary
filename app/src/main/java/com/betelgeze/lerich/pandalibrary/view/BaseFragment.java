package com.betelgeze.lerich.pandalibrary.view;

import android.arch.lifecycle.ViewModelStore;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseFragment extends Fragment {

    private RecyclerView recyclerView;
   // private RecyclerView.Adapter adapter;
   // private RecyclerView.LayoutManager layoutManager;
    private LinearLayoutManager layoutManager;

   //
    public Context context;
    public RecyclerView.Adapter adapter;

    public List<Book> bookList = new ArrayList<>();
    public String image;

    public ProgressBar progressBar;

    private RelativeLayout relativeLayout;
    public View view;
    public ViewGroup viewGroup;
    View view1;

    public BaseFragment() {
        // Required empty public constructor


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment, container, false);

        initInit();
        return view;
    }

    public void initInit() {
        context = getActivity();

/*        progressBar = new ProgressBar(context);
        progressBar = view.findViewById(R.id.progressBar);*/
        //tests();

        setupAdapter(context, bookList);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        Log.e("Hren6","qwertyuio " + context);

        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        setAdapter(context, bookList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.addOnScrollListener(
                new EndlessRecyclerViewScrollListener(layoutManager) {
                    @Override
                    public void onLoadMore(int page, int totalItemsCount) {

                        setActEndlessRVScrollListener(page, totalItemsCount);
                        //  if (page <= numberOfPages) {

                        //progressBar.setVisibility(ProgressBar.VISIBLE);
                        //listSong(keywordsSearch + Constants.ZF_FM_NEXT_PAGE + page);
                        //Log.e(LOG_TAG, "" + page + "  " + numberOfPages);

                        //  }
                    }
                }
        );
    }

    public View getView1(){
        return view1;
    }

    public ViewGroup getViewGroup() {
        return viewGroup;
    }

    public void setProgressBar(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public ProgressBar getProgressBar() {
        return progressBar;
    }

    public void setActEndlessRVScrollListener(int page, int numberOfPages) {

    }



    public void setAdapter(Context context, List<Book> bookList) {
        adapter = new BookListAdapter(context, bookList);
    }




    public List<Book> tests () {
        image = Constants.URLIMAGES;
        for (int i = 0; i <= 10; i++) {


            Book book = new Book(
                    "title " + i,
                    "urlBook " + i,
                   "author " + i,
                    "genre " + i,
                    "series " + i,
                    "years " + i,
                    "pages " + i,
                    "languages " + i,
                    "description " + i,
                    image);

            bookList.add(book);
        }



        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
        //adapter.notifyDataSetChanged();
        //recyclerView.setAdapter(Adapter);
    }

    public void updateBookList(List<Book> bookList) {
        this.bookList.addAll(bookList);
    }

    public void updateList() {
        adapter.notifyDataSetChanged();
        //recyclerView.setAdapter(adapter);
        //bookListAdapter.notifyDataSetChanged();
    }

    public void setupAdapter(Context context, List<Book> bookList) {
        if (recyclerView == null || bookList == null) {
            return;
        }

        if (this.bookList == null) {
            setAdapter(context, bookList);
            this.bookList = bookList;
            recyclerView.setAdapter(adapter);

        } else {
            this.bookList.addAll(bookList);
            adapter.notifyDataSetChanged();
        }
    }

    @Nullable
    @Override
    public Context getContext() {
        return context;
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }
}