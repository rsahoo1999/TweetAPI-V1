package com.example.tweetapi.service.serviceImpl;


import com.example.tweetapi.entity.User;
import com.example.tweetapi.exception.ResourceNotFoundException;
import com.example.tweetapi.payload.UserDTO;
import com.example.tweetapi.repository.UserRepository;
import com.example.tweetapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDTO createNewPost(UserDTO userDTO) {
        User saveEntity = userRepository.save(mapToUser(userDTO));
        UserDTO saveResponse = mapToDto(saveEntity);
        return saveResponse;
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepository.findAll();
        return all.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
    }

    @Override
    public UserDTO updatePost(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        User saveUpdate = userRepository.save(mapToUser(userDTO));
        return mapToDto(saveUpdate);
    }

    @Override
    public void deletePost(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        userRepository.deleteById(id);
    }

    //Convert the entity into DTO
    public UserDTO mapToDto(User user){
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    //Convert the DTO into Entity
    public User mapToUser(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return user;
    }
}

