## Esercizio: Bed and breakfast

Creare un programma per la gestione di un bed and breakfast che dispone di più stanze

Le funzionalità da sviluppare sono:
- Gestione prenotazioni: per ogni prenotazione memorizzare: data check-in, data check-out, nr persone, nominativo di riferimento, tel. riferimento, estremi documento, soggiorno (true/false)
 
    Sottofunzionalità:
        - aggiungi prenotazione
        - annulla prenotazione
        - visualizza prenotazioni

- Gestione recensioni: 
    - ricevi recensione: per ogni prenotazione divenuta soggiorno è possibile ricevere una recensione composta da un numero di stelle da 1 a 5 e da un testo descrittivo
    - visualizza recensioni: mostra tutte le recensioni ricevute e la media delle stelle ottenute
    - genera recensioni: è possibile generare delle recensioni "fake" utilizzando l'intelligenza artificiale. L'utente decide quante recensioni generare e per ognuna delle recensioni generate l'intervallo di stelle da ottenere


### Versione 2
- Realizzare una classe Controller che espone i metodi del Bed and Breakfast.
- All'interno del controller creare un oggetto della classe BedAndBreakfast (se non l'avete già fatto, crearla) con un metodo pubblico per ogni funzionalità.
- Realizzare un endpoint per ogni metodo da richiamare
- Testare ogni endpoint con lo strumento di preferenza (Postman, APIDog, ThunderClient)
