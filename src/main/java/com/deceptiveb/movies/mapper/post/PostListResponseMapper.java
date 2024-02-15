package com.deceptiveb.movies.mapper.post;

import com.deceptiveb.movies.model.Post;
import com.deceptiveb.movies.payload.post.PostListResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostListResponseMapper implements Function<Post, PostListResponse> {
    @Override
    public PostListResponse apply(Post post) {
        return new PostListResponse(
                post.getId(),
                post.getUser().getUsername(), post.getRate(),
                post.getMovie().getName());
    }
}
