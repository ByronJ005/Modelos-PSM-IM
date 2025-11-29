package com.mycompany.ejemplo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
@Entity
public class Bus {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String placa;
    @Basic
    private String modelo;
    @Basic
    private String capacidad;
    @Basic
    private String estadoBus;
    @OneToMany
    private List<Turno> turnos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstadoBus() {
        return estadoBus;
    }

    public void setEstadoBus(String estadoBus) {
        this.estadoBus = estadoBus;
    }

    public List<Turno> getTurnos() {
        if (turnos == null) {
            turnos = new ArrayList<>();
        }
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void addTurno(Turno turno) {
        getTurnos().add(turno);
    }

    public void removeTurno(Turno turno) {
        getTurnos().remove(turno);
    }

}