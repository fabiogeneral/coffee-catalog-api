package com.personal.coffee_catalog.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoffeeRequest {

  @NotNull(message = "Roaster Id is required")
  private Long roasterId;

  @NotBlank(message = "Coffee name is required")
  private String name;

  private String description;

  @NotBlank(message = "Coffee origin is required")
  private String originCountry;

  private String originRegion;

  @NotBlank(message = "Roast level is required")
  private String roastLevel;

  @Positive(message = "Price must be positive")
  private BigDecimal price;

  private Boolean isActive;
}
