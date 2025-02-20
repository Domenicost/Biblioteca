package org.generation.italy.web.biblioteca.db.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Prestito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInizio;
    private LocalDate dataFine;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty("utente")
    private Utente utente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonProperty("libro")
    private Libro libro;

    public Prestito(Libro libro, Utente utente) {
        this.libro = libro;
        this.utente = utente;
        this.dataInizio = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
    @Override
    public String toString() {
        return "Prestito [id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + "]";
    }

    

    
}