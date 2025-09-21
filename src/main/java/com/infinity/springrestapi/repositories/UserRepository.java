package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
