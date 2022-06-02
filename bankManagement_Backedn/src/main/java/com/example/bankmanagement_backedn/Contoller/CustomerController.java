package com.example.bankmanagement_backedn.Contoller;

import ch.qos.logback.classic.Logger;
import com.example.bankmanagement_backedn.Model.CustomerDetails;
import com.example.bankmanagement_backedn.Model.Customers;
import com.example.bankmanagement_backedn.Repo.RepoCustomer;
import com.example.bankmanagement_backedn.Service.CustomerDetailsService;
import com.example.bankmanagement_backedn.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    Logger logger= (Logger) LoggerFactory.getLogger(CustomerController.class);

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customers>> getCustomers(){
        logger.info("getCustomers is being used in CustomerController");
        return ResponseEntity.status(200).body(customerService.getAllCustomers());

    }

    @PostMapping
    public ResponseEntity<Customers> addCustomer(@RequestBody Customers customers){
        logger.info("addCustomer is being used in CustomerController");
        return ResponseEntity.status(200).body(customerService.addCustomers(customers));
    }


    @PostMapping("details/add/{customer_id}/{customer_details_id}")
    public ResponseEntity addDetailToCustomer(@PathVariable Integer customer_id, @PathVariable Integer customer_details_id)
    {
        logger.info("a customer details are being added through addCustomerDetails() - CustomerController");

        customerService.addDetailToCustomer(customer_id,customer_details_id);
        return ResponseEntity.status(201).body("Customer details added to customer");
    }
    @PostMapping("bank/add/{customer_id}/{bank_id}")
    public ResponseEntity addBank(@PathVariable Integer customer_id, @PathVariable Integer bank_id)
    {
        logger.info("a bank is being added to customer through addBank() - CustomerController");
        customerService.addBanktoCustomer(customer_id,bank_id);
        return ResponseEntity.status(201).body("Bank added to customer");
    }


}
