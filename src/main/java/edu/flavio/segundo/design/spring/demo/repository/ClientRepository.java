package edu.flavio.segundo.design.spring.demo.repository;

import edu.flavio.segundo.design.spring.demo.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,Long> {
}
