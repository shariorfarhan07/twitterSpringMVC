package com.twitter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserDto {
    private int userId;
    private String userName;
    private String password;
    private String email;
}
