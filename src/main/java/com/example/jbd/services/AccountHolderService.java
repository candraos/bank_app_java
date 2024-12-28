package com.example.jbd.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbd.models.AccountHolder;
import com.example.jbd.repositories.AccountHolderRepository;

@Service
public class AccountHolderService {

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public AccountHolder createAccountHolder(AccountHolder accountHolder){
        return accountHolderRepository.save(accountHolder);

    }

    public Optional<AccountHolder> getById(UUID id){
        return accountHolderRepository.findById(id);

    }

    public void deleteById(UUID id){
         accountHolderRepository.deleteById(id);
    }
}
