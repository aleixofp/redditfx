package com.fpa.softw.redditfx.models;

import java.util.List;

public class Comment {

    private String body;
    private Redditor author;
    private List<Comment> children;
    private Submission thread;

    public Comment(String body, Redditor author, Submission thread) {
        this.body = body;
        this.author = author;
        this.thread = thread;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Redditor getAuthor() {
        return author;
    }

    public void setAuthor(Redditor author) {
        this.author = author;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public Submission getThread() {
        return thread;
    }

    public void setThread(Submission thread) {
        this.thread = thread;
    }
}
