package com.example.tweetapi.repository;

import com.example.tweetapi.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    // You can add custom query methods here if needed
}

