package com.personal.coffee_catalog.service;

import com.personal.coffee_catalog.entity.Coffee;
import com.personal.coffee_catalog.mapper.CoffeeMapper;
import com.personal.coffee_catalog.repository.CoffeeRepository;
import com.personal.coffee_catalog.response.CoffeeResponse;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

  private final CoffeeRepository coffeeRepository;
  private final CoffeeMapper coffeeMapper;

  /**
   * Get all active coffees
   */
  @Override
  public CoffeeResponse getAllActiveCoffees() {

    List<Coffee> allActiveCoffees = coffeeRepository.findByIsActiveTrue();
    log.debug("Fetching all active coffees");

    return (CoffeeResponse) allActiveCoffees
      .stream()
      .map(coffeeMapper::toCoffeeResponse)
      .collect(Collectors.toList());
  }
}
