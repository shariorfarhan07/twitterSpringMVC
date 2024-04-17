package com.twitter.controller;

import com.twitter.dto.TweetDto;
import com.twitter.dto.UserDto;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Log
//@RequestMapping(value = "/tweet")
public class TweetController {
//    private Logger Log = Logger.getLogger(String.valueOf(TweetController.class));

//    @RequestMapping(value = "/test", method = RequestMethod.GET)
//    public String printHelloWorld(ModelMap modelMap){
//        log.info("test");
//        // add attribute to load modelMap
//        modelMap.addAttribute("message",
//                "Hello World and Welcome to Spring MVC!");
//        // return the name of the file to be loaded "hello_world.jsp"
//        return "hello_world";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(ModelMap modelMap){
        List<TweetDto> tweets = null;
        List<UserDto>  followers=null;
        List<UserDto>  userTofollow=null;
//        try {
//            tweets = tweetDao.SearchFriendsAndMyTweet(userid);
//            followers= userDao.getFollowers(userid);
//            userTofollow= userDao.getUserToFollow(userid);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        // add attribute to load modelMap
        modelMap.addAttribute("tweets",tweets);
        modelMap.addAttribute("followers",followers);
        modelMap.addAttribute("userTofollow",userTofollow);
        // return the name of the file to be loaded "hello_world.jsp"
        return "home";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(ModelMap modelMap){
        TweetDto tweet = null;
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
