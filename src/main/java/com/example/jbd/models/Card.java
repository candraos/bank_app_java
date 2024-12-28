package com.example.jbd.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="cards")
@Getter
@Setter
@Audited
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="card_id")
    private UUID id;

    @Column(name="card_number")
    private String cardNumber;

    @Column(name="expiry_date")
    private LocalDate expiryDate;

    @Column(name="cvv")
    private String cvv;

    @ManyToMany
    private Set<Account> accounts = new HashSet<>();
}
