package de.pk.utils;

import de.pk.control.spiel.phasen.ExplorationsPhase;
import de.pk.control.spiel.phasen.HeldenPhase;
import de.pk.control.spiel.phasen.Phase;
import de.pk.kartenGenerator.KartenGenerator;
import de.pk.model.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Spielkonstanten
{
	public static final int STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN = 100;
	public static final int STANDARD_MAX_ANZAHL_INHALT_KISTE = 50;
	public static final int MAX_ANZAHL_INHALT_FALLE = 1;
	public static final String SPEICHER_DATEI_ENDUNG = ".save";

	public static final Phase[] STANDARD_PHASEN =
	{ new HeldenPhase(), new ExplorationsPhase() };
	public static final Held[] STANDARD_HELDEN =
	{ new Held("Test", 10, 10) };
	
}
