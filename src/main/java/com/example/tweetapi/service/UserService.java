package com.example.tweetapi.service;

import com.example.tweetapi.payload.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createNewPost(UserDTO userDTO);

    List<UserDTO> getAll();

    UserDTO updatePost(Long id, UserDTO userDTO);

    void deletePost(Long id);

    UserDTO getById(Long id);
}

