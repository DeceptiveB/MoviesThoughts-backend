package com.deceptiveb.movies.service.impl;

import com.deceptiveb.movies.exception.ResourceNotFoundException;
import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.repository.AppUserRepo;
import com.deceptiveb.movies.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import java.util.List;

public class AppUserServiceImplementation implements AppUserService {

    @Autowired
    private AppUserRepo userRepo;
    @Override
    public AppUser getUserById(Integer id) {
        return userRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Username","id",id));
    }

    @Override
    public List<AppUser> findAll(int page,int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable);
    }


}
