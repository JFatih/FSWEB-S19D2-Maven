package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Address",schema="public")
public class Address {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;


    private String street;


    private int no;


    private String city;


    private String country;

    private String description;

    @OneToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Customer customer;

}
