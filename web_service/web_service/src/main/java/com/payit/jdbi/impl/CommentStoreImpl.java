package com.payit.jdbi.impl;

import com.payit.api.BlogComment;
import com.payit.jdbi.CommentStore;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommentStoreImpl implements CommentStore {
    private static final Map<String, BlogComment> inMemoryStore = new HashMap<>();

    @Override
    public List<BlogComment> getAllComments() {
        return inMemoryStore.values().stream().collect(Collectors.toList());
    }

//    @Override
//    public List<BlogComment> getCommentsByPostId(){
//        return inMemoryStore.values().stream().collect(Collectors.toList());
//    }

    @Override
    public BlogComment storeBlogComment(BlogComment blogComment) {
        inMemoryStore.put(blogComment.getId(), blogComment);
        return blogComment;
    }

    @Override
    public BlogComment getBlogCommentById(String id) {
        return inMemoryStore.getOrDefault(id, null);
    }

    @Override
    public void updateBlogComment(String id, BlogComment blogComment) {
        inMemoryStore.replace(id, blogComment);
    }

    @Override
    public void deleteBlogComment(String id) {
        inMemoryStore.remove(id);
    }
}


