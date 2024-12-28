package com.example.jbd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbd.models.AccountHolder;
import com.example.jbd.services.AccountHolderService;

@RestController
@RequestMapping("/account-holder")
public class AccountHolderController {


    @Autowired
    AccountHolderService accountHolderService;

    @PostMapping("create-account-holder")
    public ResponseEntity<AccountHolder> createAccountHolder(@RequestBody AccountHolder accountHolder){
        AccountHolder createdAccountHolder = accountHolderService.createAccountHolder(accountHolder);
        return new ResponseEntity<>(createdAccountHolder,HttpStatus.CREATED);
    }
}
