package com.example.bankmanagement_backedn.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Entity @Valid @Data
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(nullable = false,unique = true)
    private Integer id;

    @NotEmpty(message = "name most not be empty!")
    private String name;


    @ManyToOne(cascade = CascadeType.MERGE)
    private Customers customers;
 }
