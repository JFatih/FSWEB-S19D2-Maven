package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.repository.CustomerRepository;
import com.workintech.s18d4.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer find(long id) {
        if(customerRepository.findById(id).isPresent()){
            return customerRepository.findById(id).get();
        }else{
            Validation.idIsNotExist();
            return null;
        }
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(long id, Customer customer) {
        if(customerRepository.findById(id).isPresent()){
            customer.setId(id);
            return customerRepository.save(customer);
        }else {
            Validation.idIsNotExist();
            return null;
        }
    }

    @Override
    public Customer delete(long id) {
        if(customerRepository.findById(id).isPresent()){
            Customer customer = customerRepository.findById(id).get();
            customerRepository.delete(customer);
            return customer;
        }else{

            return null;
        }
    }
}
