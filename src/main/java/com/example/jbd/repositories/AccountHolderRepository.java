package com.example.jbd.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jbd.models.AccountHolder;

@Repository
public interface AccountHolderRepository extends JpaRepository<AccountHolder,UUID> {

}
