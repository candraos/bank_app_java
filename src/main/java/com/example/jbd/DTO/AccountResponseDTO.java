package com.example.jbd.DTO;


import java.util.UUID;

import lombok.Data;



@Data
public class AccountResponseDTO {
 
    private UUID id;

    private Float balance;
    
    private String status;

    private UUID accountHolderId;

    

}
