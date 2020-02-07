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
    public void pruefungNochNichtNotwendig(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate pruefDatum = LocalDate.of(2010,06,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(pruefDatum);
        assertFalse(pruefungErforderlich);
    }

    @Test
    public void ermittelPruefdatum(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate erwartetesDatum = LocalDate.of(2023,01,01);
        LocalDate eingegebenesDatum = LocalDate.of(2008,01,01);
        LocalDate berechnetesDatum = wiederholungspruefung.ermittelPruefdatum(eingegebenesDatum);
        assertEquals(erwartetesDatum.toString(), berechnetesDatum.toString());
    }


}
