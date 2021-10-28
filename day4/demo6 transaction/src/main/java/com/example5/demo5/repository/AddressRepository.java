package com.example5.demo5.repository;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example5.demo5.Entity.Address;

public interface AddressRepository extends CrudRepository<Address, Long>
{
	
}
