package com.personal.coffee_catalog.service;

import com.personal.coffee_catalog.exception.TokenRefreshException;
import com.personal.coffee_catalog.model.RefreshToken;
import com.personal.coffee_catalog.model.User;
import com.personal.coffee_catalog.repository.RefreshTokenRepository;
import com.personal.coffee_catalog.repository.UserRepository;
import java.time.Instant;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

  @Value("${jwt.refresh-expiration}")
  private Long refreshTokenDurationMs;

  private final RefreshTokenRepository refreshTokenRepository;
  private final UserRepository userRepository;

  public RefreshToken createRefreshToken(Long userId) {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new RuntimeException("User not found"));

    // Delete old refresh tokens for this user
    refreshTokenRepository.deleteByUserId(userId);

    RefreshToken refreshToken = RefreshToken.builder()
      .user(user)
      .token(UUID.randomUUID().toString())
      .expiryDate(Instant.now().plusMillis(refreshTokenDurationMs))
      .revoked(false)
      .build();

    return refreshTokenRepository.save(refreshToken);
  }

  public Optional<RefreshToken> findByToken(String token) {
    return refreshTokenRepository.findByToken(token);
  }

  public RefreshToken verifyExpiration(RefreshToken token) {
    if (token.isExpired()) {
      refreshTokenRepository.delete(token);
      throw new TokenRefreshException(token.getToken(),
        "Refresh token was expired. Please make a new login request");
    }

    if (token.isRevoked()) {
      throw new TokenRefreshException(token.getToken(),
        "Refresh token was revoked. Please make a new login request");
    }

    return token;
  }

  @Transactional
  public void revokeToken(String token) {
    refreshTokenRepository.findByToken(token)
      .ifPresent(rt -> {
        rt.setRevoked(true);
        refreshTokenRepository.save(rt);
      });
  }

  @Transactional
  public void deleteByUserId(Long userId) {
    User user = userRepository.findById(userId)
      .orElseThrow(() -> new RuntimeException("User not found"));
    refreshTokenRepository.deleteByUser(user);
  }
}
