package com.ncuindia.peermentoring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ncuindia.peermentoring.payload.response.MessageResponse;

@Controller
@RequestMapping("/")
public class MainController {
    @GetMapping()
    @ResponseBody
    public ResponseEntity<?> homePage() {
        return ResponseEntity.ok(new MessageResponse("Data Fetched Successfuly"));
    }
}
