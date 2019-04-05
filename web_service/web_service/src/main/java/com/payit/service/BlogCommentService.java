package com.payit.service;

import com.payit.api.BlogComment;

import java.util.List;

public interface BlogCommentService {
    List<BlogComment> getAllComments();

//    List<BlogComment> getCommentsByPostId();

    BlogComment getCommentById(String id);

    void deleteComment(String id);

    BlogComment createComment (BlogComment comment);

    void updateComment(String id, BlogComment comment);
}
