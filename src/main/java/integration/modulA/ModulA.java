package integration.modulA;


public class ModulA {

    private ModulB modulB;

    public ModulA(ModulB modulB){
        this.modulB = modulB;
    }

    public void machWas(DatenklasseA datenklasseA){
        datenklasseA.zahl ++;
        datenklasseA.entscheidung = !datenklasseA.entscheidung;

        modulB.save(datenklasseA);
    }

    public String zeigHer(String text){
        DatenklasseA daten = modulB.load(text);
        return daten.toString();
    }

    
}