package edu.flavio.segundo.design.spring.demo.service;

import edu.flavio.segundo.design.spring.demo.model.Address;
import jakarta.websocket.server.PathParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "viacep",url="https://viacep.com.br/ws")
public interface ViaCepService {
    @GetMapping("/{cep}/json/")
    Address searchCEP(@PathParam("cep")String cep);
}
