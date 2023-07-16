package com.example.tweetapi.service.serviceImpl;

import com.example.tweetapi.entity.Tweet;
import com.example.tweetapi.exception.ResourceNotFoundException;
import com.example.tweetapi.payload.TweetDTO;
import com.example.tweetapi.repository.TweetRepository;
import com.example.tweetapi.service.TweetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TweetServiceImpl implements TweetService {
    private final TweetRepository tweetRepository;
    private final ModelMapper modelMapper;

    public TweetServiceImpl(TweetRepository tweetRepository, ModelMapper modelMapper) {
        this.tweetRepository = tweetRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TweetDTO createNewTweet(TweetDTO tweetDTO) {
        Tweet tweet = mapToEntity(tweetDTO);
        tweet.setTimestamp(new Date());
        Tweet saveEntity = tweetRepository.save(tweet);
        return mapToDTO(saveEntity);
    }

    @Override
    public List<TweetDTO> findTweet() {
        List<Tweet> all = tweetRepository.findAll();
        return all.stream().map(tweet -> mapToDTO(tweet)).collect(Collectors.toList());
    }

    @Override
    public TweetDTO getTweetById(Long id) {
        Tweet tweet = tweetRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id)
        );
        return mapToDTO(tweet);
    }

    @Override
    public TweetDTO updateTweet(Long id, TweetDTO tweetDTO) {
        tweetRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        Tweet tweetUpdated = mapToEntity(tweetDTO);
        tweetUpdated.setTimestamp(new Date());
        Tweet updateSave = tweetRepository.save(tweetUpdated);
        return mapToDTO(updateSave);
    }

    @Override
    public void deleteTweet(Long id) {
        tweetRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException(id));
        tweetRepository.deleteById(id);
    }

    //Conversion between DTO to Entity
    public Tweet mapToEntity(TweetDTO tweetDTO){
        Tweet mapEntity = modelMapper.map(tweetDTO, Tweet.class);
        return mapEntity;
    }

    //Conversion between Entity to DTO
    public TweetDTO mapToDTO(Tweet tweet){
        TweetDTO mapDTO = modelMapper.map(tweet, TweetDTO.class);
        return mapDTO;
    }
}
