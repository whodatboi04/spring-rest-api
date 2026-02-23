package com.infinity.springrestapi.controllers;

import com.infinity.springrestapi.dtos.response.CategoryDto;
import com.infinity.springrestapi.mappers.CategoryMapper;
import com.infinity.springrestapi.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public List<CategoryDto> getAllCategories()
    {
        return categoryRepository.findAll(Sort.by("name"))
                .stream()
                .map(categoryMapper::toDto)
                .toList();
    }
}
