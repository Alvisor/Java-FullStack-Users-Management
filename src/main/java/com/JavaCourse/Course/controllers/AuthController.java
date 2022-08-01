package com.JavaCourse.Course.controllers;

import com.JavaCourse.Course.dao.UserDao;
import com.JavaCourse.Course.models.User;
import com.JavaCourse.Course.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user) {

        User userTemp = userDao.getUserByLoginCredential(user);
        if (userTemp != null){
            String tokenJWT = jwtUtil.create(String.valueOf(userTemp.getId()), userTemp.getEmail());
            return tokenJWT;
        }
        return "Error";
    }
}