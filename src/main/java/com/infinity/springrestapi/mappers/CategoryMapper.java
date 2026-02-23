package com.infinity.springrestapi.mappers;

import com.infinity.springrestapi.dtos.response.CategoryDto;
import com.infinity.springrestapi.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDto toDto(Category category);
}
