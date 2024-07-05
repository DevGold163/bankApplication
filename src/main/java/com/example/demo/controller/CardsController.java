package com.example.demo.controller;

import com.example.demo.model.Cards;
import com.example.demo.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

@RestController
public class CardsController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping("/myCards")
    public List<Cards> getCardDetails(@RequestParam int id){

        List<Cards>  cards =  cardRepository.findByCustomerId(id);
        return cards!=null?cards:null;
    }



}
