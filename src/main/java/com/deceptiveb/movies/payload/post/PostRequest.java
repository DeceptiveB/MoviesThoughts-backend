package com.deceptiveb.movies.payload.post;

public record PostRequest(
        Integer userId,
        Integer movieId,
        String content,
        double rate
) {

}
