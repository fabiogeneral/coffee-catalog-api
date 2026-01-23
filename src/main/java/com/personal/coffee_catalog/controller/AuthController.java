package com.personal.coffee_catalog.controller;

import com.personal.coffee_catalog.request.LoginRequest;
import com.personal.coffee_catalog.request.RefreshTokenRequest;
import com.personal.coffee_catalog.request.RegisterRequest;
import com.personal.coffee_catalog.response.AuthResponse;
import com.personal.coffee_catalog.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication",
  description = "Authentication endpoints for user registration, login, and token refresh")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  @Operation(summary = "Register a new user",
    description = "Creates a new user account and returns access and refresh tokens")
  @ApiResponse(responseCode = "200", description = "User registered successfully")
  @ApiResponse(responseCode = "400", description = "Invalid input or email already in use")
  public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authService.register(request));
  }

  @PostMapping("/login")
  @Operation(summary = "Login user",
    description = "Authenticates user and returns access and refresh tokens")
  @ApiResponse(responseCode = "200", description = "Login successful")
  @ApiResponse(responseCode = "401", description = "Invalid email or password")
  public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authService.login(request));
  }

  @PostMapping("/refresh")
  @Operation(summary = "Refresh access token",
    description = "Generates a new access token using a valid refresh token")
  @ApiResponse(responseCode = "200", description = "Token refreshed successfully")
  @ApiResponse(responseCode = "403", description = "Invalid or expired refresh token")
  public ResponseEntity<AuthResponse> refreshToken(@RequestBody RefreshTokenRequest request) {
    return ResponseEntity.ok(authService.refreshToken(request));
  }

  @PostMapping("/logout")
  @Operation(summary = "Logout user", description = "Revokes the refresh token")
  @ApiResponse(responseCode = "200", description = "Logout successful")
  public ResponseEntity<Void> logout(@RequestBody RefreshTokenRequest request) {
    authService.logout(request.getRefreshToken());
    return ResponseEntity.ok().build();
  }
}
