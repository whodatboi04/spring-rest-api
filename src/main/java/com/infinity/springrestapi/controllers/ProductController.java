package com.infinity.springrestapi.controllers;

import com.infinity.springrestapi.dtos.ProductDto;
import com.infinity.springrestapi.entities.Product;
import com.infinity.springrestapi.mappers.ProductMapper;
import com.infinity.springrestapi.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Filter;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestParam(required = false, defaultValue = "", name="categoryId") Byte categoryId
    ) {
        var products = categoryId == null ? productRepository.findAllWithCategory()
                : productRepository.findByCategoryId(categoryId);

        return products.stream().map(productMapper::toDto).toList();
    }

}
