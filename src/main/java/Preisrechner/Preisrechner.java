package Preisrechner;

import java.text.DecimalFormat;

/**
 * Der Preisrechner berechnet, aus den einzelnen Positionen
 * und möglichen Versandkosten, den Gesamtbetrag für eine
 * Bestellung.
 */
public class Preisrechner {

    private int versandkostenfreiAb;
    private int versandkosten;
    
    public Preisrechner(int versandkostenfreiAbInCent, int versandkostenInCent){
        this.versandkostenfreiAb = versandkostenfreiAbInCent;
        this.versandkosten = versandkostenInCent;
    }

	public int berechnePreisInCent(Ware... waren){
        int preis = 0;
        for (Ware ware : waren)
            preis += ware.anzahl * ware.preisInCent;
        if(waren.length > 0 && preis < versandkostenfreiAb)
            preis += versandkosten;    
        return preis;
    }

    public static String saubereAusgabe(int preisInCent){
        int euro = Math.abs(preisInCent / 100); 
        int cent = Math.abs(preisInCent % 100);
        DecimalFormat df = new DecimalFormat("00");
        return ((preisInCent < 0) ? "-" : "") + euro + "," + df.format(cent) + "€";
    }

    public static void main(String[] args){
        Ware milch = new Ware(2,200);
        Ware saft = new Ware(5,300);
        Ware kaugummi = new Ware(3,150);

        Preisrechner pr = new Preisrechner(2000,1000);

        String sauberesErgebnis = saubereAusgabe(pr.berechnePreisInCent(milch,saft,kaugummi));

        System.out.println(sauberesErgebnis + " Euro");
    }
}
