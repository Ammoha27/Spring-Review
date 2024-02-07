package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("find")
    public List<Customer> getCustomerOlderThan(){
        return customerRepository.findCustomerByAgeAfter(20);
    }

     record NewCustomerRequest(String name, String email, Integer age){}

    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request){
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);

    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable Integer customerId){
        customerRepository.deleteById(customerId);
    }

    @GetMapping("{customerId}")
    public Customer getCustomerById(@PathVariable Integer customerId){
        return customerRepository.getCustomerById(customerId);
    }


    @PutMapping("{customerId}")
    public void updateCustomer(@PathVariable Integer customerId, @RequestBody NewCustomerRequest request){
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
       if (optionalCustomer.isPresent()){
           Customer customer = optionalCustomer.get();
           customer.setName(request.name());
           customer.setEmail(request.email());
           customer.setAge(request.age());
           customerRepository.save(customer);
       }

    }
}















