package com.twitter.dto;

import lombok.Data;

@Data
public class UserDto {
    private int userId;
    private String userName;
    private String password;
    private String email;
}
