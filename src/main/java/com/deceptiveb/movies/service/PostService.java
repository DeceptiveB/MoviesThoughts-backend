package com.deceptiveb.movies.service;

import com.deceptiveb.movies.payload.post.PostListResponse;
import com.deceptiveb.movies.payload.post.PostResponse;

import java.util.List;

public interface PostService {

    PostResponse getPostById(Integer id);

    List<PostListResponse> getPosts(int page, int size);
}
