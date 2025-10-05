package com.infinity.springrestapi.controllers;

import com.infinity.springrestapi.dtos.response.ProductDto;
import com.infinity.springrestapi.dtos.request.StoreProductRequest;
import com.infinity.springrestapi.dtos.request.UpdateProductRequest;
import com.infinity.springrestapi.mappers.ProductMapper;
import com.infinity.springrestapi.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody StoreProductRequest request,
            UriComponentsBuilder uriComponentsBuilder)
    {

        var product = productMapper.toEntity(request);
        productRepository.save(product);

        var uri = uriComponentsBuilder.path("/products").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(productMapper.toDto(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
        @PathVariable Long id,
        @RequestBody UpdateProductRequest request
    )
    {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productMapper.update(request, product);
        productRepository.save(product);

        return ResponseEntity.ok().body(productMapper.toDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable Long id
    )
    {
        var product = productRepository.findById(id).orElse(null);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }

        productRepository.delete(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
