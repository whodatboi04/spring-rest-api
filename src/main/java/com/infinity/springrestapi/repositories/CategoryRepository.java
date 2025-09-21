package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
