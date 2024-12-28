package com.example.jbd.DTO;

import java.time.LocalDate;

import java.util.UUID;


import lombok.Data;

@Data
public class CardResponseDTO {
 
    private UUID id;

    private String cardNumber;

    private LocalDate expiryDate;

    private String cvv;

}
