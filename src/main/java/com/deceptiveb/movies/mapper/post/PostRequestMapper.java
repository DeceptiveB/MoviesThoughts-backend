package com.deceptiveb.movies.mapper.post;

import com.deceptiveb.movies.exception.ResourceNotFoundException;
import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.model.Post;
import com.deceptiveb.movies.payload.post.PostRequest;
import com.deceptiveb.movies.repository.AppUserRepo;
import com.deceptiveb.movies.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PostRequestMapper implements Function<PostRequest, Post> {
    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public Post apply(PostRequest postRequest) {
        Movie movie = movieRepo.findById(postRequest.movieId())
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "Id", postRequest.movieId()));
        AppUser appUser = appUserRepo.findById(postRequest.userId())
                .orElseThrow(() -> new ResourceNotFoundException("AppUser", "Id", postRequest.userId()));
        return new Post(postRequest.content(),
                        appUser,
                        movie,
                        postRequest.rate());
    }
}
