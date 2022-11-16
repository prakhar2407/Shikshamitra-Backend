package com.ncuindia.peermentoring.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ncuindia.peermentoring.model.RefreshToken;
import com.ncuindia.peermentoring.model.UserTable;
import com.ncuindia.peermentoring.payload.request.LoginRequest;
import com.ncuindia.peermentoring.payload.request.SignUpRequest;
import com.ncuindia.peermentoring.payload.request.TokenRefreshRequest;
import com.ncuindia.peermentoring.payload.response.JwtResponse;
import com.ncuindia.peermentoring.payload.response.MessageResponse;
import com.ncuindia.peermentoring.payload.response.TokenRefreshResponse;
import com.ncuindia.peermentoring.repository.UserTableRepository;
import com.ncuindia.peermentoring.security.jwt.JwtUtils;
import com.ncuindia.peermentoring.service.impl.RefreshTokenServiceImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
        @Autowired
        AuthenticationManager authenticationManager;

        @Autowired
        UserTableRepository userTableRepository;

        @Autowired
        PasswordEncoder encoder;

        @Autowired
        JwtUtils jwtUtils;

        @Autowired
        RefreshTokenServiceImpl refreshTokenServiceImpl;

        @PostMapping("/signin")
        public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

                Authentication authentication = authenticationManager
                                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                                                loginRequest.getPassword()));

                SecurityContextHolder.getContext().setAuthentication(authentication);

                UserTable userDetails = (UserTable) authentication.getPrincipal();
                String accessToken = jwtUtils.generateJwtToken(userDetails);
                RefreshToken refreshToken = refreshTokenServiceImpl.createRefreshToken(userDetails.getEmailId());
                return ResponseEntity.ok(new JwtResponse(accessToken, userDetails.getEmailId(), userDetails.getRole(),
                                refreshToken.getToken()));
        }

        @PostMapping("/signup")
        public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
                if (userTableRepository.existsByEmailId(signUpRequest.getEmail())) {
                        return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
                }

                UserTable userTable = new UserTable(signUpRequest.getEmail(), encoder.encode(
                                signUpRequest.getPassword()), signUpRequest.getRole());

                userTableRepository.save(userTable);
                return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }

        @PostMapping("/refreshtoken")
        public ResponseEntity<?> refreshtoken(@Valid @RequestBody TokenRefreshRequest request) {
                try {
                        String requestRefreshToken = request.getRefreshToken();

                        final Optional<RefreshToken> refershToken = refreshTokenServiceImpl
                                        .findByToken(requestRefreshToken);
                        if (refershToken.isPresent()) {
                                RefreshToken currRefreshToken = refershToken.get();
                                if (refreshTokenServiceImpl.verifyExpiration(currRefreshToken) != null) {
                                        UserTable userTable = currRefreshToken.getUser();
                                        String token = jwtUtils.generateTokenFromUsername(userTable.getEmailId());
                                        return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
                                }

                        }
                } catch (Exception e) {
                        throw e;
                }

                return ResponseEntity.ok(new MessageResponse("No referesh Token found"));
        }

        @PostMapping("/signout")
        public ResponseEntity<?> logoutUser() {
                UserTable userDetails = (UserTable) SecurityContextHolder.getContext().getAuthentication()
                                .getPrincipal();
                String emailId = userDetails.getEmailId();
                refreshTokenServiceImpl.deleteByUserId(emailId);
                return ResponseEntity.ok(new MessageResponse("Log out successful!"));
        }
}
