package com.github.dmagare.customers.controller;

import com.github.dmagare.customers.domain.Customer;
import com.github.dmagare.customers.service.CustomerService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService service)
    {this.customerService=service;}

    @GetMapping("")
    public Flux<Customer> getAll(){
        return customerService.getAll();
    }
    @GetMapping("/error")
        public String getError() {
        return customerService.printData();
    }
    @GetMapping("/customerId")
    public Mono<Customer> get(@PathVariable("customerId") int customerId){
        return customerService.get(customerId);
    }
    @PostMapping("")
    public Mono<Customer> create (@RequestBody Customer customer)
    {return customerService.create(customer);
    }
    @DeleteMapping("/delete/{customerId}")
    public void delete(@RequestBody Customer customer){
        customerService.delete(customer);
    }

}
