package edu.flavio.segundo.design.spring.demo.service.Implementation;

import edu.flavio.segundo.design.spring.demo.model.Address;
import edu.flavio.segundo.design.spring.demo.model.Client;
import edu.flavio.segundo.design.spring.demo.repository.AddressRepository;
import edu.flavio.segundo.design.spring.demo.repository.ClientRepository;
import edu.flavio.segundo.design.spring.demo.service.ClientService;
import edu.flavio.segundo.design.spring.demo.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class Implematation implements ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Client> searchAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client searchById(Long id) {
        Optional<Client> client=clientRepository.findById(id);
        return client.get();
    }

    @Override
    public void insert(Client client) {
                saveClientCEP(client);
    }

    @Override
    public void refresh(Long id, Client client) {
            Optional<Client> client1=clientRepository.findById(id);
            if (client1.isPresent()){
                saveClientCEP(client);
            }
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }

    private void saveClientCEP(Client client){
        String cep= client.getAddress().getCep();
        Address address= addressRepository.findById(cep).orElseGet(()->{

            Address newAddress=viaCepService.searchCEP(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });

        client.setAddress(address);

        clientRepository.save(client);

    }
}
