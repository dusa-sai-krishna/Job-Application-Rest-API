package com.saiDeveloper.Spring_Boot_Rest.service;

import com.saiDeveloper.Spring_Boot_Rest.model.User;
import com.saiDeveloper.Spring_Boot_Rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        repo.save(user);
        return repo.findById(user.getUsername()).orElse(new User());
    }

}
