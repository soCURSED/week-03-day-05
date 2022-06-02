package com.example.bankmanagement_backedn.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@AllArgsConstructor @NoArgsConstructor
@Entity @Data @Valid
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(nullable = false,unique = true)
    private Integer Id;
    @NotEmpty(message = "Age most not be empty!")
    private String age;
    @NotNull(message = "Balance most not be empty!")
    private Integer balance;

    //
    //


    @OneToOne(mappedBy = "customerDetails",cascade = CascadeType.MERGE)
    private Customers customer;
}
