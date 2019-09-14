package Licht;


import org.junit.Test;

import static org.mockito.Mockito.*;

public class AufrufFremdsystemTest {

    @Test
    public void leuchtendesLichtWirdAusgeschaltet(){
        Licht testLicht = mock(Licht.class);
        when(testLicht.isAn()).thenReturn(true);
        Schalter schalter = new Schalter(testLicht);
        
        schalter.schalteLicht();

        verify(testLicht).schalteAus();
    }
    
}
