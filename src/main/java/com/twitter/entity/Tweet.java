package com.twitter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tweet {
    int id;
    int username;
    String text;
}
