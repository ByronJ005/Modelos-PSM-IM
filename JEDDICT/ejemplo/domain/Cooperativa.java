package com.mycompany.ejemplo.domain;

import jakarta.persistence.Basic;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Asus
 */
@Entity
public class Cooperativa {

    @Id
    @GeneratedValue
    private Long id;
    @Basic
    private String nombre;
    @Basic
    private String urlSitio;
    @Basic
    private String telefonoContacto;
    @Basic
    private String activa;
    @OneToOne
    private Usuario administradorCooperativa;
    @OneToMany
    private List<Ruta> rutasOfrecidas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlSitio() {
        return urlSitio;
    }

    public void setUrlSitio(String urlSitio) {
        this.urlSitio = urlSitio;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getActiva() {
        return activa;
    }

    public void setActiva(String activa) {
        this.activa = activa;
    }

    public Usuario getAdministradorCooperativa() {
        return administradorCooperativa;
    }

    public void setAdministradorCooperativa(Usuario administradorCooperativa) {
        this.administradorCooperativa = administradorCooperativa;
    }

    public List<Ruta> getRutasOfrecidas() {
        if (rutasOfrecidas == null) {
            rutasOfrecidas = new ArrayList<>();
        }
        return rutasOfrecidas;
    }

    public void setRutasOfrecidas(List<Ruta> rutasOfrecidas) {
        this.rutasOfrecidas = rutasOfrecidas;
    }

    public void addRutasOfrecida(Ruta rutasOfrecida) {
        getRutasOfrecidas().add(rutasOfrecida);
    }

    public void removeRutasOfrecida(Ruta rutasOfrecida) {
        getRutasOfrecidas().remove(rutasOfrecida);
    }

}