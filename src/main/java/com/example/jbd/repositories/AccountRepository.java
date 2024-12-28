package com.example.jbd.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jbd.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID>{

}
