package wiederholungspruefung;

import java.time.LocalDate;

public class Wiederholungspruefung {

    //Stichtag beinhatet das Datum, das laut Gesetz als Grenze fuer die Wiederholungs gilt
    private LocalDate stichtag = LocalDate.of(2019, 06, 01);
    //Datum fuer Wiederholungspruefung zur Manipulierung in 5 Jahren Intervallen
    private LocalDate intervallDatum;

    /**
     * Eine Pruefung ist dann erforderlich, wenn sie folgende Kriterien erfuellt:
     * 'festgestelltAm' liegt vor dem Stichtag (01.06.2019 - 5 Jahre =) 01.06.2014
     * und 'datumDerNaechstenPruefung()' liegt vor dem aktuellen Kalendertag
     */
    public boolean pruefeWiederholungsPruefungsErfordernis(LocalDate festgestelltAm) {
        return (festgestelltAm.isBefore(this.stichtag.minusYears(5)) &&
                datumDerNaechstenPruefung(festgestelltAm).isBefore(LocalDate.now()));
    }

    /**
     * datumDerNaechstenPruefung() ruft berechneNaechstesPruefDatum() auf
     * aus Gruenden der Lesbarkeit
     */
    private LocalDate datumDerNaechstenPruefung(LocalDate festgestelltAm) {
        return berechneNaechstesPruefDatum(festgestelltAm);
    }

    /**
     * Die naechste Pruefung muss nach dem 01.06.2019 erfolgen.
     * Sofern das Datum 'festgestelltAm' vor dem 01.06.2019 liegt,
     * werden 5 Jahre addiert solange bis diese Bedingung nicht mehr zutrifft.
     */
    public LocalDate berechneNaechstesPruefDatum(LocalDate festgestelltAm) {
        return (festgestelltAm.isBefore(this.stichtag)) ? berechneJahresIntervall(festgestelltAm, 5) : festgestelltAm;
    }

    /**
     * Datum festgestelltAm wird um uebergebene Anzahl der Jahre erhoeht
     * und berechneNaechstesPruefDatum() rekursiv aufgerufen
     */
    private LocalDate berechneJahresIntervall(LocalDate festgestelltAm, int jahre) {
        return berechneNaechstesPruefDatum(festgestelltAm.plusYears(jahre));
    }

}
