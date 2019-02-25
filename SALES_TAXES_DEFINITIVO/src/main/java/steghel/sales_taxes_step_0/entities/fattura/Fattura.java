/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steghel.sales_taxes_step_0.entities.fattura;

import steghel.sales_taxes_step_0.entities.voce_della_fattura.Voce_della_fattura;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author steghel
 */
public class Fattura {

    private String nome_della_fattura;
    private double tassa_complessiva_articoli_fattura = 0.0;
    private double importo_totale_della_fattura = 0.0;
    private List<Voce_della_fattura> lista_voci_della_fattura = new ArrayList<>();

    public List<Voce_della_fattura> getLista_voci_della_fattura() {
        return lista_voci_della_fattura;
    }

    public Fattura(String nome_della_fattura) {
        this.nome_della_fattura = nome_della_fattura;
    }

    public String getNome_della_fattura() {
        return nome_della_fattura;
    }

    public double getTassa_complessiva_articoli_fattura() {
        return tassa_complessiva_articoli_fattura;
    }

    public double getImporto_totale_della_fattura() {
        return importo_totale_della_fattura;
    }

    public void Aggiungi_articolo_alla_fattura(Voce_della_fattura articolo) {
        lista_voci_della_fattura.add(articolo);
    }

    public void calcola_tassa_complessiva_articoli_fattura() {
        for (Voce_della_fattura voce_della_fattura : lista_voci_della_fattura) {
            voce_della_fattura.calcola_tassa_su_singolo_articolo();
            tassa_complessiva_articoli_fattura = tassa_complessiva_articoli_fattura
                    + voce_della_fattura.getTassa_su_articolo();
        }
        tassa_complessiva_articoli_fattura=riduci_a_due_cifre_decimali(tassa_complessiva_articoli_fattura);
    }

    public void calcola_importo_totale_della_fattura() {
        for (Voce_della_fattura voce_della_fattura : lista_voci_della_fattura) {
            voce_della_fattura.calcola_costo_compessivo_singolo_articolo();
            importo_totale_della_fattura = importo_totale_della_fattura
                    + voce_della_fattura.getCosto_articolo_con_tasse();
        }
        importo_totale_della_fattura=riduci_a_due_cifre_decimali(importo_totale_della_fattura);
    }

    private double riduci_a_due_cifre_decimali(double d) {
        /*int i=(int)(d*100);
        double d1=(double)i;
        return d1/100;*/
        double d1 = Math.round(d * 100);
        return d1 / 100;
    }
}
