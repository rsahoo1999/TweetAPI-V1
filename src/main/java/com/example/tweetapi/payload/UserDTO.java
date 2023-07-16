package com.example.tweetapi.payload;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private Long id;
    private String postName;
    private String postContent;
    private List<TweetDTO> tweets;
}

