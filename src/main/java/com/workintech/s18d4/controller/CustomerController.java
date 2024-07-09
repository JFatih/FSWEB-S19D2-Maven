package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer get(@PathVariable Long id){
        return customerService.find(id);
    }

    @PostMapping
    public CustomerResponse save(@RequestBody Customer customer){
        Customer savedCustomer = customerService.save(customer);
        return new CustomerResponse(savedCustomer.getId(),savedCustomer.getEmail(),savedCustomer.getSalary());
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable("id") long id){
        return customerService.delete(id);
    }
}
