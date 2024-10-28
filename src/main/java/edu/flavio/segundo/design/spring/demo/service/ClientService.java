package edu.flavio.segundo.design.spring.demo.service;

import edu.flavio.segundo.design.spring.demo.model.Client;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    Iterable<Client> searchAll();

    Client searchById(Long id);

    void insert(Client client);

    void refresh(Long id, Client client);

    void delete(Long id);

}
