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
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(nullable = false,unique = true)
    private Integer Id;
    @NotEmpty(message = "userName most not be empty!")
    private String userName;



    //
    //
    @OneToOne(cascade = CascadeType.MERGE)
    @JsonIgnore
    @PrimaryKeyJoinColumn
    private CustomerDetails customerDetails;

    @OneToMany(cascade = CascadeType.MERGE)
    private Set<Bank> banks;


}
