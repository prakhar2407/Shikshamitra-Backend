package com.ncuindia.peermentoring.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncuindia.peermentoring.model.UserDetails;
import com.ncuindia.peermentoring.model.UserTable;
import com.ncuindia.peermentoring.payload.request.UserDetailsUpdateRequest;
import com.ncuindia.peermentoring.repository.UserDetailsRepository;
import com.ncuindia.peermentoring.repository.UserTableRepository;
import com.ncuindia.peermentoring.service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UserTableRepository userTableRepository;

    @Transactional
    @Override
    public UserDetails updateProfile(String emailId, UserDetailsUpdateRequest profileRequest) {
        Optional<UserTable> userTable = userTableRepository.findByEmailId(emailId);
        if (userTable.isPresent()) {
            UserDetails userDetails = new UserDetails(emailId, profileRequest.getName(),
                    profileRequest.getProfile_pic(),
                    profileRequest.getBranch(), profileRequest.getCourse(), profileRequest.getCurr_year(),
                    profileRequest.getDob(), profileRequest.getPhoneNumber(), profileRequest.getCgpa());
            UserDetails userDetailsAfterSave = userDetailsRepository.save(userDetails);
            return userDetailsAfterSave;
        }
        return null;

    }

}
