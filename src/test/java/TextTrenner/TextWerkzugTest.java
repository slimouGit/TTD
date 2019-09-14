package TextTrenner;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TextWerkzugTest {

    @Test
    public void testeTrenner(){
        TextWerkzeug textWerkzug = new TextWerkzeug();
        String text = "Auf der Mauer, auf der Lauer";
        String trenner = "-";
        String erwartetesErgebnis = "Auf-der-Mauer,-auf-der-Lauer";
        String ergebnis = textWerkzug.ersetzeLeerzeichen(text,trenner);

        assertEquals(erwartetesErgebnis, ergebnis);
    }
}
