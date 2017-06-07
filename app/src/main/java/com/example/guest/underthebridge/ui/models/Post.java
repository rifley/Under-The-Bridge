package com.example.guest.underthebridge.ui.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 6/6/17.
 */
@Parcel
public class Post {
    String title;
    String body;
    List<String> comments = new ArrayList<>();

    public Post() {}

    public Post (String title, String body) {
        this.title = title;
        this.body = body;
        this.comments = new ArrayList<>();

    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(String commentId) {
        comments.add(commentId);
    }
}