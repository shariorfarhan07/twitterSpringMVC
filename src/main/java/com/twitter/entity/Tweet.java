package com.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tweet {
    int id;
    String username;
    String text;
}
