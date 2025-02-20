### Entità

Libro (id,autore,titolo, copieDisp)
Prestito (id, dataInizio, dataFine)
Utente (id, nome, telefono)

### Endpoint da esporre:

Elenco libri (eventualmente filtrati per
autore e/o per titolo)
Aggiungi libro
Modifica libro (possibile modificare nrcopie)
Elimina libro (non possibile se prestiti in
corso)

Aggiungi prestito (impostare dataInizio alla
data attuale, posso farlo se nrcopie>0.
Aggiornare nrcopie disponibili)
Restituisci prestito (impostare dataFine alla
data attuale. Aggiornare nrcopie disponibili)

Elenco prestiti (per ogni prestito restituire i
dati del prestito, dell'utente e del libro
interessato).

- Filtri opzionali:
- data inizio
- data fine
- non restituiti (vero/falso)

Elenco utenti1
