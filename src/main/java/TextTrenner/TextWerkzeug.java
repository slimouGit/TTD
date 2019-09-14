package TextTrenner;

/**
 * User: salim
 * Date: 14.09.2019 14:55
 */
public class TextWerkzeug{
    public String ersetzeLeerzeichen(String text, String trenner){
        return text.replaceAll(" ", trenner);
    }
}
