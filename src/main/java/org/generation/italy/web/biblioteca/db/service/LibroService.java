package org.generation.italy.web.biblioteca.db.service;

import java.util.List;
import java.util.Optional;

import org.generation.italy.web.biblioteca.db.entity.Libro;
import org.generation.italy.web.biblioteca.db.repo.LibroRepo;
import org.generation.italy.web.biblioteca.db.repo.PrestitoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroService {

    @Autowired
    private LibroRepo libroRepo;

    @Autowired
    private PrestitoRepo prestitoRepo;


    public Libro save(Libro libro) {
        return libroRepo.save(libro);
    }

    public List<Libro> findAll(String titolo, String autore) {
        if (titolo != null && autore != null) {
            return libroRepo.findByTitoloContainingIgnoreCaseAndAutoreContainingIgnoreCase(titolo, autore);
        } else if (titolo != null) {
            return libroRepo.findByTitoloContainingIgnoreCase(titolo);
        } else if (autore != null) {
            return libroRepo.findByAutoreContainingIgnoreCase(autore);
        } else {
            return libroRepo.findAll();
        }
    }

    public Libro updateLibro(Long id, Libro libroDettagli) {
        Optional<Libro> libroEsistente = libroRepo.findById(id);
        
        if (libroEsistente.isPresent()) {
            Libro libro = libroEsistente.get();
            libro.setTitolo(libroDettagli.getTitolo());
            libro.setAutore(libroDettagli.getAutore());
            libro.setCopieDisp(libroDettagli.getCopieDisp());
            return libroRepo.save(libro);
        }
        return null;
    }

    public boolean deleteLibro(Long id) {
        Libro libro = libroRepo.findById(id).orElse(null);
        if (libro != null) {
            if (prestitoRepo.existsByLibro(libro)) {
                return false;
            }
            libroRepo.delete(libro);
            return true;
        }
        return false;
    }
}
