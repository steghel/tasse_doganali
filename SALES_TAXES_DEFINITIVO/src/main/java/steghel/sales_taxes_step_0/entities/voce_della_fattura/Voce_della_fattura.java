/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package steghel.sales_taxes_step_0.entities.voce_della_fattura;

/**
 *
 * @author steghel
 */
public class Voce_della_fattura {

    
    private static final double dazio_doganale = 0.05;
    /* 5% */
    private static final double tassa_sulla_vendita = 0.10;
    /* 10% */

    private Importazione importazione;
    private Tipologia_articolo Tipologia_articolo;
    private String nome_articolo;
    private double costo_articolo;
    private int numero_di_articoli_nella_fattura;
    private double tassa_su_articolo;
    private double costo_articolo_con_tasse;
    

    
    
    public Voce_della_fattura(Importazione importazione, 
            Tipologia_articolo Tipologia_articolo, String nome_articolo, 
            double costo_articolo, int numero_di_articoli_nella_fattura) {
        this.importazione = importazione;
        this.Tipologia_articolo = Tipologia_articolo;
        this.nome_articolo = nome_articolo;
        this.costo_articolo = costo_articolo;
        this.numero_di_articoli_nella_fattura = numero_di_articoli_nella_fattura;
    }

    public String getNome_articolo() {
        return nome_articolo;
    }

    public double getCosto_articolo() {
        return costo_articolo;
    }

    public int getNumero_di_articoli_nella_fattura() {
        return numero_di_articoli_nella_fattura;
    }

    

    public Double getTassa_su_articolo() {
        return tassa_su_articolo;
    }

    public void calcola_tassa_su_singolo_articolo() {
        double coefficiente_che_calcola_tassa = 0.0;
        double tassa_su_articolo_non_arrotondata;

        if (Tipologia_articolo == Tipologia_articolo.ALTRA_CATEGORIA_MERCEOLOGICA) {
            coefficiente_che_calcola_tassa = coefficiente_che_calcola_tassa + tassa_sulla_vendita;
        }

        if (importazione == importazione.IMPORTATO) {
            coefficiente_che_calcola_tassa = coefficiente_che_calcola_tassa
                    + dazio_doganale;
        }  
        coefficiente_che_calcola_tassa=riduci_a_due_cifre_decimali(coefficiente_che_calcola_tassa);

        tassa_su_articolo_non_arrotondata = costo_articolo * coefficiente_che_calcola_tassa;
        tassa_su_articolo_non_arrotondata = riduci_a_due_cifre_decimali(tassa_su_articolo_non_arrotondata);
        double d = calcola_arrotondamento(tassa_su_articolo_non_arrotondata);
        tassa_su_articolo = riduci_a_due_cifre_decimali(d);

    }

    public void calcola_costo_compessivo_singolo_articolo() {
        //System.out.print("ciao");
        costo_articolo_con_tasse = costo_articolo + tassa_su_articolo;
        costo_articolo_con_tasse = riduci_a_due_cifre_decimali(costo_articolo_con_tasse);
        /*double d=costo_articolo + tassa_su_articolo;
        int i=(int)(d*100);
        double d1=(double)i;
        costo_articolo_con_tasse=d1/100;*/
        //System.out.print("ciao");
    }

    public Double getCosto_articolo_con_tasse() {
        return costo_articolo_con_tasse;
    }

    private double calcola_arrotondamento(double valore) {
        double risultato_arrotondamento = 0.0;
        /*moltiplico valore * 100 e lo trasformo in un intero */
        //Double val=Math.floor(valore * Math.pow(10, 2))/Math.pow(10, 2);

        
        int i = (int) (valore * 100);
        /*trasformo l'intero in una stringa di caratteri*/
        String sd1 = String.valueOf(i);
        /*trasformo la stringa in un vettore di caratteri*/
        char[] c = sd1.toCharArray();

        /*se l'ultimo carattere del vettore è 0 o 5, 
        non deve esserci arrotondamento*/
        if ((c[c.length - 1] == '5') || (c[c.length - 1] == '0')) {
            String s = new String(c);
            risultato_arrotondamento = (Double.parseDouble(s)) / 100;
        }
        /*se l'ultimo carattere del vettore è 1 o 2 o 3 o 4 devi arrotondare a 5*/
        if ((c[c.length - 1] == '1') || (c[c.length - 1] == '2') || (c[c.length - 1] == '3') || (c[c.length - 1] == '4')) {
            c[c.length - 1] = '5';
            String s = new String(c);
            risultato_arrotondamento = (Double.parseDouble(s)) / 100;
        }

        /*se l'ultimo carattere del vettore è 6 o 7 o 8 o 9 devi arrotondare a 0
        e incrementare di 1 il penultimo carattere*/
        if ((c[c.length - 1] == '6') || (c[c.length - 1] == '7') || (c[c.length - 1] == '8') || (c[c.length - 1] == '9')) {
            c[c.length - 1] = '0';
            int intero = (int) c[c.length - 2];
            intero = intero + 1;
            char carattere = (char) intero;
            c[c.length - 2] = carattere;
            String s = new String(c);
            risultato_arrotondamento = (Double.parseDouble(s)) / 100;
        }
        return risultato_arrotondamento;
    }
    
    private double riduci_a_due_cifre_decimali(double d){
        /*int i=(int)(d*100);
        double d1=(double)i;
        return d1/100;*/
        double d1=Math.round(d*100);
        return d1/100;
    }

}
