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
        String aktion = golem.bewegeDich("FALSCH", 3, Richtung.WESTEN);
        assertEquals("Es passiert Nichts.", aktion);
    }

    @Test
    public void loesungswortRichtig_bewegtSich1Meter(){
        Golem golem = new Golem("LOESUNGSWORT");
        String aktion = golem.bewegeDich("LOESUNGSWORT", 1, Richtung.SUEDEN);
        assertEquals("Der Golem bewegt sich 1 Schritte nach SUEDEN", aktion);
    }

    @Test
    public void loesungswortRichtig_0Meter_tutNichts(){
        Golem golem = new Golem("LOESUNGSWORT");
        String aktion = golem.bewegeDich("LOESUNGSWORT", 0, Richtung.SUEDEN);
        assertEquals("Es passiert Nichts.", aktion);
    }

}
