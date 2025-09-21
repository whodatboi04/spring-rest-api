package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
