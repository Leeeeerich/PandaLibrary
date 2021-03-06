package com.betelgeze.lerich.pandalibrary.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.betelgeze.lerich.pandalibrary.R;
import com.betelgeze.lerich.pandalibrary.model.Book;
import com.betelgeze.lerich.pandalibrary.view.preview_activities.BookPreviewActivity;
import com.betelgeze.lerich.pandalibrary.view.preview_activities.PreviewActivity;
import com.bumptech.glide.Glide;

import java.util.List;


public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.MyViewHolder> {

    private Context context;
    private List<Book> bookList;

    Bitmap mIcon_val;

    public String urlBook;
    public String titleBookLinkName = null;
    public int positionItem;

    public BookListAdapter(Context context, List<Book> bookList) {
        this.context = context;
        this.bookList = bookList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView titleBook;
        private TextView author, genre, series, year, pages, languageBook, descriptionBook;
        private ImageView imageBook, imReading, imQueue, imRead, imNotInterest;
        private CardView onClickCardView, onClickReading, onClickQueue, onClickRead, onClickNotInterest;

        private Drawable drNotReading, drReading, drNotQueue, drQueue, drNotRead, drRead, drNotInterestOFF, drNotInterestON;



        private MyViewHolder(View view) {
            super(view);


            titleBook = (TextView) view.findViewById(R.id.titleBook);

            author = (TextView) view.findViewById(R.id.authorBook);
            genre = (TextView) view.findViewById(R.id.genreBook);
            series = (TextView) view.findViewById(R.id.seriesBook);
         /*    year = (TextView) view.findViewById(R.id.yearBook);
           pages = (TextView) view.findViewById(R.id.pagesBook);
            languageBook = (TextView) view.findViewById(R.id.languageBook);*/
            descriptionBook = (TextView) view.findViewById(R.id.descriptionBook);
            //count = (TextView) view.findViewById(R.id.count);
            imageBook = (ImageView) view.findViewById(R.id.coverBook);

            imReading = (ImageView) view.findViewById(R.id.imReading);
            imQueue = (ImageView) view.findViewById(R.id.imQueue);
            imRead = (ImageView) view.findViewById(R.id.imRead);
            imNotInterest = (ImageView) view.findViewById(R.id.imNotInterest);

            onClickCardView = (CardView) view.findViewById(R.id.card_view);

            onClickReading = (CardView) view.findViewById(R.id.reading);
            onClickQueue = (CardView) view.findViewById(R.id.queue);
            onClickRead = (CardView) view.findViewById(R.id.read);
            onClickNotInterest = (CardView) view.findViewById(R.id.notInterest);

            drNotReading = view.getResources().getDrawable(R.drawable.ic_not_reading_v1);
            drReading = view.getResources().getDrawable(R.drawable.ic_reading);
            drNotQueue = view.getResources().getDrawable(R.drawable.ic_not_queue);
            drQueue = view.getResources().getDrawable(R.drawable.ic_queue);
            drNotRead = view.getResources().getDrawable(R.drawable.ic_not_complete);
            drRead = view.getResources().getDrawable(R.drawable.ic_complete);
            drNotInterestOFF = view.getResources().getDrawable(R.drawable.ic_not_interest_off);
            drNotInterestON = view.getResources().getDrawable(R.drawable.ic_not_interest_on);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_book, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Book book = bookList.get(position);
        holder.titleBook.setText(book.getTitleBook());
        holder.author.setText(book.getAuthor());
        holder.genre.setText(book.getGenre());
        holder.series.setText(book.getSeries());

        holder.imReading.setImageDrawable(holder.drNotReading);
        holder.imQueue.setImageDrawable(holder.drNotQueue);
        holder.imRead.setImageDrawable(holder.drNotRead);
        holder.imNotInterest.setImageDrawable(holder.drNotInterestOFF);

     /*   holder.year.setText(book.getYear());
        holder.pages.setText(book.getPages());
        holder.languageBook.setText(book.getLanguageBook());*/
        holder.descriptionBook.setText(book.getDescriptionBook());

        String imageBookURL = book.getImageBook();

        Glide
                .with(context)
                .load(imageBookURL)
                .into(holder.imageBook);

        //holder.imageBook.setImageBitmap(book.getImageBook());

                //holder.imageBook.setImageURI(book.getImageBookUri());


        holder.getAdapterPosition();
       // holder
        holder.onClickCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = bookList.get(position);
                //holder.titleBook.setText(book.getTitleBook());

/*
                holder.titleBook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        urlBook = bookList.get(position).getUrlBook();
                        titleBookLinkName = bookList.get(position).getTitleBook();

                        Log.d("alcash", titleBookLinkName + "   " + urlBook);

                        onPreviewActivity();
                    }
                });*/

                urlBook = bookList.get(position).getUrlBook();
                titleBookLinkName = bookList.get(position).getTitleBook();
                positionItem = position;

                Log.e ("alcash", titleBookLinkName + "   " +  urlBook);

                onPreviewActivity();
            }
        });


        holder.onClickReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                holder.imReading.setImageDrawable(holder.drReading);

                /*
                Book book = bookList.get(position);

                urlBook = bookList.get(position).getUrlBook();
                titleBookLinkName = bookList.get(position).getTitleBook();

                Log.e ("alcash", titleBookLinkName + "   " +  urlBook);*/

            }
        });

        holder.onClickQueue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.imQueue.setImageDrawable(holder.drQueue);
                /*
                Book book = bookList.get(position);

                urlBook = bookList.get(position).getUrlBook();
                titleBookLinkName = bookList.get(position).getTitleBook();

                Log.e ("alcash", titleBookLinkName + "   " +  urlBook);
*/
            }
        });

        holder.onClickRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.imRead.setImageDrawable(holder.drRead);
                /*
                Book book = bookList.get(position);

                urlBook = bookList.get(position).getUrlBook();
                titleBookLinkName = bookList.get(position).getTitleBook();

                Log.e ("alcash", titleBookLinkName + "   " +  urlBook);
*/
            }
        });

        holder.onClickNotInterest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                holder.imNotInterest.setImageDrawable(holder.drNotInterestON);
                /*
                Book book = bookList.get(position);

                urlBook = bookList.get(position).getUrlBook();
                titleBookLinkName = bookList.get(position).getTitleBook();

                Log.e ("alcash", titleBookLinkName + "   " +  urlBook);
*/
            }
        });
    }


    public void onPreviewActivity() {


        Intent intent = new Intent(context, BookPreviewActivity.class);

        intent.putExtra("link_name", titleBookLinkName);
        intent.putExtra("link", urlBook);
        intent.putExtra("position", positionItem);


        Log.e("Hren6","qwertyuio " + context);
        context.startActivity(intent);

    }
/*

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     *//*
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }*/

    @Override
    public int getItemCount() {
        return bookList.size();
    }
}


