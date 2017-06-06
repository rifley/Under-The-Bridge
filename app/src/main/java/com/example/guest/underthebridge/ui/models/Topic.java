package com.example.guest.underthebridge.ui.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 6/6/17.
 */

public class Topic {
    private String title;
    private String image;
    private List<String> posts = new ArrayList<>();

    public Topic (String title, String image) {
        this.title = title;
        this.image = image;
        this.posts = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public List<String> getPosts() {
        return posts;
    }

    public void setPosts(String postId) {
        posts.add(postId);
    }
}
