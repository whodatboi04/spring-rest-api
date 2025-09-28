package com.infinity.springrestapi.mappers;

import com.infinity.springrestapi.dtos.ProductDto;
import com.infinity.springrestapi.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);
}
