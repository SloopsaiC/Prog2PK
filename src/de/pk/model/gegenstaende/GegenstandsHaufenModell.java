package de.pk.model.gegenstaende;

import de.pk.control.gegenstaende.GegenstandsHaufen;
import de.pk.model.gegenstaende.spezifikationen.Stapelbar;


public class GegenstandsHaufenModell
{

    private final Stapelbar inhalt;
    private int menge = 0;
    private final int maximaleAnzahl;

    public GegenstandsHaufenModell (Stapelbar inhalt, int menge, int maximaleAnzahl) throws IllegalArgumentException
    {
        GegenstandsHaufen.pruefeMengeGegenMaximum(menge, maximaleAnzahl);
        this.inhalt = inhalt;
        this.menge = menge;
        this.maximaleAnzahl = maximaleAnzahl;
    }


    public Stapelbar getInhalt ()
    {
        return this.inhalt;
    }


    public int getMaximaleAnzahl ()
    {
        return this.maximaleAnzahl;
    }


    public int getMenge ()
    {
        return this.menge;
    }


    public void setMenge (int neueMenge) throws IllegalArgumentException
    {
        GegenstandsHaufen.pruefeMengeGegenMaximum(neueMenge, this.maximaleAnzahl);
        this.menge = neueMenge;
    }


}
