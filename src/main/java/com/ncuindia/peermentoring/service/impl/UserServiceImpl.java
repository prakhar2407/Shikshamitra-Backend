package com.ncuindia.peermentoring.service.impl;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.model.UserTable;
import com.ncuindia.peermentoring.service.UserService;
import com.pie.dao.RoleRepository;
import com.pie.dao.UserRepository;
import com.pie.model.User;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
    
    
    BCryptPasswordEncoder bc =  new BCryptPasswordEncoder();
    

    @Override
    public void save(UserTable user) {
        user.setPassword(bc.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    @Override
    public UserTable findByEmail(String username) {
        return userRepository.findByEmail(username);
    }
}