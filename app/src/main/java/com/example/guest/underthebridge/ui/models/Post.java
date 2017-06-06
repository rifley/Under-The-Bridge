package com.example.guest.underthebridge.ui.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 6/6/17.
 */

public class Post {
    private String title;
    private String body;
    private List<String> comments = new ArrayList<>();

    public Post (String title, String body) {
        this.title = title;
        this.body = body;
        // TODO: 6/6/17 remember2
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