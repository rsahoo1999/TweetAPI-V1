package com.example.tweetapi.controller;

import com.example.tweetapi.payload.TweetDTO;
import com.example.tweetapi.repository.TweetRepository;
import com.example.tweetapi.repository.UserRepository;
import com.example.tweetapi.service.TweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tweets")
public class TweetController {
    private final TweetService tweetService;
    private final TweetRepository tweetRepository;

    //Constructor based Injection
    public TweetController(TweetService tweetService, TweetRepository tweetRepository, UserRepository userRepository) {
        this.tweetService = tweetService;
        this.tweetRepository = tweetRepository;
    }
    //http://localhost:8080/api/tweets/created
    @PostMapping("/created")
    public ResponseEntity<?> createTweet(@RequestBody TweetDTO tweetDTO){
        TweetDTO saveTweet = tweetService.createNewTweet(tweetDTO);
        return new ResponseEntity<>(saveTweet, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/tweets/retrieveAll
    @GetMapping("/retrieveAll")
    public List<TweetDTO> getTweet(){
       List<TweetDTO> allTweet = tweetService.findTweet();
       return allTweet;
    }

    //http://localhost:8080/api/tweets/{id}/findById
    @GetMapping("/{userId}")
    public ResponseEntity<TweetDTO> getPostById(@PathVariable(name = "userId") Long userId){
        TweetDTO readById =  tweetService.getTweetById(userId);
        return new ResponseEntity<>(readById, HttpStatus.OK);
    }

    //http://localhost:8080/api/tweets/{id}/update
    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateTweet(@PathVariable(name = "id") Long id, @RequestBody TweetDTO tweetDTO){
        TweetDTO getUpdate = tweetService.updateTweet(id, tweetDTO);
        return new ResponseEntity<>(getUpdate, HttpStatus.CREATED);
    }

    //http://localhost:8080/api/tweets/{id}/delete
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<?> deleteById(@PathVariable(name = "id")Long id){
        tweetService.deleteTweet(id);
        return new ResponseEntity<>("Tweet Deleted", HttpStatus.OK);
    }
}
