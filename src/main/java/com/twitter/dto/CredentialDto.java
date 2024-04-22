package com.twitter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialDto {
    private String username;
    private String password;

    public boolean valid() {
        return (username!=null&&password!=null&&!username.equals("")&&!password.equals(""));
    }
}
