package org.generation.italy.web.biblioteca.controller;

import java.util.List;

import org.generation.italy.web.biblioteca.db.entity.Libro;
import org.generation.italy.web.biblioteca.db.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/libri")
public class LibroController {

    private LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Crea nuovo libro
    @PostMapping("/crea")
    public ResponseEntity<Libro> creaLibro(@RequestBody Libro libro) {
        Libro nuovoLibro = libroService.save(libro);
        return new ResponseEntity<>(nuovoLibro, HttpStatus.CREATED);
    }

    // Elenco libri (con filtro)
    @GetMapping
    public List<Libro> elencoLibri(@RequestParam(required = false) String titolo,
            @RequestParam(required = false) String autore) {
        return libroService.findAll(titolo, autore);
    }

    // Modifica libro
    @PutMapping("/modifica/{id}")
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDettagli) {
        Libro libroAggiornato = libroService.updateLibro(id, libroDettagli);
        return libroAggiornato != null ? ResponseEntity.ok(libroAggiornato) : ResponseEntity.notFound().build();
    }

    // Elimina libro
    @DeleteMapping("/elimina/{id}")
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        if (libroService.deleteLibro(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }
}
