package com.example.bankmanagement_backedn.Service;


import com.example.bankmanagement_backedn.Model.CustomerDetails;
import com.example.bankmanagement_backedn.Model.Customers;
import com.example.bankmanagement_backedn.Repo.RepoCustomer;
import com.example.bankmanagement_backedn.Repo.RepoCustomerDetails;
import com.example.bankmanagement_backedn.exception.InvalidIDException;
import com.example.bankmanagement_backedn.exception.NoFundsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class CustomerDetailsService {
    private final RepoCustomerDetails repoCustomerDetails;
    private final RepoCustomer repoCustomer;


    public List<CustomerDetails> getAllDetails() {
      return repoCustomerDetails.findAll();
    }

    public CustomerDetails addDetails(CustomerDetails customerDetails) {
       return repoCustomerDetails.save(customerDetails);

    }

    public void deposit(Integer Id, Integer amount) {
       Optional<CustomerDetails> customerDetails =  repoCustomerDetails.findById(Id);
       if (customerDetails.isEmpty()){
           throw new InvalidIDException("Customer ID not found");
       }

        customerDetails.get().setBalance(customerDetails.get().getBalance()+amount);
           repoCustomerDetails.save(customerDetails.get());
       }

    public void withdraw(Integer Id, Integer amount) {
        Optional<CustomerDetails> customerDetails =  repoCustomerDetails.findById(Id);
        if (customerDetails.isEmpty()){
            throw new InvalidIDException("Customer ID not found");
        }
        if (customerDetails.get().getBalance()<amount){
            throw new NoFundsException("No money to withdraw");
        }
        customerDetails.get().setBalance(customerDetails.get().getBalance()-amount);
        repoCustomerDetails.save(customerDetails.get());
    }
}





