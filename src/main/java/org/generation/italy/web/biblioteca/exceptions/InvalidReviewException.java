package org.generation.italy.web.biblioteca.exceptions;

public class InvalidReviewException extends Exception {
    public InvalidReviewException() {
        super("Numero di stelle non valido");
    }
}
