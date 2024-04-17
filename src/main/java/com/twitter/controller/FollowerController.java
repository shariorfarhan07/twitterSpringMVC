package com.twitter.controller;

import com.twitter.config.DataSourceProperties;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log
@Controller
//@RequestMapping("/add")
public class FollowerController {
    @GetMapping("/add")
    public String followerMapping(@ModelAttribute("follow") String follow, @ModelAttribute("unfollow") String unfollow){
        log.info("follow : "+ follow+" unfollow : "+ unfollow);
        DataSourceProperties db = new DataSourceProperties();
        log.info(String.valueOf(db));

        if (follow.length() != 0 ){
            log.info("follow : "+ follow);
        }
        if (unfollow.length() != 0 ){
            log.info("unfollow : "+ unfollow);
        }
        return "home";
    }
}
