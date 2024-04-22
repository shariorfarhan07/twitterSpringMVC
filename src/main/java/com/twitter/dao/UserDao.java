package com.twitter.dao;

import com.twitter.dto.UserDto;
import com.twitter.entity.User;
import com.twitter.mapper.userMapper;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@Log
@AllArgsConstructor
public class UserDao {
    private  final String  get_user_with_userName="SELECT * FROM user WHERE username=?";
    private  final String  search_user_with_userName="SELECT * FROM user WHERE username = ?";
    private  final String  create_user="INSERT INTO user(username, password,email) VALUES (?,?,?)";
    private  final String  getFollowers="SELECT * FROM user WHERE id in (select follower From followers_mapping where user = ?)";
    private  final String  getUserToFollow="SELECT * FROM user WHERE id not in (select follower From followers_mapping where user = ?) and id != ?";
    private final JdbcTemplate jdbcTemplate;

    public User search(String userName){
        log.info(search_user_with_userName);
        User user =null;
        try {
            user = jdbcTemplate.queryForObject(search_user_with_userName, new userMapper(), userName);
            log.info(user.toString());
        }catch (EmptyResultDataAccessException e){
            log.warning("no data found for the user "+userName);
        }
        return user;
    }
    public  boolean create(String userName, String password, String email){
        log.info(create_user);
        int rowsUpdated=jdbcTemplate.update(create_user,userName,password,email);
        if (rowsUpdated==1)log.info("user was created");

        return rowsUpdated==1;
    }
    public boolean duplicate(String userName){
        log.info(create_user);
        int rowsUpdated=jdbcTemplate.update(search_user_with_userName,userName);
        log.info(create_user);
        return rowsUpdated==1;
    }

    public List<User> getFollowersById(int userid){
        log.info(search_user_with_userName);
        List<User> user = jdbcTemplate.query(getFollowers, new userMapper(), userid);
        log.info(user.toString());
        return user;
    }




    public List<User> getUserWhoDidntFollow(int userid) {
        log.info(search_user_with_userName);
        List<User> user = jdbcTemplate.query(getUserToFollow, new userMapper(), userid,userid);
        log.info(user.toString());
        return user;
    }
}
