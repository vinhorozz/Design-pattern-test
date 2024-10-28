package edu.flavio.segundo.design.spring.demo.controller;


import edu.flavio.segundo.design.spring.demo.model.Client;
import edu.flavio.segundo.design.spring.demo.service.ClientService;
import edu.flavio.segundo.design.spring.demo.service.ViaCepService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clients")
public class ClientRestController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>>searchAll(){
        return ResponseEntity.ok(clientService.searchAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Client>searchById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.searchById(id));
    }
    @PostMapping
    public ResponseEntity<Client>insert(@RequestBody Client client){
            clientService.insert(client);
            return ResponseEntity.ok(client);
    }
    @PutMapping("{/{id}}")
    public ResponseEntity<Client>upDate(@PathVariable Long id, @RequestBody Client client){
            clientService.refresh(id,client);
            return ResponseEntity.ok(client)
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id  ){
        clientService.delete(id);
        return ResponseEntity.ok().build();
    }

    }
