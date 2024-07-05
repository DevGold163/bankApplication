package com.example.demo.controller;

import com.example.demo.model.AccountTransactions;
import com.example.demo.repository.AccountTransactionsRepository;
import com.example.demo.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public class BankController {


    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private AccountTransactionsRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransactions> getBankControllerDetails(@RequestParam int id){

        List<AccountTransactions> accountTransactions=accountTransactionsRepository.findByCustomerIdOrderByTransactionDtDesc(id);


        return accountTransactions!=null?accountTransactions:null;
    }



}
