package org.generation.italy.web.biblioteca.controller;

import java.util.List;

import org.generation.italy.web.biblioteca.db.entity.Utente;
import org.generation.italy.web.biblioteca.db.service.UtenteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utenti")
public class UtenteController {

    private UtenteService utenteService;

    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    // Elenco utenti con prestiti
    @GetMapping
    public List<Utente> elencoUtenti() {
        return utenteService.findAll();
    }

    // Crea nuovo utente
    @PostMapping("/crea")
    public ResponseEntity<Utente> creaUtente(@RequestBody Utente utente) {
        Utente nuovoUtente = utenteService.save(utente);
        return new ResponseEntity<>(nuovoUtente, HttpStatus.CREATED);
    }

    

}
