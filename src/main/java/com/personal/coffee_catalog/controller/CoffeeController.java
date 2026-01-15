package com.personal.coffee_catalog.controller;

import com.personal.coffee_catalog.response.CoffeeResponse;
import com.personal.coffee_catalog.response.GenericResponse;
import com.personal.coffee_catalog.service.CoffeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
@CrossOrigin
//@Tag(name = "Coffee", description = "Coffee APIs")
public class CoffeeController {

  private final CoffeeService coffeeService;

  /**
   * Gets all active coffees.
   *
   * @return ...
   */
  @GetMapping(value = "/coffee", produces = {MediaType.APPLICATION_JSON_VALUE})
  public ResponseEntity<GenericResponse<CoffeeResponse>> getAllActiveCoffees() {
    return ResponseEntity.ok(
      GenericResponse.<CoffeeResponse>builder()
        .data(coffeeService.getAllActiveCoffees())
        .message(HttpStatus.OK.getReasonPhrase())
        .build());
  }
}
