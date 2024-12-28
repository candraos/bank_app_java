package com.example.jbd.DTO;


import com.example.jbd.models.AccountHolder;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data //give getter and setter
public class AccountRequestDTO { 
  
    //from this class we removed id because we are never sending an id in the request to create
    //and cards because we create them separately and then we link them together

    @NotNull(message = "Balance cannot be null")//message only on logs
    @Positive(message = "Balance must be positive")
    private Float balance;
    @NotBlank(message = "Status cannot be blank")
    private String status;

   
    private AccountHolder accountHolder;

}
