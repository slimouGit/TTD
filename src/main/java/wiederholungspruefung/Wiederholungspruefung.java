package wiederholungspruefung;

import java.time.LocalDate;

public class Wiederholungspruefung {

    private LocalDate tmpResult;

    /**
     *
     * Eine Pruefung ist dann erforderlich, wenn sie folgende Kriterien erfuellt:
     * 'festgestelltAm' liegt vor dem 01.06.2014 und das berechnete Datum der naechsten Pruefung liegt zwischen
     * dem 01.06.2019 und dem aktuellen Kalendertag
     */
    public boolean pruefeWiederholungsPruefungsErfordernis(LocalDate festgestelltAm) {
        boolean wiederholungspruefungErforderlich = false;
        LocalDate untereDatumsGrenze = LocalDate.of(2014, 06, 01);
        if(festgestelltAm.isBefore(untereDatumsGrenze) && berechneNaechstesPruefDatum(festgestelltAm).isBefore(LocalDate.now())){
                wiederholungspruefungErforderlich = true;
        }
        return wiederholungspruefungErforderlich;
    }

    /**
     * Die naechste Pruefung muss nach dem 01.06.2019 erfolgen
     * wenn das pruefDatum vor dem 06.01.2019 liegt, werden solange 5 Jahre addiert
     * bis diese Bedingung nicht mehr zutrifft
     */
    public LocalDate berechneNaechstesPruefDatum(LocalDate festgestelltAm) {
        LocalDate obereDatumsGrenze = LocalDate.of(2019,06,01);
        if(festgestelltAm.isBefore(obereDatumsGrenze)){
            this.tmpResult=festgestelltAm.plusYears(5);
            berechneNaechstesPruefDatum(this.tmpResult);
        }else{
            this.tmpResult=festgestelltAm;
        }
        return this.tmpResult;
    }
    
}
