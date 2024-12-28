package com.example.jbd.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jbd.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card,UUID>{

    public Card findByCvv(String cvv);

}
