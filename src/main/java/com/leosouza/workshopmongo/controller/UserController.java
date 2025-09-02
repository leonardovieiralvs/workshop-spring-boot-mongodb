package com.leosouza.workshopmongo.controller;

import com.leosouza.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = new ArrayList<>();
        User leo = new User("1", "leo", "leonardo@gmail.com");
        User bira = new User("2", "bira", "bira@gmail.com");
        User magro = new User("3", "magro", "magro@gmail.com");
        list.addAll(Arrays.asList(leo, bira, magro));
        return ResponseEntity.ok().body(list);
    }
}
