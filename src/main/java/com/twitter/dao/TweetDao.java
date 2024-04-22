package com.twitter.dao;

import com.twitter.dto.TweetDto;
import com.twitter.entity.Tweet;
import com.twitter.entity.User;
import com.twitter.mapper.tweetMapper;
import com.twitter.mapper.userMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
@Log
public class TweetDao {
    private  final String create_tweet="INSERT INTO tweet(username, text) VALUES (?,?)";
    private  final String update_tweet="UPDATE tweet SET text=? WHERE username = ? and id = ?";
    private  final String delete_tweet="DELETE FROM tweet WHERE username = ? and id = ?";
    private  final String search_user_tweet="SELECT * FROM tweet WHERE username = ?";
    private  final String search_single_tweet="SELECT id, username, text FROM tweet WHERE id = ?";
    private  final String search_friends_tweet="SELECT t.id as id , u.username as username , t.text as text  FROM tweet t join user u on t.username = u.id  WHERE t.username in (SELECT follower FROM followers_mapping WHERE user = ?)";
    private final JdbcTemplate jdbcTemplate;
    private   List<Tweet> Search(String sql,int userId){
        log.info(sql+" "+userId);
        List<Tweet> tweets = jdbcTemplate.query(sql, new tweetMapper(), userId);
        if (tweets!=null)log.info(tweets.toString());
        return tweets;
    }
    public  List<Tweet> SearchUserTweet(int userId){
        return Search(search_user_tweet, userId);
    }
//    public  List<Tweet> searchSingleStweet(int tweetId) throws SQLException {
//        return Search(search_single_tweet,tweetId);
//    }
    public  List<Tweet> SearchFriendsAndMyTweet(int userId) throws SQLException {
        return Search(search_friends_tweet+" or t.username="+userId+" order by id DESC",userId);
    }
    public boolean create(int userId ,String tweet){
        log.info(create_tweet+" UserID: "+userId+" tweet"+tweet);
        int rowsUpdated=jdbcTemplate.update(create_tweet,userId,tweet);
        log.info("rows updated"+rowsUpdated);
        return rowsUpdated==1;
    }

    public boolean update(int tweetId, int userId, String text ){
        log.info(create_tweet+" tweetId: "+userId+" text: "+text);
        int rowsUpdated=jdbcTemplate.update(update_tweet,text,userId,tweetId);
        log.info("rows updated"+rowsUpdated);
        return rowsUpdated==1;
    }

    public boolean delete(int tweetId, int userId,String text ){
        log.info(create_tweet);
        int rowsUpdated=jdbcTemplate.update(delete_tweet,userId,tweetId);
        log.info("rows updated:"+rowsUpdated);
        return rowsUpdated==1;
    }
    public  void update(TweetDto tweetUpdate) {
        update(tweetUpdate.getId(), Integer.parseInt(tweetUpdate.getUsername()),tweetUpdate.getText());
    }

    public Tweet searchById(int tweetId) {
        return (Tweet) Search(search_single_tweet,tweetId);
    }
}
