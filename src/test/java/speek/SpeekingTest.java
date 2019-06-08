package speek;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * User: salim
 * Date: 08.06.2019 15:22
 */
public class SpeekingTest {
    @Test
    public void testSpeeking(){
        Speeking sp = new Speeking();
        String testSentence = "Konzepte und Methoden guter Unit-Tests am Beispiel von Java, JUnit und Mockito. Clean Code in Aktion.";
        boolean testResult = sp.isSpeekingToMuch(testSentence);
        assertTrue(testResult);
        assertEquals(testResult,true);
    }
}
