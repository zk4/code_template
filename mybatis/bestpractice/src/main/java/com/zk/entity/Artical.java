package com.zk.entity;

public class Artical {
    String aid;
    String content;
    Blog blog;

    public String getAid() {
        return aid;
    }

    public Artical setAid(String aid) {
        this.aid = aid;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Artical setContent(String content) {
        this.content = content;
        return this;
    }

    public Blog getBlog() {
        return blog;
    }

    public Artical setBlog(Blog blog) {
        this.blog = blog;
        return this;
    }

    @Override
    public String toString() {
        return "Artical{" +
                "aid='" + aid + '\'' +
                ", content='" + content + '\'' +
                ", blog=" + blog +
                '}';
    }
}
