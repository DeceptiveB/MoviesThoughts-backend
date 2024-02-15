package com.deceptiveb.movies.mapper.movie;

import com.deceptiveb.movies.exception.ResourceNotFoundException;
import com.deceptiveb.movies.model.Genre;
import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.payload.movie.MovieRequest;
import com.deceptiveb.movies.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Controller
public class MovieRequestMapper implements Function<MovieRequest, Movie> {
    @Autowired
    private GenreRepo genreRepo;

    @Override
    public Movie apply(MovieRequest movieRequest) {
        List<Genre> genreList = new ArrayList<Genre>();
        for (Integer id: movieRequest.genres()){
            Genre genre = genreRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", id));
            genreList.add(genre);
        }

        return new Movie(
                movieRequest.name(),
                movieRequest.argument(),
                movieRequest.director(),
                movieRequest.releaseDate(),
                genreList
        );
    }
}
