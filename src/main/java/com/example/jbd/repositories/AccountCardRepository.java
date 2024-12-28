package com.example.jbd.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.jbd.models.AccountCard;

@Repository
public interface AccountCardRepository extends JpaRepository<AccountCard,UUID>{

}
