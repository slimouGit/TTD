package golem;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GolemTest {

    @Test
    public void loesungswortRichtig_tutEtwas(){
        Golem golem = new Golem("LOESUNGSWORT");
        String aktion = golem.bewegeDich("LOESUNGSWORT", 3, Richtung.NORDEN);
        assertEquals("Der Golem bewegt sich 3 Schritte nach NORDEN", aktion);
    }

    @Test
    public void loesungswortFalsch_tutNichts(){
        Golem golem = new Golem("LOESUNGSWORT");
        String aktion = golem.bewegeDich("FALSCH", 3, Richtung.NORDEN);
        assertEquals("Es passiert Nichts.", aktion);
    }
}
