package com.example.bankmanagement_backedn.Contoller;

import ch.qos.logback.classic.Logger;
import com.example.bankmanagement_backedn.DTO.API;
import com.example.bankmanagement_backedn.Model.CustomerDetails;
import com.example.bankmanagement_backedn.Repo.RepoCustomerDetails;
import com.example.bankmanagement_backedn.Service.CustomerDetailsService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/customerDetails")
public class CustomerDetailsController {

    Logger logger= (Logger) LoggerFactory.getLogger(CustomerController.class);

    private final CustomerDetailsService customerDetailsService;

@GetMapping
    public ResponseEntity<List<CustomerDetails>> getCustomerDetails(){
    logger.info("getCustomerDetails is being used in CustomerDetailsController");

    return ResponseEntity.status(200).body(customerDetailsService.getAllDetails());

}

@PostMapping
    public ResponseEntity<CustomerDetails> addCustomerDetails(@RequestBody CustomerDetails customerDetails){
    logger.info("addCustomerDetails is being used in CustomerDetailsController");

    return ResponseEntity.status(200).body(customerDetailsService.addDetails(customerDetails));
}


@PutMapping("/deposit/{Id}/{amount}")
public ResponseEntity depositMony(@PathVariable Integer Id, @PathVariable Integer amount){
    logger.info("depositMony is being used in CustomerDetailsController");

    customerDetailsService.deposit(Id,amount);
    return ResponseEntity.status(200).body("deposited!");
}

    @PutMapping("/withdraw/{Id}/{amount}")
    public ResponseEntity withdrawMoney(@PathVariable Integer Id, @PathVariable Integer amount){
        logger.info("withdrawMoney is being used in CustomerDetailsController");

        customerDetailsService.withdraw(Id,amount);
        return ResponseEntity.status(200).body("Withdrawed!");
    }
}
