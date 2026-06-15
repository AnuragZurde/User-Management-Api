package com.anu.controller;

import com.anu.dto.UserDetailsDto;
import com.anu.dto.UserReqDto;
import com.anu.service.UserServiceMethods;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceMethods userServiceMethods;

    @GetMapping("/id/{id}")
    public ResponseEntity<UserDetailsDto> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userServiceMethods.getUser(id));
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserDetailsDto> getUserByName(@PathVariable String username){
        return ResponseEntity.ok(userServiceMethods.getUserByName(username));
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDetailsDto>> getAllUsers(){
        return ResponseEntity.ok(userServiceMethods.getAllUsers());
    }

    @PostMapping()
    public ResponseEntity<UserDetailsDto> createUser(@RequestBody UserReqDto request){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceMethods.createUser(request));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userServiceMethods.deleteUserById(id);
        return ResponseEntity.ok("User Details has Deleted Successfully");
    }

    @DeleteMapping("/username/{username}")
    public ResponseEntity<String> deleteUserById(@PathVariable String username){
        userServiceMethods.deleteUserByUsername(username);
        return ResponseEntity.ok("User Details has Deleted Successfully");
    }

    @PutMapping("/{username}")
    public ResponseEntity<UserDetailsDto> updateUser(@PathVariable String username,@RequestBody UserReqDto request){
        return ResponseEntity.ok(userServiceMethods.updateUser(username,request));
    }

    @PatchMapping("/{username}")
    public ResponseEntity<UserDetailsDto> patchUser(@PathVariable String username,@RequestBody Map<String ,Object> update){
        return ResponseEntity.ok(userServiceMethods.patchUser(username,update));
    }
}
