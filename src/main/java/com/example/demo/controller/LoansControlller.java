package com.example.demo.controller;

import com.example.demo.model.Loans;
import com.example.demo.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansControlller {

    @Autowired
    private LoanRepository loanRepository;

    @GetMapping("/myLoans")
    public List<Loans> getLoansDetails(@RequestParam int id){

        List<Loans> loans =  loanRepository.findByCustomerIdOrderByStartDtDesc(id);
        return loans!=null?loans:null;
    }



}
