package de.pk.control.app;

import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.DebugAusgabeKlasse;
import de.pk.utils.DebugEingabeKlasse;
import de.pk.utils.lokalisierung.DE_de;


/**
 * Die Main Klasse startet die Anwendung.
 *
 * @author Dylan
 */
public class Main
{

    /**
     * Beendet die Anwendung und schliesst offene Ressourcen.
     */
    public static void anwendungBeenden ()
    {
        DebugEingabeKlasse.schliesseScanner();
        System.exit(0);
    }


    /**
     * Startet die Anwendung (Das Spiel insgesamt).
     */
    private static void anwendungStarten ()
    {
        Anwendung spielAnwendung = new Anwendung();
        spielAnwendung.starteAnwendung();
    }


    /**
     * Begruesst den Nutzer bei Programmstart.
     */
    private static void begruessen ()
    {
        DebugAusgabeKlasse.ausgeben(DE_de.BEGRUESSUNG_BEI_PROGRAMMSTART);
    }


    /**
     * Initialisiert Einstellungen noch vor Anwendungsstart.
     */
    private static void initialisieren ()
    {
        DebugAusgabeKlasse.setAusgabeAktiv(Einstellungen.DEBUG_MODUS_AN);
    }


    /**
     * main-Methode startet das gesamte Programm.
     *
     * @param args Argumente der Kommandozeile
     */
    public static void main (String[] args)
    {
        Main.initialisieren();
        Main.begruessen();
        Main.anwendungStarten();
    }


}
