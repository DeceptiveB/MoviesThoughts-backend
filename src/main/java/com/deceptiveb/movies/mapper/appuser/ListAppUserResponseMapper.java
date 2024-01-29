package com.deceptiveb.movies.mapper.appuser;

import com.deceptiveb.movies.model.AppUser;
import com.deceptiveb.movies.payload.appuser.ListAppUserResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ListAppUserResponseMapper implements Function<AppUser, ListAppUserResponse> {
    @Override
    public ListAppUserResponse apply(AppUser appUser) {
        return new ListAppUserResponse(
                appUser.getId(),
                appUser.getUsername()
        );
    }
}
