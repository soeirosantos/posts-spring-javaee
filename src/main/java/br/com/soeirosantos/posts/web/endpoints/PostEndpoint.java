package br.com.soeirosantos.posts.web.endpoints;

import br.com.soeirosantos.posts.domain.entities.Post;
import br.com.soeirosantos.posts.services.PostService;
import java.net.URI;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Singleton
@Path("/posts")
@Produces(MediaType.APPLICATION_JSON)
public class PostEndpoint {

    private final PostService postService;

    @Inject
    public PostEndpoint(PostService postService) {
        this.postService = postService;
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    public Response get(@PathParam("id") Long id) {
        return Response.ok(postService.findOne(id).get()).build();
    }

    @GET
    public Response list() {
        return Response.ok(postService.findAll()).build();
    }

    @POST
    public Response create(Post post) {
        postService.save(post);
        URI location = UriBuilder.fromResource(PostEndpoint.class)
            .path(String.valueOf(post.getId()))
            .build();
        return Response.created(location).build();
    }

    @PUT
    @Path("/{id:[0-9][0-9]*}")
    public Response update(@PathParam("id") Long id, Post post) {
        post.setId(id);
        postService.save(post);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public Response delete(@PathParam("id") Long id) {
        postService.delete(id);
        return Response.ok().build();
    }

}
