package com.saiDeveloper.Spring_Boot_Rest.service;

import com.saiDeveloper.Spring_Boot_Rest.controller.UserPrincipal;
import com.saiDeveloper.Spring_Boot_Rest.model.User;
import com.saiDeveloper.Spring_Boot_Rest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findById(username).orElse(new User());
        if (user.getUsername()==null){
            throw new UsernameNotFoundException("404 User Not Found");
        }

        return new UserPrincipal(user);

    }
}
