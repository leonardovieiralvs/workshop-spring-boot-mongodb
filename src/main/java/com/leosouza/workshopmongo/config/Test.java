package com.leosouza.workshopmongo.config;


import com.leosouza.workshopmongo.domain.User;
import com.leosouza.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class Test implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User leo = new User(null, "leo", "leonardo@gmail.com");
        User bira = new User(null, "bira", "bira@gmail.com");
        User magro = new User(null, "magro", "magro@gmail.com");
        List<User> list = new ArrayList<>(Arrays.asList(leo, bira, magro));
        userRepository.saveAll(list);

    }
}
