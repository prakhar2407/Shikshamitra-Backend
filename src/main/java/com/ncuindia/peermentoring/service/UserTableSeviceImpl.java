package com.ncuindia.peermentoring.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ncuindia.peermentoring.model.UserTable;
import com.ncuindia.peermentoring.repository.UserTableRepository;

@Service
public class UserTableSeviceImpl implements UserDetailsService {

    @Autowired
    UserTableRepository userTableRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
        UserTable userTable = userTableRepository.findByEmailId(emailId)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + emailId));
        return userTable;
    }

}
