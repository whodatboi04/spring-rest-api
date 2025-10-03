package com.infinity.springrestapi.mappers;

import com.infinity.springrestapi.dtos.ProductDto;
import com.infinity.springrestapi.dtos.StoreProductRequest;
import com.infinity.springrestapi.dtos.UpdateProductRequest;
import com.infinity.springrestapi.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDto toDto(Product product);

    @Mapping(source = "categoryId", target = "category.id")
    Product toEntity(StoreProductRequest request);

    void update(UpdateProductRequest request, @MappingTarget Product product);
}
