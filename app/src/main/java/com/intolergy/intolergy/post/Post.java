package com.intolergy.intolergy.post;

public class Post {
    int id;
    String title;
    String body;
    String user;
    String image;

    public Post(int id,String title, String body, String user, String image){
        this.id=id;
        this.title=title;
        this.body=body;
        this.user=user;
        this.image=image;
    }
}
