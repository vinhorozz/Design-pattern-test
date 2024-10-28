package edu.flavio.segundo.design.spring.demo.repository;

import edu.flavio.segundo.design.spring.demo.model.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,String> {
}
