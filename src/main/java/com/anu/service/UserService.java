package com.anu.service;

import com.anu.dto.UserDetailsDto;
import com.anu.dto.UserReqDto;
import com.anu.entity.User;
import com.anu.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceMethods{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDetailsDto getUser (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalStateException("User Not Found With UserId" + id));

        return modelMapper.map(user, UserDetailsDto.class);
    }

    @Override
    public UserDetailsDto getUserByName (String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalStateException("User Not Found With this Username " + username));

        return modelMapper.map(user, UserDetailsDto.class);
    }

    @Override
    public UserDetailsDto createUser (UserReqDto request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()){
            throw new IllegalArgumentException("User Already Present With this Username:" + request.getUsername());
        }

        User user = modelMapper.map(request, User.class);

        User newUser = userRepository.save(user);

        return modelMapper.map(newUser, UserDetailsDto.class);
    }

    @Override
    @Transactional
    public void deleteUserById (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("User Not Found."));

        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteUserByUsername (String username) {
    User user = userRepository.findByUsername(username)
            .orElseThrow(()-> new IllegalArgumentException("User Not Found with this username " + username));

        userRepository.delete(user);
    }

    @Override
    @Transactional
    public UserDetailsDto updateUser (String username,UserReqDto request) {
       User user = userRepository.findByUsername(username)
               .orElseThrow(()-> new IllegalArgumentException("User not Found with username "+ username));

       modelMapper.map(request, User.class);

        User newUser = userRepository.save(user);

        return modelMapper.map(newUser, UserDetailsDto.class);
    }

    @Override
    @Transactional
    public UserDetailsDto patchUser (String username, Map<String, Object> update) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new IllegalArgumentException("User Not Found with this username " + username));

        update.forEach((field,data)->{
            switch (field){
                case "username" -> user.setUsername((String) data);
                case "password" -> user.setPassword((String) data);
                case "email" -> user.setEmail((String) data);

                default ->
                    throw new IllegalArgumentException("Invalid Input type");

            }
        });

        User newUser = userRepository.save(user);
        return modelMapper.map(newUser, UserDetailsDto.class);
    }

    @Override
    public List<UserDetailsDto> getAllUsers () {
        List<User> userList = userRepository.findAll();
        return userList.stream().map(temp -> modelMapper.map(temp, UserDetailsDto.class)).toList();
    }
}
