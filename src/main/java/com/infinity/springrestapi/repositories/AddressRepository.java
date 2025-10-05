package com.infinity.springrestapi.repositories;

import com.infinity.springrestapi.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
