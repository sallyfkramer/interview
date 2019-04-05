package com.payit.jdbi;

import com.payit.api.BlogComment;

import java.util.List;

public interface CommentStore {
    List<BlogComment> getAllComments();

//    List<BlogComment> getCommentsByPostId();

    BlogComment storeBlogComment(BlogComment blogComment);

    BlogComment getBlogCommentById(String id);

    void updateBlogComment(String id, BlogComment blogComment);

    void deleteBlogComment (String id);
}
