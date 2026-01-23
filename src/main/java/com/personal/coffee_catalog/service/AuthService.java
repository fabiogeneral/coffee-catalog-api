package com.personal.coffee_catalog.service;

import com.personal.coffee_catalog.model.RefreshToken;
import com.personal.coffee_catalog.model.User;
import com.personal.coffee_catalog.repository.UserRepository;
import com.personal.coffee_catalog.request.LoginRequest;
import com.personal.coffee_catalog.request.RefreshTokenRequest;
import com.personal.coffee_catalog.request.RegisterRequest;
import com.personal.coffee_catalog.response.AuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final RefreshTokenService refreshTokenService;

  public AuthResponse register(RegisterRequest request) {
    // Check if user already exists
    if (userRepository.findByEmail(request.getEmail()).isPresent()) {
      throw new IllegalArgumentException("Email already registered");
    }

    // Create new user
    var user = User.builder()
      .email(request.getEmail())
      .password(passwordEncoder.encode(request.getPassword()))
      .firstName(request.getFirstName())
      .lastName(request.getLastName())
      .role(request.getRole())
      .build();

    user = userRepository.save(user);

    // Generate tokens
    var accessToken = jwtService.generateToken(user);
    var refreshToken = refreshTokenService.createRefreshToken(user.getId());

    return AuthResponse.builder()
      .accessToken(accessToken)
      .refreshToken(refreshToken.getToken())
      .email(user.getEmail())
      .role(user.getRole().name())
      .build();
  }

  @Transactional(timeout = 5)
  public AuthResponse login(LoginRequest request) {
    // Authenticate user
    try {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
          request.getEmail(),
          request.getPassword()
        )
      );
    } catch (Exception e) {
      throw new IllegalArgumentException("Invalid email or password");
    }

    // Get user from database
    var user = userRepository.findByEmail(request.getEmail())
      .orElseThrow(() -> new RuntimeException("User not found"));

    // Generate tokens
    var accessToken = jwtService.generateToken(user);
    var refreshToken = refreshTokenService.createRefreshToken(user.getId());

    return AuthResponse.builder()
      .accessToken(accessToken)
      .refreshToken(refreshToken.getToken())
      .email(user.getEmail())
      .role(user.getRole().name())
      .build();
  }

  public AuthResponse refreshToken(RefreshTokenRequest request) {
    String requestRefreshToken = request.getRefreshToken();

    return refreshTokenService.findByToken(requestRefreshToken)
      .map(refreshTokenService::verifyExpiration)
      .map(RefreshToken::getUser)
      .map(user -> {
        String accessToken = jwtService.generateToken(user);

        return AuthResponse.builder()
          .accessToken(accessToken)
          .refreshToken(requestRefreshToken)
          .email(user.getEmail())
          .role(user.getRole().name())
          .build();
      })
      .orElseThrow(() -> new RuntimeException("Refresh token not found"));
  }

  public void logout(String refreshToken) {
    refreshTokenService.revokeToken(refreshToken);
  }
}
