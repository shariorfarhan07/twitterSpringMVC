package com.twitter.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TweetDto {
    private int id;
    private String username;
    private String text;
}
