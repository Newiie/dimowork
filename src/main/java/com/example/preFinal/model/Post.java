package com.example.preFinal.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "JobPost")
public class Post {
    private int id;
    private String text;
    private ArrayList<String> replies;
    public ArrayList<String> getReplies() {
        return replies;
    }

    public void addReply(String reply) {
        if (replies == null) {
            replies = new ArrayList<>();
        }
        replies.add(reply);
    }

    public void setReplies(ArrayList<String> replies) {
        this.replies = replies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }

    public Post() {
    }
}
