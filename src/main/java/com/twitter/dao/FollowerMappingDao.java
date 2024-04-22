package com.twitter.dao;

import com.twitter.dto.UserDto;
import com.twitter.entity.User;
import com.twitter.mapper.userMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Log
@AllArgsConstructor
public class FollowerMappingDao {
    private final String insertFollower="INSERT INTO followers_mapping(user, follower) VALUES (?,?)";
    private final String deleteFollower="DELETE FROM followers_mapping WHERE user = ? and follower = ?";
    private final String seeFollower="SELECT * FROM user WHERE follower in (SELECT follower FROM followers_mapping WHERE user = ?)";

    private final JdbcTemplate jdbcTemplate;

    public List<User> getFollowers(int userId){
        return jdbcTemplate.query(seeFollower, new userMapper(), userId);
    }

    public void follow(int userid, int userTofollow) {
        log.info(insertFollower+" "+userid+" "+userTofollow);
        jdbcTemplate.update(insertFollower,userid,userTofollow);
    }


    public void remove(int userid, int userToUnfollow) {
        log.info(insertFollower+" "+userid+" "+userToUnfollow);
        jdbcTemplate.update(deleteFollower,userid,userToUnfollow);
    }

}
