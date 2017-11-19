package com.krzywus.bkl4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int transferId;

    @Column(name = "username")
    private String username;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "account")
    private String account;

    @Column(name = "amount")
    private String amount;

    @Column(name = "title")
    private String title;

}