package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.model.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;

public interface CategoryRepository extends JpaRepository<Category, Byte> {
    Category findByName(String name);
}
