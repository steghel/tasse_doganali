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
public class Visualizzazione_fatture {
    public static void creazione_e_visualizzazione_fatture(List<Fattura> fatture){
        for(Fattura f:fatture){
            
            System.out.print("\n");
            System.out.print("----------------------------------");
            System.out.print("\n");
            System.out.print(f.getNome_della_fattura());
            System.out.print("\n\n");
            
            for (Voce_della_fattura vdc:f.getLista_voci_della_fattura()){
                //System.out.print("2° for ");
                System.out.print(vdc.getNumero_di_articoli_nella_fattura());  
                System.out.print(" ");
                System.out.print(vdc.getNome_articolo());            
                System.out.print(": ");
                //System.out.print(vdc.getCosto_articolo());
                //System.out.print(" ");
                //System.out.print(vdc.getTassa_su_articolo());
                //System.out.print(" ");
                System.out.print(vdc.getCosto_articolo_con_tasse());
                System.out.print("\n\n");            
            }
            
            System.out.print("Total: ");
            System.out.print(f.getImporto_totale_della_fattura());
            System.out.print("\n\n");
            System.out.print("Sales Taxes: ");
            System.out.print(f.getTassa_complessiva_articoli_fattura());
            System.out.print("\n\n");
            
        }
    }
}
