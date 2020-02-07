package wiederholungspruefung;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class WiederholungspruefungTest {

    @Test
    public void pruefungNotwendig(){
        Wiederholungspruefung wiederholungspruefung = new Wiederholungspruefung();
        LocalDate pruefDatum = LocalDate.of(2010,01,01);
        boolean pruefungErforderlich = wiederholungspruefung.pruefeWiederholungsPruefungsErfordernis(pruefDatum);
        assertTrue(pruefungErforderlich);
    }
}
