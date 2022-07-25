package com.JavaCourse.Course.dao;

import com.JavaCourse.Course.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    void deleteUser(Long id);

    void createUser(User user);
}
