package com.betelgeze.lerich.pandalibrary.view;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BaseFragment extends Fragment {

    private RecyclerView recyclerView;
   // private RecyclerView.Adapter adapter;
   // private RecyclerView.LayoutManager layoutManager;
    private LinearLayoutManager layoutManager;

   //
    final Context context = getActivity();
    public RecyclerView.Adapter Adapter;

    public List<Book> bookList = new ArrayList<>();



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
        final View view = inflater.inflate(R.layout.fragment, container, false);
        //final View view1 = inflater.inflate(R.layout.recycler_view, null);


        tests();
       // Log.e("Hrre ","qwertyuio " + bookList.get(2).getAuthor());


        setAdapter();



        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        Log.e("Hrre ","qwertyuio " + context);

        //recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(Adapter);
        recyclerView.setLayoutManager(layoutManager);


       // bookListAdapter.notifyDataSetChanged();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment, container, false);
        return view;
    }


    public void setAdapter() {
        Adapter = (BookListAdapter) new BookListAdapter(context, bookList);
    }

    public List<Book> tests () {
        Uri image = Uri.parse("www.litmir.me/data/Book/0/189000/189571/BC4_1490627500.jpg");
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
    }

    public void updateList() {
        recyclerView.setAdapter(Adapter);
        //bookListAdapter.notifyDataSetChanged();
    }
}