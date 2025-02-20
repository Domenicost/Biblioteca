package org.generation.italy.web.biblioteca.db.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Libro {    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autore;
    private String titolo;
    private int copieDisp;

    @OneToMany(mappedBy = "libro", cascade = CascadeType.ALL)
    @JsonProperty("prestiti")
    private List<Prestito> prestiti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getCopieDisp() {
        return copieDisp;
    }

    public void setCopieDisp(int copieDisp) {
        this.copieDisp = copieDisp;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Libro [id=" + id + ", autore=" + autore + ", titolo=" + titolo + ", copieDisp=" + copieDisp + "]";
    }

}
