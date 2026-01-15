package com.personal.coffee_catalog.service;

import com.personal.coffee_catalog.request.CoffeeRequest;
import com.personal.coffee_catalog.response.CoffeeResponse;
import java.util.List;

public interface CoffeeService {

  List<CoffeeResponse> getAllActiveCoffees();

  CoffeeResponse getCoffee(Long coffeeId);

  CoffeeResponse createCoffee(CoffeeRequest coffeeRequest);

  CoffeeResponse updateCoffee(Long coffeeId, CoffeeRequest coffeeRequest);

  CoffeeResponse deleteCoffee(Long coffeeId);
}
