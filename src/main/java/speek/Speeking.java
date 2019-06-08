package speek;

/**
 * User: salim
 * Date: 08.06.2019 15:19
 */
public class Speeking {
    public boolean isSpeekingToMuch(String sentence){
        boolean tooMuch = false;

        if(sentence.length()>20)
            tooMuch = true;

        return tooMuch;
    }
}
