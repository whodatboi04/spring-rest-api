package com.infinity.springrestapi.services;

import com.infinity.springrestapi.dtos.response.CategoryDto;
import com.infinity.springrestapi.mappers.CategoryMapper;
import com.infinity.springrestapi.model.Category;
import com.infinity.springrestapi.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    public Page<CategoryDto> getCategories(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Category> categoryPage = categoryRepository.findAll(pageable);

        return categoryPage.map(categoryMapper::toDto);
    }
}
