package com.deceptiveb.movies;

import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.model.Genre;
import com.deceptiveb.movies.model.Movie;
import com.deceptiveb.movies.model.Post;
import com.deceptiveb.movies.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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
        System.out.println("postconstruct");
        AppUser appUser = appUserRepo.save(new AppUser("deceptiveb", "deceptiveb@gmail.com"));
        AppUser appUser1 = appUserRepo.save(new AppUser("ddrake", "drake@hotmail.com"));
        AppUser appUser2 = appUserRepo.save(new AppUser("johnsmith", "jsmith@outlook.com"));

        Genre action = genreRepo.save(new Genre("Action"));
        Genre drama = genreRepo.save(new Genre("Drama"));
        Genre comedy = genreRepo.save(new Genre("Comedy"));
        Genre terror = genreRepo.save(new Genre("Terror"));
        Genre suspense = genreRepo.save(new Genre("Suspense"));
        Genre war = genreRepo.save(new Genre("War"));
        Genre adventure = genreRepo.save(new Genre("Adventure"));
        Genre history = genreRepo.save(new Genre("History"));


        Movie deadpool = movieRepo.save(new Movie(
                "Deadpool",
                "Ajax, a twisted scientist, experiments on Wade Wilson, a mercenary, to cure him of cancer and give him healing powers. However, the experiment leaves Wade disfigured and he decides to exact revenge.",
                "Tim Miller",
                LocalDate.of(2016, 2, 11),
                List.of(comedy, action)));
        Movie basterds = movieRepo.save(new Movie(
                "Inglourious Basterds",
                "A few Jewish soldiers are on an undercover mission to bring down the Nazi government and put an end to the war. Meanwhile, a woman wants to avenge the death of her family from a German officer.",
                "Quentin Tarantino",
                LocalDate.of(2009, 10, 9),
                List.of(war, adventure, drama)));
        Movie bridge = movieRepo.save(new Movie(
                "Bridge of Spies",
                "James B Donovan defends an alleged KGB spy, Rudolf Abel, in the US courts. He is eventually called upon to negotiate an exchange of Rudolf with a US pilot, Francis Powers, who was caught in the USSR.",
                "Steven Spielberg",
                LocalDate.of(2015, 10, 16),
                List.of(history, suspense, drama)));

        Post post = postRepo.save(new Post("Great movie", appUser, basterds, 9.0));
        Post post2 = postRepo.save(new Post("So funny", appUser1, deadpool, 8.5));

    }
}

