package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import com.workintech.s18d4.util.Validation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService){
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> getAddressList(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable("id") long id){
        Validation.isIdValid(id);
        return addressService.find(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable("id")long id,@RequestBody Address address){
        Validation.isIdValid(id);
        return addressService.update(id,address);
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable("id") long id){
        return addressService.delete(id);
    }

}
