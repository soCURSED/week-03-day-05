package com.example.bankmanagement_backedn.Service;


import com.example.bankmanagement_backedn.Model.Bank;
import com.example.bankmanagement_backedn.Model.CustomerDetails;
import com.example.bankmanagement_backedn.Model.Customers;
import com.example.bankmanagement_backedn.Repo.RepoBank;
import com.example.bankmanagement_backedn.Repo.RepoCustomer;
import com.example.bankmanagement_backedn.Repo.RepoCustomerDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class BankService {
 private final RepoBank repoBank;




    public List<Bank> getAllBanks() {
        return repoBank.findAll();
    }

    public Bank addBank(Bank bank) {
        return repoBank.save(bank);

    }


}
