package com.twitter.controller;

import com.twitter.config.DataSourceProperties;
import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Log
@Controller
public class FollowerController {
//    @GetMapping("/add")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String followerMapping(HttpSession session, @ModelAttribute("follow") String follow, @ModelAttribute("unfollow") String unfollow){
//        HttpSession session = new Se
        String userName =(String) session.getAttribute("username");
        log.info("follow : "+ follow+" unfollow : "+ unfollow);
//        System.out.println("User : "+userName);
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
