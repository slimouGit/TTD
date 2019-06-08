package golem;

import java.util.Locale;

public class Golem {

    public static final String MISSION_STARTEN = "Der Golem startet seine Mission." 
        +" Er verschwindet in den Gassen der Stadt.";
	public static final String BEWEGEN = "Der Golem bewegt sich %d Schritte nach %s";
    public static final String NICHTS_PASSIERT = "Es passiert Nichts.";
	public static final String GLIMMEN = "Das Siegel beginnt zu glimmen. Die Augen des Golems öffnen sich.";
    
	private final String losungswort;
    private Siegel siegel;

    public Golem(String losungswort){
        this.losungswort = losungswort;
    }

    public String bewegeDich(String losungswort, int schritte, Richtung richtung){
        if(stimmtDasLosungswort(losungswort))
            return bewegen(schritte, richtung);
        return nichtsTun();    
    }

    private boolean stimmtDasLosungswort(String losungswort){
        if(losungswort == null)
            return false;
        return this.losungswort.equals(losungswort);
    }

    private String bewegen(int schritte, Richtung richtung){
        if(schritte <= 0)
            return nichtsTun();
        return String.format(Locale.GERMAN, BEWEGEN, schritte, richtung);
    }

    private String nichtsTun(){
        return NICHTS_PASSIERT;
    }

    public String siegelEinsetzen(String losungswort, Siegel siegel){
        if(stimmtDasLosungswort(losungswort)){
            this.siegel = siegel;
            return GLIMMEN;
        }
        return nichtsTun();    
    }

    public String starteMission(String losungswort){
        if(stimmtDasLosungswort(losungswort) && hatEnergie())
            return MISSION_STARTEN;
        return nichtsTun();
    }

	private boolean hatEnergie() {
        if(siegel == null)
            return false;
		return siegel.hatEnergie();
	}
    
}