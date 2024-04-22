package com.twitter.service;

import com.twitter.dao.UserDao;
import com.twitter.dto.CredentialDto;
import com.twitter.dto.UserDto;
import com.twitter.entity.User;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.apache.catalina.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Log
@Service
@AllArgsConstructor
public class AuthenticationService {
    private final UserDao userDao;

    public boolean isValidCredential(CredentialDto user) {
        User userCred= userDao.search(user.getUsername());
        if (userCred == null ) return false;
        if (userCred.getUsername() == null) return false;
        if ( userCred.getPassword().equals(user.getPassword())){
            return true;
        }
        return false;

    }

    public String createSession(CredentialDto credential, HttpSession session) {
        log.info("creating session");
        User user= userDao.search(credential.getUsername());
        log.info("valid credential"+user);
        session.setAttribute("username",user.getUsername());
        session.setAttribute("id",user.getId());
        return "redirect:/tweet";
    }

    public boolean duplicate(User user) {
        User userFromDb=userDao.search(user.getUsername());
        return userFromDb !=null;
    }

    public void create(User user) {
        log.info("Creating User:" +user);
        userDao.create(user.getUsername(),user.getPassword(),user.getEmail());
        log.info("User:" +user+" created");
    }
}
