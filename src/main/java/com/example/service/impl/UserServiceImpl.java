package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserRepository userRepository;                 //Field DI


    @Override
    public User createUser(User user) {
       User savedUser = userRepository.save(user);
        return savedUser;
    }

    @Override
    public User updateUser(User user, Long userId) {

       User user1 = userRepository.findById(userId).get();

        user1.setUserName(user.getUserName());
        user1.setUserAge(user.getUserAge());
        user1.setUserId(user.getUserId());
        user1.setAbout(user.getAbout());

       User updatedUser = userRepository.save(user1);

        return updatedUser ;
    }

    @Override
    public User getSingleUser(Long userId)  {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("Resource not found in server"+ userId));

        return user;

    }
      //by using java
       /* Optional<User> user = userRepository.findById(userId);

        if(user.isPresent()){
            return user.get();
        }else{
            throw new Exception("Resource not found in server"+ userId);
        } */







    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
