package com.example.jbd.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbd.DTO.CardResponseDTO;
import com.example.jbd.DTO.FindByCvvDTO;
import com.example.jbd.models.Card;
import com.example.jbd.services.CardService;

@RestController()
@RequestMapping("/card")
public class CardController {


    @Autowired
    CardService cardService;

    @Autowired
    ModelMapper modelMapper;


    @PostMapping("/create-card")
    public ResponseEntity<Card> createCard(){
        Card card = cardService.createCard();
        return new ResponseEntity<>(card,HttpStatus.CREATED);
    }

    @GetMapping("/find-card-by-cvv")
    public ResponseEntity<CardResponseDTO> findByCvv(@RequestBody FindByCvvDTO cvvDTO){
        Card card = cardService.findCardByCvv(cvvDTO.getCvv());

        CardResponseDTO cardResponseDTO = modelMapper.map(card, CardResponseDTO.class);

        return new ResponseEntity<CardResponseDTO>(cardResponseDTO, HttpStatus.FOUND);
    }
}
