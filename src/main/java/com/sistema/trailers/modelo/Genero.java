package com.sistema.trailers.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Genero {

    @Id
    @Column(name = "id_genero")
    private Integer id;

    private String titulo;

    public Genero(Integer id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Genero() {
    }

    public Genero(Integer id) {
        this.id = id;
    }

    public Genero(String titulo) {
        this.titulo = titulo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
