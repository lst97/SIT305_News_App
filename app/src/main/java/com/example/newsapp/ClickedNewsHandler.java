package com.example.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.Random;


// class for hidden the main activity and show the clicked news.
public class ClickedNewsHandler {
    // clicked news
    News currentNews;
    News relatedNews;
    ConstraintLayout clickedNewsConstraint;
    ConstraintLayout mainConstraint;


    ClickedNewsHandler(View mainView, View clickedView){
        this.clickedNewsConstraint = clickedView.findViewById(R.id.clickedNewsContainer);
        this.mainConstraint = mainView.findViewById(R.id.MainContentConstraintLayout);
    }

    public void setNews(News news){
        // SELECTED NEWS
        ImageView clickedImage = clickedNewsConstraint.findViewById(R.id.clickedImageView);
        clickedImage.setImageResource(news.image);
        TextView clickedNewsTitle = clickedNewsConstraint.findViewById(R.id.clickedImageTitleText);
        clickedNewsTitle.setText(news.newsTitle);
        TextView clickedNewsDetail = clickedNewsConstraint.findViewById(R.id.clickedImageDetailText);
        clickedNewsDetail.setText(news.newsDetail);

        // NO RELATED NEWS
        if(news.relatedNews.size() == 0){
            clickedNewsConstraint.findViewById(R.id.relatedNewsLayout).setVisibility(View.INVISIBLE);
            return;
        }

        // use random such that
        // only ONE related news can be selected
        this.currentNews = news;
        Random random = new Random();

        int newsIndex = random.nextInt(news.relatedNews.size());
        this.relatedNews = news.relatedNews.get(newsIndex);

        ImageView relatedImage = clickedNewsConstraint.findViewById(R.id.relatedImageView);
        relatedImage.setImageResource(this.relatedNews.image);
        TextView relatedNewsTitle = clickedNewsConstraint.findViewById(R.id.relatedTitleText);
        relatedNewsTitle.setText(this.relatedNews.newsTitle);
        TextView relatedNewsDescription = clickedNewsConstraint.findViewById(R.id.relatedDescription);
        relatedNewsDescription.setText(this.relatedNews.newsDescription);
    }

    public void showNews(){
        this.clickedNewsConstraint.setVisibility(View.VISIBLE);
        this.hideMain();
    }

    public void hideMain(){
        this.mainConstraint.setVisibility(View.INVISIBLE);
    }
}
