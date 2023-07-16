package com.example.tweetapi.controller;

import com.example.tweetapi.payload.UserDTO;
import com.example.tweetapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //http://localhost:8080/api/users/create
    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody UserDTO userDTO){
        UserDTO create = userService.createNewPost(userDTO);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/users/getData
    @GetMapping("/getData")
    public List<UserDTO> getAllPost(){
      List<UserDTO> userDTOS = userService.getAll();
        return userDTOS;
    }

    //http://localhost:8080/api/users/{id}/findById
    @GetMapping("/{id}/findById")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id){
        UserDTO userDTO = userService.getById(id);
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    //http://localhost:8080/api/users/{id}/update
    @PutMapping("/{id}/update")
    public ResponseEntity<?> creatUpdate(@PathVariable(name = "id") Long id, @RequestBody UserDTO userDTO){
        UserDTO userUpdate = userService.updatePost(id,userDTO);
    return new ResponseEntity<>(userUpdate, HttpStatus.OK);
    }

    //http://localhost:8080/api/users/{id}/delete
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deletePost(@PathVariable(name = "id") Long id){
        userService.deletePost(id);
        return  new ResponseEntity<>("Post delete successfully",HttpStatus.OK);
    }
}
