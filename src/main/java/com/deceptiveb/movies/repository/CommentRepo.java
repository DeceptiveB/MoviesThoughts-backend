package com.deceptiveb.movies.repository;

import com.deceptiveb.movies.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
