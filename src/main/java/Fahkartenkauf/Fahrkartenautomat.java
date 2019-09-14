package Fahkartenkauf;

public class Fahrkartenautomat {

    public static int KOSTEN_FAHRKARTE = 280;
    private int guthaben = 0;

	public void geldEinwerfen(int cent){
        this.guthaben += cent;
    }

    public String kaufeFahrkarte(){
        if(guthaben >= KOSTEN_FAHRKARTE)
            return werfeFahrkarteAus();
        else
            return nichtGenugGuthaben();
    }

	private String nichtGenugGuthaben() {
		return "Auf Anzeige erscheint: \"Es ist nicht genug Guthaben vorhanden. Eine Fahrkarte kostet " + KOSTEN_FAHRKARTE + " Cent\"";
	}

	private String werfeFahrkarteAus() {
        guthaben = guthaben -= KOSTEN_FAHRKARTE;
        String fahrkarteAuswerfen = "Eine Fahrkarte wird ausgeworfen.";
        if(guthaben > 0)
            fahrkarteAuswerfen += " Es werden " + guthaben + " Cent ausgeworfen.";
        guthaben = 0;
		return fahrkarteAuswerfen;
    } 
    
    public String schaueAufGuthaben(){
        return "Die Anzeige zeigt \"" + guthaben + " Cent\" an.";
    }
    
}
