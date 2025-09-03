package com.leosouza.workshopmongo.services;

import com.leosouza.workshopmongo.controller.exceptions.ObjectNotFoundExcpetion;
import com.leosouza.workshopmongo.domain.User;
import com.leosouza.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> user = userRepository.findById(id);
       return user.orElseThrow(() -> new ObjectNotFoundExcpetion("Objeto não encontrado" + id));
    }
}
