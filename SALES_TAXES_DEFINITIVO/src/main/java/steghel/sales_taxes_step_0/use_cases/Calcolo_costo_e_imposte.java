/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steghel.sales_taxes_step_0.use_cases;

import java.util.List;
import steghel.sales_taxes_step_0.entities.fattura.Fattura;
import steghel.sales_taxes_step_0.entities.voce_della_fattura.Voce_della_fattura;

/**
 *
 * @author steghel
 */
public class Calcolo_costo_e_imposte {
    public static void calcolo_costo_e_imposte(List<Fattura> fatture){
        for (Fattura f:fatture){            
            f.calcola_importo_totale_della_fattura();
            f.calcola_tassa_complessiva_articoli_fattura();            
        }   
    }
}
