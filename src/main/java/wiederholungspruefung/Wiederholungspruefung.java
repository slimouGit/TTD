package wiederholungspruefung;

import java.time.LocalDate;

public class Wiederholungspruefung {

    //Datum fuer Wiederholungspruefung zur Manipulierung in 5 Jahren Intervallen
    private LocalDate intervallDatum;

    /**
     * Eine Pruefung ist dann erforderlich, wenn sie folgende Kriterien erfuellt:
     * 'festgestelltAm' liegt vor dem 01.06.2014 und 'datumDerNaechstenPruefung()'
     * liegt vor dem aktuellen Kalendertag
     */
    public boolean pruefeWiederholungsPruefungsErfordernis(LocalDate festgestelltAm) {
        return (festgestelltAm.isBefore(LocalDate.of(2014, 06, 01)) &&
                datumDerNaechstenPruefung(festgestelltAm).isBefore(LocalDate.now()));
    }

    private LocalDate datumDerNaechstenPruefung(LocalDate festgestelltAm) {
        return berechneNaechstesPruefDatum(festgestelltAm);
    }

    /**
     * Die naechste Pruefung muss nach dem 01.06.2019 erfolgen.
     * Sofern das Datum 'festgestelltAm' vor dem 01.06.2019 liegt,
     * werden solange 5 Jahre addiert bis diese Bedingung nicht mehr zutrifft.
     */
    public LocalDate berechneNaechstesPruefDatum(LocalDate festgestelltAm) {
        if (festgestelltAm.isBefore(LocalDate.of(2019, 06, 01))) {
            this.intervallDatum = festgestelltAm.plusYears(5);
            berechneNaechstesPruefDatum(this.intervallDatum);
        } else {
            this.intervallDatum = festgestelltAm;
        }
        return this.intervallDatum;
    }

}
