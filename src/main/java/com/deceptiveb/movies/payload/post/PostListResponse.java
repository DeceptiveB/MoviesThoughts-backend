package com.deceptiveb.movies.payload.post;

public record PostListResponse (
        Integer id,
        String appUser,
        Double rate,
        String movie
){
}
