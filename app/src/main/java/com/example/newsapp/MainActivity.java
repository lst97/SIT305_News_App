package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private final ArrayList<News> newsList = new ArrayList<>();
    private RecyclerView topNewsRecyclerView;
    private RecyclerView newsRecyclerView;

    private ClickedNewsHandler clickedNewsHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.topNewsRecyclerView = findViewById(R.id.TopNewsRecyclerView);
        this.newsRecyclerView = findViewById(R.id.NewsRecyclerView);

        findViewById(R.id.clickedNewsContainer).setVisibility(View.INVISIBLE);

        setupNewsInfo();
        setupClickedNews();
        setupAdapters();
    }

    private void setupClickedNews(){
        // setup the handler.
        this.clickedNewsHandler = new ClickedNewsHandler(findViewById(R.id.MainContentConstraintLayout), findViewById(R.id.clickedNewsContainer));
    }
    private void setupNewsInfo(){
        // insert news data from resources.
        String[] newsTitle = getResources().getStringArray(R.array.news_title);
        String[] newsDescription = getResources().getStringArray(R.array.news_description);
        String[] newsDetail = getResources().getStringArray(R.array.news_detail);

        newsList.add( new News(newsTitle[0], newsDescription[0], newsDetail[0], R.drawable.microsoft));
        newsList.add( new News(newsTitle[1], newsDescription[1], newsDetail[1], R.drawable.google));
        newsList.add( new News(newsTitle[2], newsDescription[2], newsDetail[2], R.drawable.facebook));
        newsList.add( new News(newsTitle[3], newsDescription[3], newsDetail[3], R.drawable.tesla));
        newsList.add( new News(newsTitle[4], newsDescription[4], newsDetail[4], R.drawable.apple_m1));

        newsList.get(0).addRelatedNews(newsList.get(1));
        newsList.get(0).addRelatedNews(newsList.get(2));
        newsList.get(0).addRelatedNews(newsList.get(3));
        newsList.get(0).addRelatedNews(newsList.get(4));

    }

    private void setupAdapters(){
        // there are two recycler view
        // top
        TopNewsAdapter topNewsAdapter = new TopNewsAdapter(newsList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        topNewsRecyclerView.setLayoutManager(layoutManager);
        topNewsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        topNewsRecyclerView.setAdapter(topNewsAdapter);

        // all news recycler view.
        NewsAdapter newsAdapter = new NewsAdapter(newsList, this.clickedNewsHandler);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        newsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        newsRecyclerView.setAdapter(newsAdapter);
    }
}