package com.example.bankmanagement_backedn.Repo;

import com.example.bankmanagement_backedn.Model.CustomerDetails;
import com.example.bankmanagement_backedn.Model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoCustomer extends JpaRepository<Customers,Integer> {



}
