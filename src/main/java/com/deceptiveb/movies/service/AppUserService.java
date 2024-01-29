package com.deceptiveb.movies.service;

import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.payload.appuser.ListAppUserResponse;

import java.util.List;

public interface AppUserService {
    public AppUser getUserById(Integer id);

    public List<ListAppUserResponse> findAll(int page, int size);
}
