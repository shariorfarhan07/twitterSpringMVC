package com.twitter.dao;

import com.twitter.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Data
@AllArgsConstructor
public class FollowerMappingDao {
    private final String insertFollower="INSERT INTO followers_mapping(user, follower) VALUES (?,?)";
    private final String deleteFollower="DELETE FROM followers_mapping WHERE user = ? and follower = ?";
    private final String seeFollower="SELECT * FROM user WHERE follower in (SELECT follower FROM followers_mapping WHERE user = ?)";

    private final JdbcTemplate jdbcTemplate;

//    CheckFollowes(int userId){return;}
    public List<User> CheckFollowers(int userId){

        return null;
    }
//    removeFollower(int userId ,int follower)
//    boolean insertFollower(int userId ,int follower)









}
