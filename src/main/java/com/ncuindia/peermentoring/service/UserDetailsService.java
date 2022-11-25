package com.ncuindia.peermentoring.service;


import com.ncuindia.peermentoring.model.UserDetails;
import com.ncuindia.peermentoring.payload.request.UserDetailsUpdateRequest;

public interface UserDetailsService {
    public UserDetails updateProfile(String emailId, UserDetailsUpdateRequest profileRequest);
}
