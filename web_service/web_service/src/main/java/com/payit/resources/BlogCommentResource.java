package com.payit.resources;

import com.payit.api.BlogComment;
import com.payit.service.BlogCommentService;

import com.codahale.metrics.annotation.Timed;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/comments")
@Produces(MediaType.APPLICATION_JSON)
public class BlogCommentResource {
    private final BlogCommentService blogCommentService;

    @Inject
    public BlogCommentResource(BlogCommentService blogCommentService) {this.blogCommentService = blogCommentService;}

    @GET
    @Timed
    public List<BlogComment> getAllComments() {
        return blogCommentService.getAllComments(); }

    @POST
    @Timed
    public BlogComment storeBlogComment(BlogComment blogComment) {return blogCommentService.createComment(blogComment);}

    @GET
    @Path("/{commentID}")
    @Timed
    public BlogComment getBlogCommentByID(@PathParam("commentID") String commentID) {return blogCommentService.getCommentById(commentID);}

    @DELETE
    @Path("/{commentID")
    @Timed
    public void deleteBlogComment(@PathParam("commentID") String commentID) {blogCommentService.getCommentById(commentID);}

    @PUT
    @Path("/{commentID}")
    @Timed
    public void updateBlogComment(@PathParam("commentID") String commentID, BlogComment blogComment){
        blogCommentService.updateComment(commentID,blogComment);
    }

}
