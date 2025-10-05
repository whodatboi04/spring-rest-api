package com.infinity.springrestapi.mappers;

import com.infinity.springrestapi.dtos.response.ProductDto;
import com.infinity.springrestapi.dtos.request.StoreProductRequest;
import com.infinity.springrestapi.dtos.request.UpdateProductRequest;
import com.infinity.springrestapi.model.Product;
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
