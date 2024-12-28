package com.example.jbd.models;

import java.util.UUID;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="account_card")
@Getter
@Setter
@Audited
public class AccountCard {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_card_id")
    private UUID id;

     @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="card_id")
    private Card card;
}
