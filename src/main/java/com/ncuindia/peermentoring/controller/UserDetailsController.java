package com.ncuindia.peermentoring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncuindia.peermentoring.payload.request.UserDetailsUpdateRequest;
import com.ncuindia.peermentoring.service.impl.UserDetailsServiceImpl;

@Controller
@RequestMapping("/profile")
public class UserDetailsController {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @PutMapping("/update/{emailId}")
    public ResponseEntity<?> updateProfile(@PathVariable String emailId, @Valid @RequestBody UserDetailsUpdateRequest profileRequest ) {
        return ResponseEntity.ok(userDetailsServiceImpl.updateProfile(emailId, profileRequest));
    }
}
