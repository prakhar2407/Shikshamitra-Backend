package com.ncuindia.peermentoring.service.impl;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ncuindia.peermentoring.exception.TokenRefreshException;
import com.ncuindia.peermentoring.model.RefreshToken;
import com.ncuindia.peermentoring.repository.RefreshTokenRepository;
import com.ncuindia.peermentoring.repository.UserTableRepository;

@Service
public class RefreshTokenServiceImpl {
    @Value("${spring.peermentor.refreshExpiration}")
    private Long refreshTokenDurationMs;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private UserTableRepository userTableRepository;

    public Optional<RefreshToken> findByToken(String token) {
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshToken createRefreshToken(String emailId) {
        RefreshToken refreshToken = new RefreshToken();

        refreshToken.setUser(userTableRepository.findByEmailId(emailId).get());
        refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
        refreshToken.setToken(UUID.randomUUID().toString());

        refreshToken = refreshTokenRepository.save(refreshToken);
        return refreshToken;
    }

    public RefreshToken verifyExpiration(RefreshToken token) {
        if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
            refreshTokenRepository.delete(token);
            throw new TokenRefreshException(token.getToken(),
                    "Refresh token was expired. Please make a new signin request");
        }

        return token;
    }

    @Transactional
    public int deleteByUserId(String emailId) {
        return refreshTokenRepository.deleteByUser(userTableRepository.findByEmailId(emailId).get());
    }
}
