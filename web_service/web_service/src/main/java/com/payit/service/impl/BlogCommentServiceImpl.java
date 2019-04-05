package com.payit.service.impl;

import com.payit.api.BlogComment;
import com.payit.jdbi.CommentStore;
import com.payit.service.BlogCommentService;

import javax.inject.Inject;
import java.util.List;

public class BlogCommentServiceImpl implements BlogCommentService {
    private final CommentStore commentStore;

    @Inject
    public BlogCommentServiceImpl(CommentStore commentStore) {this.commentStore = commentStore;}

    @Override
    public List<BlogComment> getAllComments() {return commentStore.getAllComments();}

    @Override
    public BlogComment getCommentById(String id) {return commentStore.getBlogCommentById(id);}

    @Override
    public  void deleteComment(String id) {commentStore.deleteBlogComment(id);}

    @Override
    public BlogComment createComment(BlogComment comment) {return commentStore.storeBlogComment(comment);}

    @Override
    public void updateComment(String id, BlogComment blogComment) {commentStore.updateBlogComment(id, blogComment);}
}
