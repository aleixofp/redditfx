package com.fpa.softw.redditfx.models;

import java.util.List;

public class Submission {

    private String subreddit;
    private String title;
    private String url;
    private String shortLink;
    private List<Comment> topLevelComments;

    public Submission(String subreddit, String title, String url, String shortLink){
        this.subreddit = subreddit;
        this.title = title;
        this.url = url;
        this.shortLink = shortLink;
    }

    public List<Comment> getTopLevelComments(){
        return this.topLevelComments;
    }

    public String getSubreddit(){
        return this.subreddit;
    }

    public void setSubreddit(String subreddit){
        this.subreddit = subreddit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortlink() {
        return shortLink;
    }

    public void setShortlink(String shortLink) {
        this.shortLink = shortLink;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
