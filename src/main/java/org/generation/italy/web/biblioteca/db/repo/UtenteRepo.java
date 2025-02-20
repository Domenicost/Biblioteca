package org.generation.italy.web.biblioteca.db.repo;

import java.util.List;

import org.generation.italy.web.biblioteca.db.entity.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, Long> {

    @Query("SELECT u FROM Utente u LEFT JOIN FETCH u.prestiti")
    List<Utente> findAllWithPrestiti();

}
