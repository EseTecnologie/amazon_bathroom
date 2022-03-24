# amazon_bathroom

Amazon vuole scoprire quanto tempo impiega ogni impiegato al WC per aumentare la produttività dell'azienda ( e per licenziare chi ci mette troppo tempo ) 

ci sono 2 bagni , uno per i maschi e uno per le femmine; ogni bagno contiene 5 WC. 
La situazione è la seguente:

Una persona che necessita di andare al WC controlla se c'è un posto disponibile, se si lo utilizza altrimenti torna al lavoro. 
viene memorizzato nel sistema quanto tempo totale utilizza il WC.

a fine giornata verranno licenziati il maschio e la femmina che hanno impiegato più tempo (totale) in bagno.
a pari merito, ne viene licenziato uno di questi a random.

Simulare il tutto con un programma in JAVA.


- Generare randomicamente 100 dipendenti ( ognuno con un proprio ID univoco e sesso ) 

inizio giornata:
- Ogni tot millisecondi ( 1000-5000 ms )  un dipendente prova ad andare in bagno, se non c'è posto torna al lavoro; se c'è posto ....
- entra in uno dei WC liberi
- Viene registrato il tempo impiegato da quella persona
- torna al lavoro

ripetere queste operazioni fino a che non finisce la giornata ( tempo di una giornata = 60 secondi ) 


a fine giornata, assicurati che non c'è più nessuno al bagno controllare rispettivamente nel gruppo dei maschi e in quello delle femmine chi ha speso più tempo in bagno e visualizzare le sue info nella console.

Amazon vuole anche avere una statistica su quale dei 5 bagni ( sia per maschi che per femmine ) viene usato meno.
a fine giornata, visualizzare a video quale bagno ( sia maschi che femmine ) è stato usato per meno volte.
