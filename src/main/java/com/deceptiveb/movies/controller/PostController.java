package com.deceptiveb.movies.controller;


import com.deceptiveb.movies.payload.post.PostListResponse;
import com.deceptiveb.movies.payload.post.PostResponse;
import com.deceptiveb.movies.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(
            @PathVariable(value = "id") Integer postid){
        return ResponseEntity.ok().body(postService.getPostById(postid));
    }

    @GetMapping
    public ResponseEntity<List<PostListResponse>> getPosts(
            @RequestParam(value = "size",
                          defaultValue = "5",
                          required = false) int size,
            @RequestParam(value = "page",
                          defaultValue = "5",
                          required = false) int page){
        System.out.println(page +""+ size);
        return ResponseEntity.ok().body(postService.getPosts(page, size));
    }
}
