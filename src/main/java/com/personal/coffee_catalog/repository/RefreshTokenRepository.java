package com.personal.coffee_catalog.repository;

import com.personal.coffee_catalog.model.RefreshToken;
import com.personal.coffee_catalog.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

  Optional<RefreshToken> findByToken(String token);

  @Modifying
  @Transactional
  @Query("DELETE FROM RefreshToken rt WHERE rt.user = ?1")
  void deleteByUser(User user);

  @Transactional
  void deleteByUserId(Long userId);
}
