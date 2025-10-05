package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.model.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
}
