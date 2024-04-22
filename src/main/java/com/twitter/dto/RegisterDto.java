package com.twitter.dto;

import com.twitter.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterDto {
    private String username;
    private String password;
    private String email;

    public User toUser(){
        return new User(0,username,password,email);
    }


}
