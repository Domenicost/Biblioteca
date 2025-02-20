package org.generation.italy.web.biblioteca.db.repo;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.web.biblioteca.db.entity.Libro;
import org.generation.italy.web.biblioteca.db.entity.Prestito;
import org.generation.italy.web.biblioteca.db.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestitoRepo extends JpaRepository<Prestito, Long> {

    Prestito findByLibroAndUtente(Libro libro, Utente utente);

    boolean existsByLibro(Libro libro);

    // Trova i prestiti con dataInizio tra due date
    List<Prestito> findByDataInizioBetween(LocalDate dataInizioDa, LocalDate dataInizioA);

    // Trova i prestiti con dataInizio tra due date e con dataFine == null (non restituiti)
    List<Prestito> findByDataInizioBetweenAndDataFineIsNull(LocalDate dataInizioDa, LocalDate dataInizioA);

    // Trova i prestiti con dataInizio tra due date e con dataFine != null (restituiti)
    List<Prestito> findByDataInizioBetweenAndDataFineIsNotNull(LocalDate dataInizioDa, LocalDate dataInizioA);
}
