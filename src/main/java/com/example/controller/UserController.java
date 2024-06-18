package com.example.controller;

import com.example.model.User;
import com.example.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {


    @Autowired
    private UserServiceI userServiceI;
//@PathVariable - pass single data
    //@RequestBody - wholeobject- secure
//@Requestparam -when we pass data in keyvalue pair like pagination and sorting
    @PostMapping("/users")
    //@RequestMapping(Method = RequestMethod.POST, name = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userServiceI.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);    //201 RESPONCE CREATED
    }

    @GetMapping("/users")
    public  ResponseEntity<List<User>> getAllUsers() {
        List<User> allUsers = userServiceI.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) throws Exception {
        User user = userServiceI.getSingleUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users/{userId}")
    public  ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userId){
        User updatedUser = userServiceI.updateUser(user, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
    }


    @DeleteMapping("/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userServiceI.deleteUser(userId);
        return new ResponseEntity<>( "User delete successfully!!!" , HttpStatus.OK);

    }

}
