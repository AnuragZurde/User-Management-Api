package com.anu.service;

import com.anu.dto.UserDetailsDto;
import com.anu.dto.UserReqDto;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

public interface UserServiceMethods {
    UserDetailsDto getUser (Long id);

    UserDetailsDto getUserByName (String username);

    UserDetailsDto createUser (UserReqDto request);

    void deleteUserById (Long id);

    void deleteUserByUsername (String username);

    UserDetailsDto updateUser (String username,UserReqDto request);

    UserDetailsDto patchUser (String username, Map<String, Object> update);

    List<UserDetailsDto> getAllUsers ();
}
