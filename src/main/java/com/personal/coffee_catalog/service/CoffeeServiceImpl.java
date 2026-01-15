package com.personal.coffee_catalog.service;

import com.personal.coffee_catalog.entity.Coffee;
import com.personal.coffee_catalog.mapper.CoffeeMapper;
import com.personal.coffee_catalog.repository.CoffeeRepository;
import com.personal.coffee_catalog.request.CoffeeRequest;
import com.personal.coffee_catalog.response.CoffeeResponse;
import com.personal.coffee_catalog.utils.CommonHelper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {

  private final CoffeeRepository coffeeRepository;
  private final CoffeeMapper coffeeMapper;
  private static final String ENTITY = "Coffee";

  /**
   * Get all active coffees
   */
  public List<CoffeeResponse> getAllActiveCoffees() {
    List<Coffee> allActiveCoffees = coffeeRepository.findByIsActiveTrue();

    return coffeeMapper.coffeesToResponse(allActiveCoffees);
  }

  /**
   * Get coffee by ID
   */
  public CoffeeResponse getCoffee(Long coffeeId) {
    Coffee coffee = CommonHelper.findByIdOrThrow(ENTITY, coffeeRepository, coffeeId);

    if (!coffee.getIsActive()) {
      throw new IllegalArgumentException("Coffee ID " + coffeeId + " is not active");
    }

    return coffeeMapper.coffeeToResponse(coffee);
  }

  /**
   * Create coffee
   */
  public CoffeeResponse createCoffee(CoffeeRequest coffeeRequest) {
    coffeeRequest.setIsActive(true);
    Coffee savedCoffee = coffeeRepository.save(coffeeMapper.requestToCoffee(coffeeRequest));

    return coffeeMapper.coffeeToResponse(savedCoffee);
  }

  /**
   * Update coffee
   */
  public CoffeeResponse updateCoffee(Long coffeeId, CoffeeRequest coffeeRequest) {
    Coffee coffee = CommonHelper.findByIdOrThrow(ENTITY, coffeeRepository, coffeeId);

    if (coffeeRequest.getName() != null) {
      coffee.setName(coffeeRequest.getName());
    }
    if (coffeeRequest.getIsActive() != null) {
      coffee.setIsActive(coffeeRequest.getIsActive());
    }

    Coffee updatedCoffee = coffeeRepository.save(coffee);

    return coffeeMapper.coffeeToResponse(updatedCoffee);
  }

  /**
   * Delete coffee
   */
  public CoffeeResponse deleteCoffee(Long coffeeId) {
    Coffee coffee = CommonHelper.findByIdOrThrow(ENTITY, coffeeRepository, coffeeId);

    coffeeRepository.delete(coffee);

    return coffeeMapper.coffeeToResponse(coffee);
  }
}
