package com.twitter.mapper;

import com.twitter.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class userMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            int id= rs.getInt("id");
            String username= rs.getString("username");
            String password= rs.getString("password");
            String email= rs.getString("email");
            User user = new User(id,username,password,email);
        return user;
    }
}
