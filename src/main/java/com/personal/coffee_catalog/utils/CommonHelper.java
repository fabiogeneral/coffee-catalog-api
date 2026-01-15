package com.personal.coffee_catalog.utils;

import org.springframework.data.jpa.repository.JpaRepository;

public class CommonHelper {

  private CommonHelper() {
    throw new UnsupportedOperationException("Utility class");
  }

  /**
   * Find entity by ID or throw exception if not found
   *
   * @param entity     Entity name
   * @param repository JPA repository
   * @param <T>        Entity type
   * @param id         Entity ID
   * @return Entity
   * @throws IllegalArgumentException if entity not found
   */
  public static <T> T findByIdOrThrow(String entity, JpaRepository<T, Long> repository, Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new IllegalArgumentException("%s ID %s not found".formatted(entity, id)));
  }
}
