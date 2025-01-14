# GeoAPIRequests

**GeoAPIRequests** è un tool sviluppato in Java (versione 17) per effettuare chiamate ad API di varie piattaforme di dati geografici. Consente di ottenere informazioni geografiche partendo da diverse tipologie di input (coordinate, indirizzo, ecc.) e visualizzarne i risultati in tempo reale.

## Requisiti
- **Java 17** o superiore installato sul sistema
- Un IDE compatibile, come **IntelliJ IDEA**, per eseguire il progetto
- Connessione a Internet per effettuare chiamate alle API geografiche

## Istruzioni per l'uso
1. **Apertura del Progetto**  
   Aprire il file decompresso del progetto in un IDE come IntelliJ IDEA.

2. **Esecuzione**  
   Cliccare su `Run` per avviare il programma. Verrà mostrato il seguente menu:

   ```
   Scegli il tipo di input:
   1. Coordinate
   2. Indirizzo
   3. Coppia di coordinate
   4. Tutti e tre
   ```

3. **Scelta dell'opzione**  
   Inserire il numero corrispondente all'opzione desiderata. Se si inserisce un numero non valido, il programma mostrerà il seguente messaggio e chiederà nuovamente l'input:

   ```
   Scelta non valida. Per favore, riprova.
   ```

4. **Inserimento dei dati**  
   Una volta selezionata un'opzione valida, il programma richiederà i dati necessari per eseguire la query.  
   Ad esempio:
   - **Coordinate:**
     ```
     Inserisci latitudine: (esempio: 43,234)
     Inserisci longitudine: (esempio: 13,234)
     ```
   - **Indirizzo:**  
     ```
     Inserisci indirizzo: (esempio: Via Madonna delle Carceri 9 Camerino)
     ```
     Nota: Per ottenere risultati più accurati, è consigliabile inserire l'indirizzo completo.  

   - **Coppia di coordinate:**
     ```
     Inserisci latitudine di partenza: (esempio: 43,234)
     Inserisci longitudine di partenza: (esempio: 13,234)
     Inserisci latitudine di destinazione: (esempio: 44,567)
     Inserisci longitudine di destinazione: (esempio: 12,789)
     ```

5. **Visualizzazione dei risultati**  
   Dopo aver inserito i dati, il programma effettuerà la chiamata alle API e stamperà i risultati.

6. **Eseguire un'altra query**  
   Alla fine di ogni esecuzione, il programma chiederà:

   ```
   Vuoi effettuare un'altra query? (si/no):
   ```

   - Scrivendo `si`, il flusso ricomincerà dal menu di selezione.
   - Scrivendo `no`, il programma terminerà.

## Esempio di utilizzo
### Query con coordinate
1. Scelta dell'opzione `1`.
2. Inserimento delle coordinate:
   ```
   Inserisci latitudine: 43,234
   Inserisci longitudine: 13,234
   ```
3. Risultato stampato:
   ```
   ************ Risultati della query ************
   Risposta OpenStreetMap (Reverse Geocoding):
   {
       "place_id": 12345678,
       "licence": "Data © OpenStreetMap contributors",
       "lat": "43.234",
       "lon": "13.234",
       "display_name": "Via Madonna delle Carceri, Camerino, MC, Italia",
       "boundingbox": ["43.230", "43.238", "13.230", "13.238"]
   }
   ```

### Query con indirizzo
1. Scelta dell'opzione `2`.
2. Inserimento dell'indirizzo:
   ```
   Inserisci indirizzo: Via Madonna delle Carceri 9 Camerino
   ```
3. Risultato stampato:
   ```
   ************ Risultati della query ************
   Risposta OpenStreetMap (Geocoding):
   {
       "lat": "43.234",
       "lon": "13.234"
   }
   ```

## Licenza
Questo progetto è distribuito sotto la licenza [MIT](LICENSE).
