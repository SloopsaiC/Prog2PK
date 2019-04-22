package de.pk.model.gegenstaende.ausruestung;

import de.pk.model.faehigkeiten.Faehigkeit;
import de.pk.model.gegenstaende.Gegenstand;
import de.pk.model.gegenstaende.spezifikationen.Ausruestbar;
import de.pk.model.interaktion.Effekt;

public abstract class Ausruestung extends Gegenstand implements Ausruestbar
{
	private Effekt[] ausruestungsEffekte = null; // Alle Effekte die diese Ausruestung auf den Traeger hervorruft
	private Faehigkeit[] vorraussetzungen = null; // Die Vorraussetzungen die der Traeger dieser Ausruestung haben muss
}
