package org.generation.italy.web.biblioteca.exceptions;

public class NotCancellableReservationException extends Exception {
    public NotCancellableReservationException() {
        super("Impossibile annullare. Data check-in troppo vicina");
    }    
}
