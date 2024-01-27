package com.deceptiveb.movies;

import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBInit {
    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @PostConstruct
    public void postConstruct(){
        AppUser appUser = new AppUser("deceptiveb", "deceptiveb@gmail.com");
        AppUser appUser1 = new AppUser("ddrake", "drake@hotmail.com");
        AppUser appUser2 = new AppUser("johnsmith", "jsmith@outlook.com");

    }
}
