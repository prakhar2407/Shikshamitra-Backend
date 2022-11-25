package com.ncuindia.peermentoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncuindia.peermentoring.payload.request.DeleteUserRequest;
import com.ncuindia.peermentoring.service.impl.AdminServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminServiceImpl;

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {
        adminServiceImpl.deleteUser(deleteUserRequest.getEmailId());
    }

    @PutMapping("/verify/{emailId}")
    public ResponseEntity<?> verifyUser(@PathVariable String emailId) {
        return ResponseEntity.ok(adminServiceImpl.verifyUser(emailId));
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok(adminServiceImpl.getAllUsers());
    }

}
