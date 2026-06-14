package com.anu.controller;

import com.anu.dto.UserDetailsDto;
import com.anu.service.UserServiceMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceMethods userServiceMethods;

    @GetMapping("/id")
    public ResponseEntity<UserDetailsDto>
}
