package com.betelgeze.lerich.pandalibrary.view;

import android.content.Context;
import android.content.Intent;
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
import com.betelgeze.lerich.pandalibrary.model.News;
import com.betelgeze.lerich.pandalibrary.view.preview_activities.NewsPreviewActivity;
import com.bumptech.glide.Glide;

import java.util.List;


public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {

    private Context context;
    private List<News> newsList;

    public String urlNews;
    public String titleNewsLinkName = null;

    public NewsListAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView authorNews, author, dateNews, description;
        public ImageView coverNews;
        private CardView onClickCardView;



        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.titleNews);

            //authorNews = (TextView) view.findViewById(R.id.);
            //author = (TextView) view.findViewById(R.id.);
            //dateNews = (TextView) view.findViewById(R.id.);
            description = (TextView) view.findViewById(R.id.descriptionNews);
            coverNews = (ImageView) view.findViewById(R.id.coverNews);

            onClickCardView = (CardView) view.findViewById(R.id.card_view);
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_news, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        News news = newsList.get(position);
        holder.title.setText(news.getTitle());
        //holder.authorNews.setText(news.getAuthorNews());
        //holder.author.setText(news.getAuthor());
        //holder.dateNews.setText(news.getDateNews());
        holder.description.setText(news.getDescription());

        String imageBookURL = news.getImage();

        Glide
                .with(context)
                .load(imageBookURL)
                .into(holder.coverNews);

        //holder.coverNews.setImageBitmap(news.getImage());

        holder.onClickCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                News news = newsList.get(position);
               // holder.title.setText(news.getTitle());
/*
                holder.title.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        urlNews = newsList.get(position).getUrl();

                        onPreviewActivity();

                        Log.d("alcash", urlNews);
                    }
                });
*/
                urlNews = newsList.get(position).getUrl();
                titleNewsLinkName = newsList.get(position).getTitle();

                onPreviewActivity();

                Log.d ("alcash", urlNews);
            }
        });
    }


    public void onPreviewActivity() {

        Intent intent = new Intent(context, NewsPreviewActivity.class);

        intent.putExtra("link_name", titleNewsLinkName);
        intent.putExtra("link", urlNews);

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
        return newsList.size();
    }
}
