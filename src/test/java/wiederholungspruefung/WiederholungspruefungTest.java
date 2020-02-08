package wiederholungspruefung;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class WiederholungspruefungTest {

    @Test
    public void pruefungNotwendig(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate pruefDatum = LocalDate.of(2010,01,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(pruefDatum);
        assertTrue(pruefungErforderlich);
    }

    @Test
    public void pruefungNochNichtNotwendig_1(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate pruefDatum = LocalDate.of(2010,06,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(pruefDatum);
        assertFalse(pruefungErforderlich);
    }

    @Test
    public void pruefungNochNichtNotwendig_2(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate pruefDatum = LocalDate.of(2021,06,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(pruefDatum);
        assertFalse(pruefungErforderlich);
    }

    @Test
    public void berechneNaechstesPruefDatum(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate erwartetesDatumNaechstePruefung = LocalDate.of(2023,01,01);
        LocalDate festgestelltAm = LocalDate.of(2008,01,01);
        LocalDate berechnetesDatumNaechstePruefung = wiederholungspruefung.berechneNaechstesPruefDatum(festgestelltAm);
        assertTrue(erwartetesDatumNaechstePruefung.isEqual(berechnetesDatumNaechstePruefung));
    }


}
