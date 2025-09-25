package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
