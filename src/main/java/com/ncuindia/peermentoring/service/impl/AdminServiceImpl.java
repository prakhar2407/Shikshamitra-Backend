package com.ncuindia.peermentoring.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.exception.ResourceNotFoundException;
import com.ncuindia.peermentoring.model.UserDetails;
import com.ncuindia.peermentoring.model.UserTable;
import com.ncuindia.peermentoring.repository.UserDetailsRepository;
import com.ncuindia.peermentoring.repository.UserTableRepository;
import com.ncuindia.peermentoring.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    UserTableRepository userTableRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Override
    public void deleteUser(String emailId) {
        userTableRepository.deleteByEmailId(emailId);
    }

    @Override
    public UserDetails verifyUser(String emailId) {
        Optional<UserDetails> currUserDetailsOptional = userDetailsRepository.findByEmailId(emailId);
        if (currUserDetailsOptional.isPresent()) {
            UserDetails currUser = currUserDetailsOptional.get();
            currUser.setIsVerified(!currUser.getIsVerified());
            userDetailsRepository.save(currUser);
            return currUser;
        } else {
            throw new ResourceNotFoundException(emailId, emailId, currUserDetailsOptional);
        }
    }

    @Override
    public List<UserTable> getAllUsers() {
        return userTableRepository.findAll();
    }

}
