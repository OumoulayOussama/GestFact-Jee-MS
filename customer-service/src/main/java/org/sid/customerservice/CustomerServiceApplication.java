package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {
            customerRepository.save(new Customer(null,"Ahmed","ahmed@gmail.com"));
            customerRepository.save(new Customer(null,"oussama","oussama@outlook.fr"));
            customerRepository.save(new Customer(null,"youssefi","emsi-2021@gmail.com"));
            customerRepository.findAll().forEach(customer -> {
                System.out.println(customer);
            });
            repositoryRestConfiguration.exposeIdsFor(Customer.class);
        };
    }

}
