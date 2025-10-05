package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
