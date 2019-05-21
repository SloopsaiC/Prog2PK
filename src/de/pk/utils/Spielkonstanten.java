package de.pk.utils;

import de.pk.control.interaktion.Wuerfel;
import de.pk.control.spiel.phasen.ExplorationsPhase;
import de.pk.control.spiel.phasen.HeldenPhase;
import de.pk.control.spiel.phasen.Phase;
import de.pk.control.spielbrett.spielbrettObjekte.lebendigeObjekte.Held;

public class Spielkonstanten
{

	public static final int STANDARD_MAX_ANZAHL_INHALT_GEGENSTANDS_HAUFEN = 100;
	public static final int STANDARD_MAX_ANZAHL_INHALT_KISTE = 50;
	public static final int MAX_ANZAHL_INHALT_FALLE = 1;
	public static final String SPEICHER_DATEI_ENDUNG = ".save";

	public static final Phase[] STANDARD_PHASEN = { new HeldenPhase(), new ExplorationsPhase() };
	public static final Held[] STANDARD_HELDEN = { new Held("Dummy", 10, 10) };

	public static final int STANDARD_GROESSE_DUNGEON_X = 30;
	public static final int STANDARD_GROESSE_DUNGEON_Y = 30;
	public static final int ANZAHL_MAXIMALE_DREHUNGEN_REZEPT = 4;
	public static final Wuerfel WUERFEL = new Wuerfel();
	public static final int MAX_AKTIONEN_HELDEN_PHASE = 2;
	// Kacheldimensionen in X und Y koordinaten:
	public static final int KACHEL_GROESSE_X = 5;
	public static final int KACHEL_GROESSE_Y = 5;

	// Bezeichnungen und Pfade der GUI-Elemente
	/**
	 * Pfad zum Fenster Icon
	 */
	public static final String ANWENDUNG_ANWENDUNGS_ICON = "src\\de\\pk\\ressourcen\\bildDateien\\spadesK.jpg";
	public static final String ANWENDUNG_CREDIT_SZENE = "CreditsSzene";
	public static final String ANWENDUNG_CREDIT_SZENE_PFAD_FXML = "CreditsSzene.fxml";
	public static final String ANWENDUNG_HAUPTMENUE_SZENE = "HauptmenueSzene";
	public static final String ANWENDUNG_HAUPTMENUE_SZENE_PFAD_FXML = "HauptmenueSzene.fxml";
	public static final String ANWENDUNG_OPTIOEN_SZENE = "OptionenSzene";
	public static final String ANWENDUNG_OPTIONEN_SZENE_PPFAD_FXML = "OptionenSzene.fxml";
	public static final String ANWENDUNG_TITEL_SZENE = "TitelSzene";
	public static final String ANWENDUNG_TITEL_SZENE_PFAD_FXML = "TitelSzene.fxml";
	public static final String ANWENDUNG_DUNGEON_SZENE = "DungeonSzene";
	public static final String ANWENDUNG_DUNGEON_SZENE_PFAD_FXML = "DungeonSzene.fxml";

}
