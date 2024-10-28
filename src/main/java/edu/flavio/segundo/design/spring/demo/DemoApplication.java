package edu.flavio.segundo.design.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Funcionando  acesse http://localhost:9090/swagger-ui.html");
		System.out.println("Funcionando  acesse http://localhost:9090/clients");
		System.out.println("Funcionando  acesse http://localhost:9090");
	}
}