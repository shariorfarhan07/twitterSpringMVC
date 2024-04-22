package com.twitter.service;

import com.twitter.dao.TweetDao;
import com.twitter.dto.TweetDto;
import com.twitter.entity.Tweet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class TweetService {
    private final TweetDao tweetDao;
    public List<Tweet> SearchFriendsAndMyTweet(int userid) {
        try {
            return tweetDao.SearchFriendsAndMyTweet(userid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Tweet searchTweetById(int id) {
        return tweetDao.searchById(id);
    }
}
