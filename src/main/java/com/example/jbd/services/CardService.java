package com.example.jbd.services;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbd.models.Card;
import com.example.jbd.repositories.CardRepository;

@Service
public class CardService {


    @Autowired
    CardRepository cardRepository;


    public Card createCard(){
        Card card = new Card();
        card.setExpiryDate(LocalDate.now().plusYears(3));
        card.setCvv(String.valueOf(new Random().nextInt(900)+100));
        card.setCardNumber(generateCardNumber());
        cardRepository.save(card);
        return card;
    }

    public String generateCardNumber(){
        String bin = "12345678";//first 8 numbers of the card
        Random random = new Random();
        StringBuilder randomDigits = new StringBuilder();
        for(int i=0;i<7;i++){
            randomDigits.append(random.nextInt(10));
        }
        String cardNumber = bin + randomDigits;
        return cardNumber;
    }

    public Card findCardByCvv(String cvv){
        Card card = cardRepository.findByCvv(cvv);
        return card;
    }
}
