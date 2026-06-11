package com.wellsfargo.counselor.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long portfolioID;

    @ManyToOne
    @JoinColumn(name = "clientID")
    private Client client;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "portfolio")
    private List securities;

    public Portfolio(Long portfolioID, Client client,
            LocalDateTime creationDate,
            List securities) {
        this.portfolioID = portfolioID;
        this.client = client;
        this.creationDate = creationDate;
        this.securities = securities;
    }

    public Portfolio() {
    }

    public Portfolio(List securities) {
        this.securities = securities;
    }

    public Long getPortfolioID() {
        return portfolioID;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public List getSecurities() {
        return securities;
    }

    public void setSecurities(List securities) {
        this.securities = securities;
    }
}
