package com.twitter.service;

import com.twitter.dao.FollowerMappingDao;
import com.twitter.dao.UserDao;
import com.twitter.entity.User;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
@AllArgsConstructor
public class FollowerService {
    private final FollowerMappingDao followerMappingDao;
    private final UserDao userDao;

    public void followUser(int userid, int userTofollow) {
        followerMappingDao.follow(userid, userTofollow);
        log.info("User "+userid+" added "+userTofollow);
    }

    public void removeFollower(int userid, int userToUnfollow) {
        followerMappingDao.remove(userid,userToUnfollow);
        log.info("User "+userid+" removed "+userToUnfollow);

    }

    public List<User> getFollowers(int userid) {
        log.info("User "+userid+" removed "+userid);
        return userDao.getFollowersById(userid);
    }

    public List<User> getUserToFollow(int userid) {
        log.info("User "+userid+" removed "+userid);
        return userDao.getUserWhoDidntFollow(userid);
    }
}
