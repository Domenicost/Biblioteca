package org.generation.italy.web.biblioteca.exceptions;

public class NotRecensibleReservationException extends Exception {

    public NotRecensibleReservationException() {
        super("Impossibile lasciare la recensione. Soggiorno non effettuato");
    }
}
