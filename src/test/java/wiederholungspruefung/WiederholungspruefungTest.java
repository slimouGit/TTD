package wiederholungspruefung;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class WiederholungspruefungTest {

    /**
     * Pruefung erforderlich, weil festgestelltAm vor 1.6.2014
     * Und errechnetes Pruefdatum nach 1.6.2014
     * Und errechnetes Pruefdatum in der Vergangenheit
     * TODO: Kritisch, weil Testdaten nicht dynamisch
     */
    @Test
    public void pruefungNotwendig(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate festgestelltAm = LocalDate.of(2010,01,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(festgestelltAm);
        assertTrue(pruefungErforderlich);
    }

    /**
     * Noch nicht erforderlich, weil festgestelltAm vor 1.6.2010
     * Wird erforderlich sein nach dem 1.6.2020
     */
    @Test
    public void pruefungNochNichtNotwendig_1(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate festgestelltAm = LocalDate.of(2010,06,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(festgestelltAm);
        assertFalse(pruefungErforderlich);
    }

    /**
     * Nicht erforderlich, weil festgestelltAm nach 1.6.2019
     */
    @Test
    public void pruefungNochNichtNotwendig_2(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate festgestelltAm = LocalDate.of(2021,06,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(festgestelltAm);
        assertFalse(pruefungErforderlich);
    }

    /**
     * Nicht erforderlich, weil festgestelltAm vor 1.6.2014
     */
    @Test
    public void pruefungNochNichtNotwendig_3(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate festgestelltAm = LocalDate.of(2016,01,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(festgestelltAm);
        assertFalse(pruefungErforderlich);
    }

    /**
     * berechnetesDatumNaechstePruefung == erwartetesDatumNaechstePruefung
     */
    @Test
    public void berechneNaechstesPruefDatum(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate erwartetesDatumNaechstePruefung = LocalDate.of(2023,01,01);
        LocalDate festgestelltAm = LocalDate.of(2008,01,01);
        LocalDate berechnetesDatumNaechstePruefung = wiederholungspruefung.berechneNaechstesPruefDatum(festgestelltAm);
        assertTrue(erwartetesDatumNaechstePruefung.isEqual(berechnetesDatumNaechstePruefung));
    }

    /**
     * berechnetesDatumNaechstePruefung != erwartetesDatumNaechstePruefung
     */
    @Test
    public void berechneNaechstesPruefDatum_Fehler(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate erwartetesDatumNaechstePruefung = LocalDate.of(2022,02,01);
        LocalDate festgestelltAm = LocalDate.of(2008,01,01);
        LocalDate berechnetesDatumNaechstePruefung = wiederholungspruefung.berechneNaechstesPruefDatum(festgestelltAm);
        assertFalse(erwartetesDatumNaechstePruefung.isEqual(berechnetesDatumNaechstePruefung));
    }


}
