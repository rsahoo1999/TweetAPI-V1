package com.example.tweetapi.payload;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String tweet;
    private List<TweetDTO> tweets;
}

