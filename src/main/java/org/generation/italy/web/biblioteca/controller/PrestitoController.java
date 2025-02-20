package org.generation.italy.web.biblioteca.controller;

import java.time.LocalDate;
import java.util.List;

import org.generation.italy.web.biblioteca.db.entity.Prestito;
import org.generation.italy.web.biblioteca.db.service.PrestitoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prestiti")
public class PrestitoController {

    private PrestitoService prestitoService;

    public PrestitoController(PrestitoService prestitoService) {
        this.prestitoService = prestitoService;
    }

    // Aggiungi prestito
    @PostMapping("/aggiungi/{libroId}/{utenteId}")
    public ResponseEntity<String> addPrestito(@PathVariable Long libroId, @PathVariable Long utenteId) {
        if (prestitoService.addPrestito(libroId, utenteId)) {
            return ResponseEntity.ok("Prestito registrato con successo!");
        }
        return ResponseEntity.badRequest().body("Errore: libro non disponibile o utente non esistente.");
    }

    // Restituisci libro
    @PostMapping("/restituisci/{libroId}/{utenteId}")
    public ResponseEntity<String> restituisciLibro(@PathVariable Long libroId, @PathVariable Long utenteId) {
        if (prestitoService.restituisciLibro(libroId, utenteId)) {
            return ResponseEntity.ok("Libro restituito con successo!");
        }
        return ResponseEntity.badRequest().body("Errore: libro non prestato o utente non esistente.");
    }

    // Elenco prestiti
    @GetMapping
    public ResponseEntity<List<Prestito>> elencoPrestiti(@RequestParam(required = false) LocalDate dataInizioDa, @RequestParam(required = false) LocalDate dataInizioA, @RequestParam(required = false) LocalDate dataFineDa, @RequestParam(required = false) LocalDate dataFineA, @RequestParam(required = false) Boolean nonRestituiti) {
        List<Prestito> prestiti = prestitoService.findAll(dataInizioDa, dataInizioA, nonRestituiti);
        return ResponseEntity.ok(prestiti);
    }

}
