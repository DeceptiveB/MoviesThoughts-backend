package com.deceptiveb.movies.repository;

import com.deceptiveb.movies.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {

}
