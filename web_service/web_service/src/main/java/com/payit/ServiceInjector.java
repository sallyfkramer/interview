package com.payit;

import com.payit.jdbi.BlogStore;
import com.payit.jdbi.CommentStore;
import com.payit.jdbi.impl.BlogStoreImpl;
import com.payit.jdbi.impl.CommentStoreImpl;
import com.payit.service.BlogCommentService;
import com.payit.service.BlogPostService;
import com.payit.service.impl.BlogCommentServiceImpl;
import com.payit.service.impl.BlogPostServiceImpl;

import com.google.inject.AbstractModule;

public class ServiceInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(BlogPostService.class).to(BlogPostServiceImpl.class);
        bind(BlogStore.class).to(BlogStoreImpl.class);


        bind(BlogCommentService.class).to(BlogCommentServiceImpl.class);
        bind(CommentStore.class).to(CommentStoreImpl.class);
    }
}
