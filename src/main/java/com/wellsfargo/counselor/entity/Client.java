package com.wellsfargo.counselor.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;

    @ManyToOne
    @JoinColumn(name = "advisorID")
    private Advisor advisor;

    @Column
    private String name;

    @Column
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Portfolio> portfolios;

    public Client(Long clientID, Advisor advisor, String name,
            String email, List<Portfolio> portfolios) {
        this.clientID = clientID;
        this.advisor = advisor;
        this.name = name;
        this.email = email;
        this.portfolios = portfolios;
    }

    public Client() {
    }

    public Long getClientID() {
        return clientID;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Portfolio> getPortfolios() {
        return portfolios;
    }

    public void setPortfolios(List<Portfolio> portfolios) {
        this.portfolios = portfolios;
    }
}
