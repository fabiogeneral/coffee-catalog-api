package com.personal.coffee_catalog.mapper;

import com.personal.coffee_catalog.entity.Coffee;
import com.personal.coffee_catalog.response.CoffeeResponse;
import org.springframework.stereotype.Component;

@Component
public class CoffeeMapperImpl implements CoffeeMapper {

  /**
   * Maps a Coffee entity to a CoffeeResponse DTO.
   *
   * @param coffee the Coffee entity to map
   * @return the mapped CoffeeResponse DTO
   */
  @Override
  public CoffeeResponse toCoffeeResponse(Coffee coffee) {
    if (coffee == null) {
      return null;
    }

    CoffeeResponse response = new CoffeeResponse();

    response.setId(coffee.getId());
    response.setName(coffee.getName());
    response.setDescription(coffee.getDescription());
    return response;
  }
}
