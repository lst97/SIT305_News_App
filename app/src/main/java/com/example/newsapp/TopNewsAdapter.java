package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopNewsAdapter extends RecyclerView.Adapter<TopNewsAdapter.MyViewHolder> {
    private final ArrayList<News> newsList;

    //
    TopNewsAdapter(ArrayList<News> newsList){
        this.newsList = newsList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private final ImageView imageView;

        MyViewHolder(final View view){
            super(view);
            imageView = view.findViewById(R.id.topNewsImageView);
        }
    }
    @NonNull
    @Override
    public TopNewsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_pictures, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TopNewsAdapter.MyViewHolder holder, int position) {
        News news = newsList.get(position);
        holder.imageView.setImageResource(news.image);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}
