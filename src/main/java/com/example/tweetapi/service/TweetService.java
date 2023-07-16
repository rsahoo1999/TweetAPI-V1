package com.example.tweetapi.service;

import com.example.tweetapi.payload.TweetDTO;

import java.util.List;

public interface TweetService {
    TweetDTO createNewTweet(TweetDTO tweetDTO);

    List<TweetDTO> findTweet();

    TweetDTO updateTweet(Long id, TweetDTO tweetDTO);

    void deleteTweet(Long id);

   TweetDTO getTweetById(Long id);
}
