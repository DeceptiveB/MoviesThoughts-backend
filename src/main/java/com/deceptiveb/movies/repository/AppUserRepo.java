package com.deceptiveb.movies.repository;

import com.deceptiveb.movies.model.AppUser;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, Integer> {

    Optional<AppUser> findByUsername(String username);

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    //Page<AppUser> findAll(Pageable pageable)
}
