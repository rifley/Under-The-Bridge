package com.example.guest.underthebridge.ui.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 6/6/17.
 */

@Parcel
public class Topic {
    String title;
    String image;
    List<String> posts = new ArrayList<>();
    String topicNodeId;


    public Topic() {}

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

    public void setId(String id) {
        this.topicNodeId = id;
    }
}
