package golem;


import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

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

    @Test
    public void loesungswortFuerSiegelFalsch_tutNichts(){
        Golem golem = new Golem("LOESUNGSWORT");
        //Siegel siegel = new Siegel(); //moegliche Fehlerquelle
        Siegel siegel = mock(Siegel.class); //keine Abhaengigkeiten zur Implementierung
        String aktion = golem.siegelEinsetzen("FALSCH", siegel);
        assertEquals("Es passiert Nichts.", aktion);
    }

    @Test
    public void loesungswortFuerSiegelRichtig_golemGlimmt(){
        Golem golem = new Golem("LOESUNGSWORT");
        //Siegel siegel = new Siegel(); //moegliche Fehlerquelle
        Siegel siegel = mock(Siegel.class); //keine Abhaengigkeiten zur Implementierung
        String aktion = golem.siegelEinsetzen("LOESUNGSWORT", siegel);
        assertEquals("Das Siegel beginnt zu glimmen. Die Augen des Golems öffnen sich.", aktion);
    }

    @Test
    public void nullSiegelEinsetzen_golemGlimmt(){
        Golem golem = new Golem("LOESUNGSWORT");
        Siegel siegel = null;
        String aktion = golem.siegelEinsetzen("LOESUNGSWORT", siegel);
        assertEquals("Das Siegel beginnt zu glimmen. Die Augen des Golems öffnen sich.", aktion);
    }

    @Test
    public void starteMissionFalschesLoesungswort(){
        Golem golem = new Golem("LOESUNGSWORT");
        Siegel siegel = mock(Siegel.class);
        golem.siegelEinsetzen("LOESUNGSWORT", siegel);
        String aktion = golem.starteMission("FALSCH");
        assertEquals("Es passiert Nichts.", aktion);
    }

    @Test
    public void starteMissionEnergieIstDa_MissionWirdGestartet(){
        Golem golem = new Golem("LOESUNGSWORT");
        Siegel siegel = mock(Siegel.class);
        when(siegel.hatEnergie()).thenReturn(true);
        golem.siegelEinsetzen("LOESUNGSWORT", siegel);
        String aktion = golem.starteMission("LOESUNGSWORT");
        assertEquals("Der Golem startet seine Mission."
                +" Er verschwindet in den Gassen der Stadt.", aktion);
    }

    @Test
    public void starteMissionEnergieIstDa_siegelWirdNachEnergieGefragt(){
        Golem golem = new Golem("LOESUNGSWORT");
        Siegel siegel = mock(Siegel.class);

        golem.siegelEinsetzen("LOESUNGSWORT", siegel);
        String aktion = golem.starteMission("LOESUNGSWORT");

        verify(siegel).hatEnergie();

    }

}
