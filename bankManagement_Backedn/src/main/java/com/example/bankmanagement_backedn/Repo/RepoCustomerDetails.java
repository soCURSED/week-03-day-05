package com.example.bankmanagement_backedn.Repo;

import com.example.bankmanagement_backedn.Model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepoCustomerDetails extends JpaRepository<CustomerDetails,Integer> {


}
