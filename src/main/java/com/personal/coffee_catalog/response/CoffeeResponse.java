package com.personal.coffee_catalog.response;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeResponse {

  private Long id;
  private String name;
  private String description;
  private String originCountry;
  private String originRegion;
  private Integer altitudeMeters;
  private String varietal;
  private String processingMethod;
  private String roastLevel;
  private LocalDate roastDate;
  private BigDecimal price;
  private Integer weightGrams;
  private Integer acidityLevel;
  private Integer sweetnessLevel;
  private Integer bitternessLevel;
  private String imageUrl;
  private Boolean isActive;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
