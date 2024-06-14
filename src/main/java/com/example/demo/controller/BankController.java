package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class BankController {

    @GetMapping("/myBalance")
    public String getBankControllerDetails(){
        return "Here are the account details from the DB";
    }



}
