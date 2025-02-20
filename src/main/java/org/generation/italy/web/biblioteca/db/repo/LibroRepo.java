package org.generation.italy.web.biblioteca.db.repo;

import java.util.List;
import org.generation.italy.web.biblioteca.db.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepo extends JpaRepository<Libro, Long> {

    List<Libro> findByTitoloContainingIgnoreCase(String titolo);
    List<Libro> findByAutoreContainingIgnoreCase(String autore);
    List<Libro> findByTitoloContainingIgnoreCaseAndAutoreContainingIgnoreCase(String titolo, String autore);

}