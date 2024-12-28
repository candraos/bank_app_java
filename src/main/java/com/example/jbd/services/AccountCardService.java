package com.example.jbd.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbd.models.Account;
import com.example.jbd.models.AccountCard;
import com.example.jbd.models.Card;
import com.example.jbd.repositories.AccountCardRepository;
import com.example.jbd.repositories.AccountRepository;
import com.example.jbd.repositories.CardRepository;

@Service
public class AccountCardService {

    @Autowired
    AccountCardRepository accountCardRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CardRepository cardRepository;

    public UUID linkedAccountToCard(UUID accountId, UUID cardId) throws Exception{
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<Card> card = cardRepository.findById(cardId);
        if(!account.isPresent() || !card.isPresent()){
            throw new Exception();
        }
        AccountCard savedAccountCard = new AccountCard();
        savedAccountCard.setAccount(account.get());
        savedAccountCard.setCard(card.get());
        accountCardRepository.save(savedAccountCard);

        return savedAccountCard.getId();

    }
}
