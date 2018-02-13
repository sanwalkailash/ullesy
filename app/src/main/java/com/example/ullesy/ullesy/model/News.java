package com.example.ullesy.ullesy.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kailash on 15/2/18.
 */

public class News {
    @SerializedName("title")
    private String newsTitle;

    @SerializedName("id")
    private long newsId;
    @SerializedName("hyperlink")
    private String newsHyperlink;
    @SerializedName("category")
    private String newsCategory;
    @SerializedName("pubDate")
    private String newsPubDate;
    @SerializedName("timezone")
    private String newsTimezone;
    @SerializedName("createdAt")
    private String newsCreatedAt;
    @SerializedName("description")
    private String newsDescription;
    @SerializedName("guid")
    private String newsGuid;

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public String getNewsHyperlink() {
        return newsHyperlink;
    }

    public void setNewsHyperlink(String newsHyperlink) {
        this.newsHyperlink = newsHyperlink;
    }

    public String getNewsCategory() {
        return newsCategory;
    }

    public void setNewsCategory(String newsCategory) {
        this.newsCategory = newsCategory;
    }

    public String getNewsPubDate() {
        return newsPubDate;
    }

    public void setNewsPubDate(String newsPubDate) {
        this.newsPubDate = newsPubDate;
    }

    public String getNewsTimezone() {
        return newsTimezone;
    }

    public void setNewsTimezone(String newsTimezone) {
        this.newsTimezone = newsTimezone;
    }

    public String getNewsCreatedAt() {
        return newsCreatedAt;
    }

    public void setNewsCreatedAt(String newsCreatedAt) {
        this.newsCreatedAt = newsCreatedAt;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewsGuid() {
        return newsGuid;
    }

    public void setNewsGuid(String newsGuid) {
        this.newsGuid = newsGuid;
    }
}
