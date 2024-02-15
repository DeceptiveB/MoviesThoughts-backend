package com.deceptiveb.movies.service.impl;

import com.deceptiveb.movies.exception.ResourceNotFoundException;
import com.deceptiveb.movies.mapper.post.PostListResponseMapper;
import com.deceptiveb.movies.mapper.post.PostResponseMapper;
import com.deceptiveb.movies.payload.post.PostListResponse;
import com.deceptiveb.movies.payload.post.PostResponse;
import com.deceptiveb.movies.repository.PostRepo;
import com.deceptiveb.movies.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImplementation implements PostService {

    private PostRepo postRepo;

    private PostResponseMapper postResponseMapper;
    private PostListResponseMapper postListResponseMapper;

    @Autowired
    public PostServiceImplementation(
            PostRepo postRepo,
            PostResponseMapper postResponseMapper,
            PostListResponseMapper postListResponseMapper) {
        this.postRepo = postRepo;
        this.postResponseMapper = postResponseMapper;
        this.postListResponseMapper = postListResponseMapper;
    }
    @Override
    public PostResponse getPostById(Integer id) {
        return postRepo.findById(id)
                .map(postResponseMapper)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "Id", id));
    }

    @Override
    public List<PostListResponse> getPosts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepo.findAll(pageable)
                .stream().map(postListResponseMapper)
                .collect(Collectors.toList());
    }


}
