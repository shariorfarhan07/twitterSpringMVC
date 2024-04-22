package com.twitter.controller;

import com.twitter.config.DataSourceProperties;
import com.twitter.service.FollowerService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Log
@Controller
@AllArgsConstructor
public class FollowerController {
    private final FollowerService followerService;
    @GetMapping("/add")
    public String followerMapping(Model model, HttpSession session, @ModelAttribute("follow") String follow, @ModelAttribute("unfollow") String unfollow){

        String username =(String) session.getAttribute("username");
        log.info("User name:"+username+"follow : "+ follow+" unfollow : "+ unfollow);
        if (username == null) {
            model.addAttribute("error","You are not logged in, please login!");
            return "login";
        }
        int userid= (int) session.getAttribute("id");
        log.info("user id from tweet"+userid);



        if (follow.length() != 0 ){
            log.info("follow : "+ follow);
            followerService.followUser(userid, Integer.parseInt(follow));
            System.out.println(follow);
            model.addAttribute("success","user has been followed ");
        }
        if (unfollow.length() != 0 ){
            followerService.removeFollower(userid, Integer.parseInt(unfollow));
            model.addAttribute("success","user has been unfollowed ");
        }
        return "home";
    }
}
