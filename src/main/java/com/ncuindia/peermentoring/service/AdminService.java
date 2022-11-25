package com.ncuindia.peermentoring.service;

import java.util.List;

import com.ncuindia.peermentoring.model.UserDetails;
import com.ncuindia.peermentoring.model.UserTable;

public interface AdminService {
    public void deleteUser(String emailId);
    public UserDetails verifyUser(String emailId);
    public List<UserTable> getAllUsers();
}
