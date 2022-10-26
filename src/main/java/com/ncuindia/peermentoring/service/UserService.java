package com.ncuindia.peermentoring.service;

import com.ncuindia.peermentoring.model.UserTable;

public interface UserService {
	    void save(UserTable user);

	    UserTable findByEmail(String username);
	    
	}


