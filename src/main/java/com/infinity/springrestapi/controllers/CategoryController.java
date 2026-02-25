package com.infinity.springrestapi.controllers;

import com.infinity.springrestapi.dtos.request.StoreCategoryRequest;
import com.infinity.springrestapi.dtos.response.ApiResponse;
import com.infinity.springrestapi.dtos.response.CategoryDto;
import com.infinity.springrestapi.mappers.CategoryMapper;
import com.infinity.springrestapi.model.Category;
import com.infinity.springrestapi.repositories.CategoryRepository;
import com.infinity.springrestapi.services.CategoryService;
import com.infinity.springrestapi.utils.security.ResponseUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.Collectors;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final CategoryService categoryService;

    //TODO: ERROR INFINITE LOOP OF DATA
    @GetMapping
    public ResponseEntity<ApiResponse<List<Category>>> getAllCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Page<Category> categoryPage = categoryService.getCategories(page, size);

        return ResponseEntity.ok(ResponseUtil.paginatedSuccess("Category successfuly fetched", categoryPage));
//        return categoryRepository.findAll(Sort.by("name"))
//                .stream()
//                .map(categoryMapper::toDto)
//                .toList();
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(
            @RequestBody StoreCategoryRequest request,
            UriComponentsBuilder uriComponentsBuilder
    )
    {
        var category = categoryMapper.toEntity(request);
        categoryRepository.save(category);

        var uri = uriComponentsBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri();
        return ResponseEntity.created(uri).body(categoryMapper.toDto(category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CategoryDto>> getCategoryById(@PathVariable Byte id)
    {
        var category = categoryRepository.findById(id).orElse(null);
        if (category == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(
                ResponseUtil.success("Successfully fetched", categoryMapper.toDto(category), null)
        );
    }

}
