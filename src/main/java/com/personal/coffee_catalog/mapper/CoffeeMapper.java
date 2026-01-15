package com.personal.coffee_catalog.mapper;

import com.personal.coffee_catalog.entity.Coffee;
import com.personal.coffee_catalog.response.CoffeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

  CoffeeResponse toCoffeeResponse(Coffee coffee);

//  @Mapping(target = "id", ignore = true)
//  @Mapping(target = "createdAt", ignore = true)
//  @Mapping(target = "isActive", constant = true)
//  Coffee toEntity(Coffee coffee);
}
