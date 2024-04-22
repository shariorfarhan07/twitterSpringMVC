package com.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private int id;
    private String username;
    private  String password;
    private String email;

    public boolean validPayload() {
        return !(username==null||password==null||email==null||username.equals("")||password.equals("")||email.equals(""));
    }
}
