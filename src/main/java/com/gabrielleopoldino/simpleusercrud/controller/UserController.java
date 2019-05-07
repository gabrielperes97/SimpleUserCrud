package com.gabrielleopoldino.simpleusercrud.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import com.gabrielleopoldino.simpleusercrud.UserProperties;
import com.gabrielleopoldino.simpleusercrud.model.User;
import com.gabrielleopoldino.simpleusercrud.repository.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserProperties configs = new UserProperties();

    private UserDao userDao;

    @PostConstruct
    public void init() {
        try {
            userDao = new UserDao(configs.getFilename());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @GetMapping
    public User getByIndex(@RequestParam(value = "index", required = true) int i) {
        try {
            return userDao.getByIndex(i);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping
    public User save(@RequestBody User user) {
        try {
            System.out.println("Salvando :"+user.getUsername());
            return new User(userDao.save(user.getUsername()), user.getUsername());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping("all")
    public List<User> all() {
        try {
            return userDao.getAll();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}