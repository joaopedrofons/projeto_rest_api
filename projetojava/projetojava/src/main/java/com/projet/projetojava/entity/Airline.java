package com.projet.projetojava.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Airplane> airplanes = new ArrayList<>();

    public Airline() {
    }

    public Airline(String name) {
        this.name = name;
    }

    public void addAirplane(Airplane airplane) {
        this.airplanes.add(airplane);
        if (airplane.getAirline() != this) {
            airplane.setAirline(this);
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Airplane> getAirplanes() {
        return new ArrayList<>(this.airplanes);
    }

    public void setAirplanes(List<Airplane> airplanes) {
        this.airplanes = new ArrayList<>(airplanes);
    }
}
