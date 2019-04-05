package com.payit.api;

import java.util.Date;
import java.util.UUID;

public class BlogComment {
    private String id = UUID.randomUUID().toString();
    private String author;
    private String commentText;
    private Date commentDate;
    private String blogPostId;

    public BlogComment(String id, String author, String commentText, Date commentDate, String blogPostId){
        this.id=id;
        this.author=author;
        this.commentText=commentText;
        this.commentDate=commentDate;
        this.blogPostId=blogPostId;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getAuthor() { return author; }

    public void setAuthor(String author) { this.author = author; }

    public String getCommentText() { return commentText; }

    public void setCommentText(String commentText) { this.commentText = commentText; }

    public Date getCommentDate() { return commentDate; }

    public void setCommentDate(Date commentDate) { this.commentDate = commentDate; }

    public String getBlogPostId() { return blogPostId; }

    public void setBlogPostId(String blogPostId) { this.blogPostId = blogPostId; }
}
