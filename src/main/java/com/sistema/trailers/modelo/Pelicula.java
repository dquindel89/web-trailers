package com.sistema.trailers.modelo;

import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer Id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String sinopsis;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate fechaEstreno;

    @NotBlank
    private String youtubeTrailerId;


    private String rutaPortada;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "genero_pelicula",
            joinColumns = @JoinColumn(name = "id_pelicula"),
            inverseJoinColumns = @JoinColumn(name = "id_genero"))
    private List<Genero> generos;


    @Transient
    private MultipartFile portada;


    public Pelicula() {
    }

    public Pelicula(Integer id, String titulo, String sinopsis, LocalDate fechaEstreno, String youtubeTrailerId, String rutaPortada, List<Genero> generos, MultipartFile portada) {
        Id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtubeTrailerId;
        this.rutaPortada = rutaPortada;
        this.generos = generos;
        this.portada = portada;
    }

    public Pelicula(String titulo, String sinopsis, LocalDate fechaEstreno, String youtubeTrailerId, String rutaPortada, List<Genero> generos, MultipartFile portada) {
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.fechaEstreno = fechaEstreno;
        this.youtubeTrailerId = youtubeTrailerId;
        this.rutaPortada = rutaPortada;
        this.generos = generos;
        this.portada = portada;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public LocalDate getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(LocalDate fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getYoutubeTrailerId() {
        return youtubeTrailerId;
    }

    public void setYoutubeTrailerId(String youtubeTrailerId) {
        this.youtubeTrailerId = youtubeTrailerId;
    }

    public String getRutaPortada() {
        return rutaPortada;
    }

    public void setRutaPortada(String rutaPortada) {
        this.rutaPortada = rutaPortada;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public MultipartFile getPortada() {
        return portada;
    }

    public void setPortada(MultipartFile portada) {
        this.portada = portada;
    }
}
