package com.broker.entities;

import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "quotes")
@Data
public class Quote {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String base_currency;

    @Column(nullable = false)
    private String quoted_currency;

    @Column(nullable = true)
    private String bid;

    @Column(nullable = true)
    private String ask;

    @Column(nullable = false, unique = true)
    private String requestId;

    @Column
    private String receivedRequestId;

    @Column(nullable = false)
    private Instant dateCreated;

}
