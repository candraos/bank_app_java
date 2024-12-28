package com.example.jbd.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="accounts")
@Getter
@Setter
@Audited
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_id")
    private UUID id;

    @Column
    private Float balance;

    @Column
    private String status;

    @ManyToOne
    @JoinColumn(name="account_holder_id")
    private AccountHolder accountHolder;

    @ManyToMany
    private Set<Card> cards = new HashSet<>();
}
