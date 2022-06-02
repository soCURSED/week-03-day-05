package com.example.bankmanagement_backedn.Contoller;

import ch.qos.logback.classic.Logger;
import com.example.bankmanagement_backedn.Model.Bank;
import com.example.bankmanagement_backedn.Model.Customers;
import com.example.bankmanagement_backedn.Service.BankService;
import com.example.bankmanagement_backedn.Service.CustomerDetailsService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequiredArgsConstructor
@RequestMapping("/api/v1/bank")
public class BankController {

    Logger logger= (Logger) LoggerFactory.getLogger(BankController.class);

    private final BankService bankService;


    @GetMapping
    public ResponseEntity<List<Bank>> getBanks(){
        logger.info("getBanks is being used in BankController");
        return ResponseEntity.status(200).body(bankService.getAllBanks());

    }

    @PostMapping
    public ResponseEntity<Bank> addBank(@RequestBody Bank bank){
        logger.info("addBank is being used in BankController");
        return ResponseEntity.status(200).body(bankService.addBank(bank));
    }

//    @PostMapping("/withdraw/{id}/{amount}")
//    public ResponseEntity withdrawMoeny(@PathVariable Integer id,@PathVariable Integer amount){
//
//        return ResponseEntity.status(200).body(bankService.withdrawMoeny(id,amount));
//
//    }



}
