package com.example.newsapp;

import java.util.ArrayList;

public class News{
    String newsTitle;
    String newsDescription;
    String newsDetail;
    // image id
    int image;

    // used in clicked news page
    ArrayList<News> relatedNews = new ArrayList<News>();

    News(String title, String description, String detail, int image){
        this.newsTitle = title;
        this.newsDescription = description;
        this.newsDetail = detail;
        this.image = image;
    }

    public void addRelatedNews(News news){
        relatedNews.add(news);
    }
}
