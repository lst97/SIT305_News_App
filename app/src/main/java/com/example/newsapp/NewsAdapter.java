package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder>{
    private final ArrayList<News> newsList;

    private final ClickedNewsHandler clickedNewsHandler;

    NewsAdapter(ArrayList<News> newsList, ClickedNewsHandler clickedNewsHandler){
        this.newsList = newsList;
        this.clickedNewsHandler = clickedNewsHandler;
    }

    // ViewHolder class to hold the views used in each news item
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;
        private final TextView titleTextView;
        private final TextView descriptionTextView;
        private final View cardView;


        MyViewHolder(final View view){
            super(view);
            imageView = view.findViewById(R.id.cardNewsImage);
            titleTextView = view.findViewById(R.id.cardNewsTitle);
            descriptionTextView = view.findViewById(R.id.cardNewsDescription);
            cardView = view;
        }
    }

    // Create new views (invoked by the layout manager)
    @NonNull
    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new MyViewHolder(itemView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.imageView.setImageResource(news.image);
        holder.titleTextView.setText(news.newsTitle);
        holder.descriptionTextView.setText(news.newsDescription);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewsAdapter.this.clickedNewsHandler.setNews(news);
                NewsAdapter.this.clickedNewsHandler.showNews();
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
