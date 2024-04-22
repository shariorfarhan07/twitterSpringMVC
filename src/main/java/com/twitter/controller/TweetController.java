package com.twitter.controller;

import com.twitter.dto.TweetDto;
import com.twitter.dto.UserDto;
import com.twitter.entity.Tweet;
import com.twitter.entity.User;
import com.twitter.service.FollowerService;
import com.twitter.service.TweetService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.SQLException;
import java.util.List;

@Controller
@Log
@RequestMapping(value = "/tweet")
@AllArgsConstructor
public class TweetController {
//    private Logger Log = Logger.getLogger(String.valueOf(TweetController.class));
    private final TweetService tweetService;
    private final FollowerService followerService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home(ModelMap modelMap, Model model, HttpSession session){
        log.info("tweet home page");
        List<Tweet> tweets = null;
        List<User> followers=null;
        List<User> userTofollow=null;

        String username =(String) session.getAttribute("username");
        if (username == null) {
            model.addAttribute("error","You are not logged in, please login!");
            return "login";
        }
        int userid= (int) session.getAttribute("id");
        log.info("user id from tweet = "+userid);
        tweets = tweetService.SearchFriendsAndMyTweet(userid);
        followers= followerService.getFollowers(userid);
        userTofollow= followerService.getUserToFollow(userid);
        System.out.println(tweets.toString()+"farhan");
        System.out.println(followers.toString());
        System.out.println(userTofollow.toString());
        // add attribute to load modelMap
        modelMap.addAttribute("tweets",tweets);
        modelMap.addAttribute("followers",followers);
        modelMap.addAttribute("usersTofollow",userTofollow);
        return "home";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String update(ModelMap modelMap,@ModelAttribute("id") int id){
        Tweet tweet = tweetService.searchTweetById(id);
        modelMap.addAttribute("tweet",tweet);
        return "update";
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@ModelAttribute("id") int id, ModelMap modelMap){
        TweetDto tweet = null;
        modelMap.addAttribute("tweet",tweet);
        return "redirect:/";
    }









}
