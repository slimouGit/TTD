package Preisrechner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PreisrechnerTest {

    private static final int VERSANDKOSTENFREI_AB = 1000;
    private static final int VERSANDKOSTEN = 500;

    @Test
    public void bestellung_1Artikel_OhneVersandkosten(){
        Preisrechner pr = new Preisrechner(VERSANDKOSTENFREI_AB,VERSANDKOSTEN);
        Ware testWare = new Ware(1,1000);
        int erwarteterPreis = 1000;
        int gesamtpreis = pr.berechnePreisInCent(testWare);
        assertEquals(erwarteterPreis, gesamtpreis);
    }

    @Test
    public void bestellung_1Artikel_MitVersandkosten(){
        Preisrechner pr = new Preisrechner(VERSANDKOSTENFREI_AB,VERSANDKOSTEN);
        Ware testWare = new Ware(1,900);
        int erwarteterPreis = 1400;
        int gesamtpreis = pr.berechnePreisInCent(testWare);
        assertEquals(erwarteterPreis, gesamtpreis);
    }

    @Test
    public void bestellung_3Artikel_OhneVersandkosten(){
        Preisrechner pr = new Preisrechner(VERSANDKOSTENFREI_AB,VERSANDKOSTEN);
        Ware testWare_1 = new Ware(1,400);
        Ware testWare_2 = new Ware(1,500);
        Ware testWare_3 = new Ware(1,200);
        int erwarteterPreis = 1100;
        int gesamtpreis = pr.berechnePreisInCent(testWare_1, testWare_2, testWare_3);
        assertEquals(erwarteterPreis, gesamtpreis);
    }

    @Test
    public void testeFormatierung(){
        Preisrechner pr = new Preisrechner(VERSANDKOSTENFREI_AB,VERSANDKOSTEN);
        Ware testWare = new Ware(1,1000);
        int gesamtpreis = pr.berechnePreisInCent(testWare);
        String formatierterPreis = pr.saubereAusgabe(gesamtpreis);
        assertEquals(formatierterPreis, "10,00€");

    }
}
