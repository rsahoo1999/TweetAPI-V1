package com.example.tweetapi.payload;

import lombok.Data;

import java.util.Date;
@Data
public class TweetDTO {
    private Long id;
    private String content;
    private Date timestamp;
    private Long userId;

}

