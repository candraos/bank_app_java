package com.example.jbd.controllers;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbd.DTO.AccountRequestDTO;
import com.example.jbd.DTO.AccountResponseDTO;
import com.example.jbd.models.Account;
import com.example.jbd.services.AccountService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    AccountService accountService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("create-account")
    public ResponseEntity<AccountResponseDTO> createAccount (@RequestBody @Valid AccountRequestDTO accountRequestDTO) throws Exception{
        // Account account = new Account();//map account request dto to account
        // account.setBalance(accountRequestDTO.getBalance());
        // account.setStatus(accountRequestDTO.getStatus());
        // account.setAccountHolder(accountRequestDTO.getAccountHolder());

        Account account = modelMapper.map(accountRequestDTO,Account.class); // auto maps from source to destination
        
        Account createdAccount = accountService.createAccount(account);

        // AccountResponseDTO accountResponseDTO = new AccountResponseDTO();//map account to acount response dto
        // accountResponseDTO.setBalance(createdAccount.getBalance());
        // accountResponseDTO.setId(createdAccount.getId());
        // accountResponseDTO.setStatus(createdAccount.getStatus());

        AccountResponseDTO accountResponseDTO = modelMapper.map(createdAccount,AccountResponseDTO.class);
         // auto maps from source to destination

         accountResponseDTO.setAccountHolderId(createdAccount.getAccountHolder().getId());

        return new ResponseEntity<>(accountResponseDTO,HttpStatus.CREATED);
    }

    @PutMapping("update-account/{accountId}")
    public void updateAccount(@PathVariable UUID accountId, @RequestBody Account account) throws Exception{
        accountService.updateAccount(account, accountId);
    }

    @PatchMapping("patch-account/{id}/{balance}")
    public ResponseEntity<Float> patchAccount (@PathVariable UUID id,@PathVariable Float balance) throws Exception{
        Float newBalance  = accountService.modifyBalance(balance, id);
        return new ResponseEntity<>(newBalance,HttpStatus.ACCEPTED);
    }

}
