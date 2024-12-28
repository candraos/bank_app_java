package com.example.jbd.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.hibernate.envers.Audited;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="account_holder")
@Getter
@Setter
@Audited
public class AccountHolder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="account_holder_id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private LocalDate dob;

    @Column(name = "mother_name")
    private String motherName;

    @OneToMany(mappedBy = "accountHolder")
    private List<Account> accounts = new ArrayList<Account>();
}
