package com.fpa.softw.redditfx.models;

import java.util.List;

public class Subreddit {

    private String name;
    private String id;
    private List<Submission> submissions;

    public Subreddit(String name, String id){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

}
