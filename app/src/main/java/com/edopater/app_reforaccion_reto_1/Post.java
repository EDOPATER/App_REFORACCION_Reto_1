package com.edopater.app_reforaccion_reto_1;

public class Post {
    private String userName;
    private String postTime;
    private String postContent;

    public Post(String userName, String postTime, String postContent) {
        this.userName = userName;
        this.postTime = postTime;
        this.postContent = postContent;
    }

    public String getUserName() {
        return userName;
    }

    public String getPostTime() {
        return postTime;
    }

    public String getPostContent() {
        return postContent;
    }
}