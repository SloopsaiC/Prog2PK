package de.pk.control.gegenstaende;

import de.pk.model.gegenstaende.GegenstandsHaufenModell;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;
import de.pk.utils.Spielkonstanten;


public class GegenstandsHaufen
{

    private final GegenstandsHaufenModell modell;

    public GegenstandsHaufen (Stapelbar inhalt, int menge) throws IllegalArgumentException
    {
        this(inhalt, menge, Spielkonstanten.STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN);
    }


    public GegenstandsHaufen (Stapelbar inhalt, int menge, int maximaleAnzahl) throws IllegalArgumentException
    {
        this.modell = new GegenstandsHaufenModell(inhalt, menge, maximaleAnzahl);
    }


    /**
     * Prueft, ob die Menge groesser als das Maximum oder kleiner 0 ist.
     *
     * @param menge   zu ueberpruefende Menge
     * @param maximum maximale Anzahl, die menge nicht ueberschreiten darf
     *
     * @throws IllegalArgumentException wenn menge < maximum oder menge < 0
     */
    public static void pruefeMengeGegenMaximum (int menge, int maximum) throws IllegalArgumentException
    {
        if ((menge > maximum) || (menge < 0))
        {
            // TODO: Exception Message
            throw new IllegalArgumentException();
        }
    }


    public GegenstandsHaufen entnehmen (int anzahl)
    {
        try
        {
            this.modell.setMenge(this.modell.getMenge() - anzahl);
        }
        catch (IllegalArgumentException nichtGenugMenge)
        {
            return null;
        }
        return new GegenstandsHaufen(this.modell.getInhalt(), anzahl, this.modell.getMaximaleAnzahl());
    }


    public Stapelbar getInhalt ()
    {
        return this.modell.getInhalt();
    }


    public int getMenge ()
    {
        return this.modell.getMenge();
    }


    public GegenstandsHaufen hinzutuen (GegenstandsHaufen zusatzInhalt) throws IllegalArgumentException
    {
        if (!(this.modell.getInhalt().equals(zusatzInhalt.getInhalt())))
        {
            // TODO: Exception Messages
            throw new IllegalArgumentException();
        }
        try
        {
            this.modell.setMenge(this.getMenge() + zusatzInhalt.getMenge());
            zusatzInhalt.entnehmen(zusatzInhalt.getMenge());
        }
        catch (IllegalArgumentException ueberfluss)
        {
            return this.ueberflussBeimHinzutuen(zusatzInhalt);
        }
        return null;
    }


    private GegenstandsHaufen ueberflussBeimHinzutuen (GegenstandsHaufen ueberfluss)
    {
        ueberfluss.entnehmen(this.modell.getMaximaleAnzahl() - this.modell.getMenge());
        this.modell.setMenge(this.modell.getMaximaleAnzahl());
        return ueberfluss;
    }


}
