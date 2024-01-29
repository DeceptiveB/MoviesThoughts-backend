package com.deceptiveb.movies.service.impl;

import com.deceptiveb.movies.exception.ResourceNotFoundException;
import com.deceptiveb.movies.mapper.movie.ListMovieResponseMapper;
import com.deceptiveb.movies.mapper.movie.MovieResponseMapper;
import com.deceptiveb.movies.payload.movie.ListMovieResponse;
import com.deceptiveb.movies.payload.movie.MovieResponse;
import com.deceptiveb.movies.repository.MovieRepo;
import com.deceptiveb.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImplementation implements MovieService {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private MovieResponseMapper movieResponseMapper;

    @Autowired
    private ListMovieResponseMapper listMovieResponseMapper;

    @Override
    public List<ListMovieResponse> getMovies(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return movieRepo.findAll(pageable)
                .stream()
                .map(listMovieResponseMapper)
                .collect(Collectors.toList());
    }

    @Override
    public MovieResponse getMovieById(Integer id) {
        return movieRepo.findById(id)
                .map(movieResponseMapper)
                .orElseThrow(()
                        -> new ResourceNotFoundException("movie", "id", id));
    }
}
