package com.mycompany.ejemplo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

/**
 * @author Asus
 */
@Entity
public class Reserva {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String fecha;
    @Basic
    private String hora;
    @Basic
    private String asiento;
    @Basic
    private String estadoReserva;
    @ManyToOne
    private Usuario pasajero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Usuario getPasajero() {
        return pasajero;
    }

    public void setPasajero(Usuario pasajero) {
        this.pasajero = pasajero;
    }

}