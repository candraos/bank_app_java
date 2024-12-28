package com.example.jbd.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbd.models.Account;
import com.example.jbd.models.AccountHolder;
import com.example.jbd.repositories.AccountHolderRepository;
import com.example.jbd.repositories.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // for logging
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHolderRepository accountHolderRepository;

    public Account createAccount(Account account) throws Exception{

        log.debug("creating account {}",account);

        //select account holder
        Optional<AccountHolder> accountHolder = accountHolderRepository.findById(account.getAccountHolder().getId());
        if(accountHolder.isPresent()){
            //set account holder data in account from optional variable
            account.setAccountHolder(accountHolder.get());
            //and save it
            Account savedAccount = accountRepository.save(account);
            return savedAccount;
        }else{
            throw new Exception();
        }
    }

    public Account updateAccount(Account account, UUID id) throws Exception{
        //check if account is already present
        Optional<Account> dbAccount = accountRepository.findById(id);
        if(dbAccount.isPresent()){ //set id to not create a new record and save
            account.setId(id);
            return accountRepository.save(account);

        }else throw new Exception();
    }

    public Float modifyBalance(Float balance, UUID accountId) throws Exception{
        Optional<Account> dbAccount = accountRepository.findById(accountId);
        if(dbAccount.isPresent()){ 
            dbAccount.get().setBalance(balance); //get first to get the account in question (because db account is optional)
            accountRepository.save(dbAccount.get());
            return dbAccount.get().getBalance();
        }else throw new Exception();
    }
}
