package com.JavaCourse.Course.controllers;

import com.JavaCourse.Course.dao.UserDao;
import com.JavaCourse.Course.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController  {

    @Autowired
    private UserDao userDao;


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
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/createUsers", method = RequestMethod.POST)
    public void createUsers(@RequestBody User user){
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
    public void deleteUser(@PathVariable Long id){
        userDao.deleteUser(id);
    }


    @RequestMapping(value = "api/searchUser")
    public User searchUser(){
        User user = new User();
        user.setName("Manuel");
        user.setLastName("Rodriguez");
        user.setPhoneNumber("3014279808");
        user.setAddress("Fake Street 123");
        user.setEmail("Alvisor@gmail.com");
        return user;
    }
}
