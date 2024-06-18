package com.example.service;

import com.example.model.User;

import java.util.List;

public interface UserServiceI {
    //CURD

    //CREATE
    User createUser(User user);

    //UPDATE
    User updateUser(User user, Long userId);


    //GET(RETRIVE) single data
    User getSingleUser(Long userId) throws Exception;


    //GET(RETRIVE) all data
List<User> getAllUsers();

    //DELETE

    void deleteUser(Long userId);
}
