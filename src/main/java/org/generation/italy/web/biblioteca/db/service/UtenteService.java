package org.generation.italy.web.biblioteca.db.service;

import java.util.List;

import org.generation.italy.web.biblioteca.db.entity.Utente;
import org.generation.italy.web.biblioteca.db.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;  

@Service
public class UtenteService {

    @Autowired
    private UtenteRepo utenteRepo;

    public List<Utente> findAll() {
        return utenteRepo.findAllWithPrestiti();
    }

    public Utente save(Utente utente) {
        return utenteRepo.save(utente);
    }

}
