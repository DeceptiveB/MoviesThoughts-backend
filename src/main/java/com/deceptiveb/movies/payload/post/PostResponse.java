package com.deceptiveb.movies.payload.post;

public record PostResponse(
        Integer id,
        String content,
        String appUser,
        Double rate,
        String movie
) {
}
