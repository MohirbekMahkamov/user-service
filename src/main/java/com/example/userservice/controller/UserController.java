package com.example.userservice.controller;


import com.example.userservice.DTO.ResponseTemplateDto;
import com.example.userservice.entity.Users;
import com.example.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;
    @PostMapping("/")
    public Users saveUser(@RequestBody Users user){
        return userService.saveUser(user);
    }
//    @GetMapping("/{id}")
//    public Users getUser(@PathVariable("id") Integer userId){
//        return userService.findUserById(userId);
//    }
    @PostMapping("/list")
    public List<Users> userList(){
      return   userService.list();
    }


    @GetMapping("/{id}")
    public ResponseTemplateDto getUserWithDepartment(@PathVariable("id") Integer userId){
        return userService.getUserWithDepartment(userId);
    }




}
