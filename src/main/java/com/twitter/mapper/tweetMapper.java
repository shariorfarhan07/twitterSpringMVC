package com.twitter.mapper;

import com.twitter.entity.Tweet;
import com.twitter.entity.User;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class tweetMapper  implements RowMapper<Tweet> {
    @Override
    public Tweet mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id=rs.getInt("id");
        int username=rs.getInt("username");
        String text=rs.getString("");
        return new Tweet(id,username,text);
    }
}
