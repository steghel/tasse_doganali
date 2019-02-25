/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steghel.sales_taxes_step_0;

import java.util.ArrayList;
import java.util.List;
import steghel.sales_taxes_step_0.entities.fattura.Fattura;
import steghel.sales_taxes_step_0.use_cases.Inserimento_dati;
import steghel.sales_taxes_step_0.use_cases.Calcolo_costo_e_imposte;
import steghel.sales_taxes_step_0.use_cases.Visualizzazione_fatture;

/**
 *
 * @author steghel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Fattura> fatture=new ArrayList<>();
        
        Inserimento_dati.inserimento_dati(fatture);
        
        Calcolo_costo_e_imposte.calcolo_costo_e_imposte(fatture);
        
        Visualizzazione_fatture.creazione_e_visualizzazione_fatture(fatture);
        
        
        // TODO code application logic here
    }
    
}
