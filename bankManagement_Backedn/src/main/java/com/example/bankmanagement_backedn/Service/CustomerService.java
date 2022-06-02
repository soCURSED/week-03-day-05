package com.example.bankmanagement_backedn.Service;


import com.example.bankmanagement_backedn.Model.Bank;
import com.example.bankmanagement_backedn.Model.CustomerDetails;
import com.example.bankmanagement_backedn.Model.Customers;
import com.example.bankmanagement_backedn.Repo.RepoBank;
import com.example.bankmanagement_backedn.Repo.RepoCustomer;
import com.example.bankmanagement_backedn.Repo.RepoCustomerDetails;
import com.example.bankmanagement_backedn.exception.InvalidIDException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service @AllArgsConstructor
public class CustomerService {

    private final RepoCustomer repoCustomer;
    private final RepoCustomerDetails repoCustomerDetails;
    private final RepoBank repoBank;
    private final BankService bankService;
    private final CustomerDetailsService customerDetailsService;


    public List<Customers> getAllCustomers() {
        return repoCustomer.findAll();
    }

    public Customers addCustomers(Customers customers) {
        return repoCustomer.save(customers);

    }

    public void addDetailToCustomer(Integer customer_id , Integer customer_details_id)
    {
        Optional<Customers> customers = repoCustomer.findById(customer_id);
        if(customers.isEmpty()){
            throw new InvalidIDException("Invalid user id");
        }
        Optional<CustomerDetails>customerDetails=repoCustomerDetails.findById(customer_details_id);
        if(customerDetails.isEmpty()){
            throw new InvalidIDException("Invalid customer id");
        }
        customers.get().setCustomerDetails(customerDetails.get());
        repoCustomer.save(customers.get());


    }
    public void addBanktoCustomer(Integer customer_id,Integer bank_id)
    {
        Optional<Customers> customers= repoCustomer.findById(customer_id);
        if(customers.isEmpty()){
            throw new InvalidIDException("Invalid user id");
        }
        Optional<Bank>bank = repoBank.findById(bank_id);
        if(bank.isEmpty()){
            throw new InvalidIDException("Invalid bank id");
        }
        customers.get().getBanks().add(bank.get());
        repoCustomer.save(customers.get());
    }





}
