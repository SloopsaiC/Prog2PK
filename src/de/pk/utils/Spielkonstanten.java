package de.pk.utils;

import de.pk.control.spiel.phasen.ExplorationsPhase;
import de.pk.control.spiel.phasen.HeldenPhase;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.HeldController;
import de.pk.model.interaktion.Wuerfel;

public class Spielkonstanten
{

	public static final int STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN = 100;
	public static final int STANDARD_MAX_ANZAHL_INHALT_KISTE = 50;
	public static final int MAX_ANZAHL_INHALT_FALLE = 1;
	public static final String SPEICHER_DATEI_ENDUNG = ".save";

	public static final Phase[] STANDARD_PHASEN =
	{ new HeldenPhase(), new ExplorationsPhase() };
	public static final HeldController[] STANDARD_HELDEN =
	{ new HeldController("Dummy", 10, 10) };

	public static final int STANDARD_GROESSE_DUNGEON_X = 30;
	public static final int STANDARD_GROESSE_DUNGEON_Y = 30;
	public static final int ANZAHL_MAXIMALE_DREHUNGEN_REZEPT = 4;
	public static final Wuerfel D20 = new Wuerfel(20);
	public static final int MAX_AKTIONEN_HELDEN_PHASE = 2;
	// Kacheldimensionen in X und Y koordinaten:
	public static final int KACHEL_GROESSE_X = 5;
	public static final int KACHEL_GROESSE_Y = 5;

}
