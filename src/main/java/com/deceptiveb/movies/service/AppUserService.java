package com.deceptiveb.movies.service;

import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.payload.appuser.ListAppUserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppUserService {
    public AppUser getUserById(Integer id);

    public List<ListAppUserResponse> findAll(int page, int size);
}
