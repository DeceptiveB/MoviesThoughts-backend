package com.deceptiveb.movies.mapper.post;

import com.deceptiveb.movies.model.Post;
import com.deceptiveb.movies.payload.post.PostResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostResponseMapper implements Function<Post, PostResponse> {
    @Override
    public PostResponse apply(Post post) {
        return new PostResponse(
                post.getId(),
                post.getContent(),
                post.getUser().getUsername(),
                post.getRate(),
                post.getMovie().getName());
    }
}
