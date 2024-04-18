package com.twitter.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Followers_mapping {
    int id;
    int user;
    int follower;
}
