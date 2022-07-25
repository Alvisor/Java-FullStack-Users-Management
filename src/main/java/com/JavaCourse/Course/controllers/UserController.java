package com.JavaCourse.Course.controllers;

import com.JavaCourse.Course.dao.UserDao;
import com.JavaCourse.Course.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController implements UserDao {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "getUser/{id}")
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

    @RequestMapping(value = "getUsers")
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "updateUser")
    public User updateUser(){
        User user = new User();
        user.setName("Manuel");
        user.setLastName("Rodriguez");
        user.setPhoneNumber("3014279808");
        user.setAddress("Fake Street 123");
        user.setEmail("Alvisor@gmail.com");
        return user;
    }
    @RequestMapping(value = "deleteUser")
    public User deleteUser(){
        User user = new User();
        user.setName("Manuel");
        user.setLastName("Rodriguez");
        user.setPhoneNumber("3014279808");
        user.setAddress("Fake Street 123");
        user.setEmail("Alvisor@gmail.com");
        return user;
    }
    @RequestMapping(value = "searchUser")
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
