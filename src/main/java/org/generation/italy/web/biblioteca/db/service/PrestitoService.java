package org.generation.italy.web.biblioteca.db.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.generation.italy.web.biblioteca.db.entity.Libro;
import org.generation.italy.web.biblioteca.db.entity.Prestito;
import org.generation.italy.web.biblioteca.db.entity.Utente;
import org.generation.italy.web.biblioteca.db.repo.LibroRepo;
import org.generation.italy.web.biblioteca.db.repo.PrestitoRepo;
import org.generation.italy.web.biblioteca.db.repo.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestitoService {

    @Autowired
    private PrestitoRepo prestitoRepo;

    @Autowired
    private LibroRepo libroRepo;

    @Autowired
    private UtenteRepo utenteRepo;

    public PrestitoService(LibroRepo libroRepo, PrestitoRepo prestitoRepo, UtenteRepo utenteRepo) {
        this.libroRepo = libroRepo;
        this.prestitoRepo = prestitoRepo;
        this.utenteRepo = utenteRepo;
    }

    public List<Prestito> findAll(LocalDate dataInizioDa, LocalDate dataInizioA, Boolean nonRestituiti) {
        // Se la data di inizio non viene specificata, assumiamo i valori minimi e massimi per la ricerca
        if (dataInizioDa == null) {
            dataInizioDa = LocalDate.MIN;
        }
        if (dataInizioA == null) {
            dataInizioA = LocalDate.MAX;
        }
    
        // Se nonRestituiti è null, ritorniamo tutti i prestiti che rientrano nel range di date
        if (nonRestituiti == null) {
            return prestitoRepo.findByDataInizioBetween(dataInizioDa, dataInizioA);
        }
        
        // Se nonRestituiti è true, cerchiamo i prestiti con dataFine == null (ancora in corso)
        if (nonRestituiti) {
            return prestitoRepo.findByDataInizioBetweenAndDataFineIsNull(dataInizioDa, dataInizioA);
        } 
        // Se nonRestituiti è false, cerchiamo i prestiti con dataFine != null (restituiti)
        else {
            return prestitoRepo.findByDataInizioBetweenAndDataFineIsNotNull(dataInizioDa, dataInizioA);
        }
    }
    
    public Prestito save(Prestito prestito) {
        return prestitoRepo.save(prestito);
    }

    public boolean addPrestito(Long libroId, Long utenteId) {
        Optional<Libro> libroOptional = libroRepo.findById(libroId);
        Optional<Utente> utenteOptional = utenteRepo.findById(utenteId);

        if (libroOptional.isPresent() && utenteOptional.isPresent()) {
            Libro libro = libroOptional.get();
            Utente utente = utenteOptional.get();

            if (libro.getCopieDisp() > 0) {
                Prestito prestito = new Prestito(libro, utente);
                prestitoRepo.save(prestito);

                libro.setCopieDisp(libro.getCopieDisp() - 1);
                libroRepo.save(libro);

                return true;
            }
        }
        return false;
    }

    // Restituisci libro
    public boolean restituisciLibro(Long libroId, Long utenteId) {
        Optional<Libro> libroOptional = libroRepo.findById(libroId);
        Optional<Utente> utenteOptional = utenteRepo.findById(utenteId);

        if (libroOptional.isPresent() && utenteOptional.isPresent()) {
            Libro libro = libroOptional.get();
            Utente utente = utenteOptional.get();

            Prestito prestito = prestitoRepo.findByLibroAndUtente(libro, utente);
            if (prestito != null) {
                libro.setCopieDisp(libro.getCopieDisp() + 1);
                libroRepo.save(libro);
                
                prestito.setDataFine(LocalDate.now());
                prestitoRepo.save(prestito);
                
                return true;
            }
        }
        return false;
    }
}
