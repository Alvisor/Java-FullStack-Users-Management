package com.JavaCourse.Course.controllers;

import com.JavaCourse.Course.dao.UserDao;
import com.JavaCourse.Course.models.User;
import com.JavaCourse.Course.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController  {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Manuel");
        user.setLastName("Rodriguez");
        user.setPhoneNumber("3014279808");
        user.setAddress("Fake Street 123");
        user.setEmail("Alvisor@gmail.com");
        return user;
    }

    @RequestMapping(value = "api/getUsers")
    public List<User> getUsers(@RequestHeader(value = "Authorization") String token){
        if(validateSessionToken(token)){
            return  new ArrayList<>();
        }
        return userDao.getUsers();
    }

    private boolean validateSessionToken (String token){
        String userID = jwtUtil.getKey(token);
        return userID!=null;
    }

    @RequestMapping(value = "api/createUsers", method = RequestMethod.POST)
    public void createUsers(@RequestBody User user){
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userDao.createUser(user);
    }
    @RequestMapping(value = "api/updateUser")
    public User updateUser(){
        User user = new User();
        user.setName("Manuel");
        user.setLastName("Rodriguez");
        user.setPhoneNumber("3014279808");
        user.setAddress("Fake Street 123");
        user.setEmail("Alvisor@gmail.com");
        return user;
    }
    @RequestMapping(value = "api/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value = "Authorization") String token, @PathVariable Long id){
        if(validateSessionToken(token)) {
            userDao.deleteUser(id);
        }
    }
}
