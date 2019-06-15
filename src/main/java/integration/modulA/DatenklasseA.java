package integration.modulA;

import java.io.Serializable;
import java.util.UUID;

public class DatenklasseA implements Serializable {

    private static final long serialVersionUID = 2797793006818645684L;

	public final String id;
    public String text;
    public int zahl;
    public boolean entscheidung;

    public DatenklasseA(String text, int zahl, boolean entscheidung){
        this.text = text;
        this.zahl = zahl;
        this.entscheidung = entscheidung;
        this.id = UUID.randomUUID().toString();
    }
    
    @Override
    public String toString(){
		return text + " " + zahl + " " + entscheidung;
    }
}