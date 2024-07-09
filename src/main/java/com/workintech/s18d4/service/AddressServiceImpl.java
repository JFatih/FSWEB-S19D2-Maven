package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.exception.EntityException;
import com.workintech.s18d4.repository.AddressRepository;
import com.workintech.s18d4.util.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address find(long id) {
        if(addressRepository.findById(id).isPresent()){
            return addressRepository.findById(id).get();
        }else{
            Validation.idIsNotExist();
            return null;
        }
    }

    @Override
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(long id, Address address) {
        if(addressRepository.findById(id).isPresent()){
            address.setId(id);
            return addressRepository.save(address);
        }else {
            Validation.idIsNotExist();
            return null;
        }
    }

    @Override
    public Address delete(long id) {
        if(addressRepository.findById(id).isPresent()){
            Address address = addressRepository.findById(id).get();
            addressRepository.delete(address);
            return address;
        }else{
            Validation.idIsNotExist();
            return null;
        }
    }
}
