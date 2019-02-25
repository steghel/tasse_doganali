/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steghel.sales_taxes_step_0.use_cases;

import java.util.List;
import steghel.sales_taxes_step_0.entities.fattura.Fattura;
import steghel.sales_taxes_step_0.entities.voce_della_fattura.Importazione;
import steghel.sales_taxes_step_0.entities.voce_della_fattura.Tipologia_articolo;
import steghel.sales_taxes_step_0.entities.voce_della_fattura.Voce_della_fattura;

/**
 *
 * @author steghel
 */
public class Inserimento_dati {

    public static void inserimento_dati(List<Fattura> fatture) {
        
         /*--------------------------------------------------*/
        Fattura fattura1 = new Fattura("fattura1");

        Voce_della_fattura v0 = new Voce_della_fattura(Importazione.NON_IMPORTATO,
                Tipologia_articolo.LIBRO, "book", 12.49, 1);
        fattura1.Aggiungi_articolo_alla_fattura(v0);

        Voce_della_fattura v1 = new Voce_della_fattura(Importazione.NON_IMPORTATO,
                Tipologia_articolo.ALTRA_CATEGORIA_MERCEOLOGICA, "music CD", 14.99, 1);
        fattura1.Aggiungi_articolo_alla_fattura(v1);

        Voce_della_fattura v2 = new Voce_della_fattura(Importazione.NON_IMPORTATO,
                Tipologia_articolo.CIBO, "chocolate bar ", 0.85, 1);
        fattura1.Aggiungi_articolo_alla_fattura(v2);

        fatture.add(fattura1);
        /*------------------------------------------------------------------*/

        Fattura fattura2 = new Fattura("fattura2");

        Voce_della_fattura v3 = new Voce_della_fattura(Importazione.IMPORTATO,
                Tipologia_articolo.CIBO, "imported box of chocolates", 10.00, 1);
        fattura2.Aggiungi_articolo_alla_fattura(v3);

        Voce_della_fattura v4 = new Voce_della_fattura(Importazione.IMPORTATO,
                Tipologia_articolo.ALTRA_CATEGORIA_MERCEOLOGICA, "imported bottle of perfume", 47.50, 1);
        fattura2.Aggiungi_articolo_alla_fattura(v4);
        
        fatture.add(fattura2);
        /*-----------------------------------------------------------------*/
        
        Fattura fattura3 = new Fattura("fattura3");

        Voce_della_fattura v5 = new Voce_della_fattura(Importazione.IMPORTATO,
                Tipologia_articolo.ALTRA_CATEGORIA_MERCEOLOGICA, "imported bottle of perfume", 27.99, 1);
        fattura3.Aggiungi_articolo_alla_fattura(v5);

        Voce_della_fattura v6 = new Voce_della_fattura(Importazione.NON_IMPORTATO,
                Tipologia_articolo.ALTRA_CATEGORIA_MERCEOLOGICA, "bottle of perfume", 18.99, 1);
        fattura3.Aggiungi_articolo_alla_fattura(v6);

        Voce_della_fattura v7 = new Voce_della_fattura(Importazione.NON_IMPORTATO,
                Tipologia_articolo.CIBO, "packet of headache pills", 9.75, 1);
        fattura3.Aggiungi_articolo_alla_fattura(v7);

        Voce_della_fattura v8 = new Voce_della_fattura(Importazione.IMPORTATO,
                Tipologia_articolo.CIBO, "box of imported chocolates", 11.25, 1);
        fattura3.Aggiungi_articolo_alla_fattura(v8);
        
        fatture.add(fattura3);
        /*-------------------------------------------------------------------*/
    }
}
