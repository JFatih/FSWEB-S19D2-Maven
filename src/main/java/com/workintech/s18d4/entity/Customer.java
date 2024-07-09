package com.workintech.s18d4.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Customer",schema="public")
public class Customer {

    @Id
    @GeneratedValue()
    private long id;


    @Column(name="first_name")
    private String firstName;


    @Column(name="last_name")
    private String lastName;


    private String email;


    private Double salary;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;

    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
    private List<Account> accounts = new ArrayList<>();
}
