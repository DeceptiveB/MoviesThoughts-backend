package com.deceptiveb.movies.service.impl;

import com.deceptiveb.movies.exception.ResourceNotFoundException;
import com.deceptiveb.movies.mapper.appuser.ListAppUserResponseMapper;
import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.payload.appuser.ListAppUserResponse;
import com.deceptiveb.movies.repository.AppUserRepo;
import com.deceptiveb.movies.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImplementation implements AppUserService {

    @Autowired
    private AppUserRepo userRepo;

    @Autowired
    private ListAppUserResponseMapper userMapper;

    @Override
    public AppUser getUserById(Integer id) {
        return userRepo.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Username","id",id));
    }

    @Override
    public List<ListAppUserResponse> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepo.findAll(pageable)
                .stream()
                .map(userMapper)
                .collect(Collectors.toList());
    }


}
