# TAXES_SALES_0

DIAGRAMMA CLASSI
Abbiamo 2 classi principali: Fattura e Voce_della_fattura.
Durante l’esecuzione del programma, ad ogni oggetto di tipo Fattura, sono associati alcuni oggetti di tipo Voce_della_fattura 
che rappresentano le singole voci da cui è composta la fattura.

La classe Voce_della_fattura contiene le operazioni (metodi) di calcola_tassa_su_singolo_articolo(), 
calcola_costo_complessivo_singolo_articolo() e arrotondamento(), perché è questa classe che contiene i dati di un singolo articolo,
cioè i dati che tali operazioni devono elaborare.
Viceversa le operazioni calcola_tassa_complessiva_articoli_fattura() e calcola_ importo_totale_della_fattura(), sono 
nella classe Fattura, infatti tali operazioni devono agire su tutti gli oggetti Voce_della_fattura associati alla classe fattura.

CASI D’USO
Gli use cases sono operazioni che vengono fatti sulla lista di oggetti Fattura che viene creata nel Main e che serve 
come contenitore per le varie fatture.

1) Inserimento dati.
        Crea un oggetto fattura per ogni input.
              crea un oggetto Voce_della_fattura per ogni voce di ingresso.
              Aggiungi tale oggetto all’oggetto fattura.
              
2) Calcolo costo e imposte
        Per ogni oggetto fattura chiama le funzioni:
              calcola_tassa_complessiva_articoli_fattura()
              calcola_importo_totale_della_fattura().
              
3) Visualizzazione fatture
