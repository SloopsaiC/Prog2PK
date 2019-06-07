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

	public static final Phase[] STANDARD_PHASEN =
	{ new HeldenPhase(), new ExplorationsPhase() };
	public static final Held[] STANDARD_HELDEN =
	{ new Held("Dummy", 10, 10) };

	public static final int STANDARD_ANZAHL_AKTIONEN_PRO_PHASE = 1;

	public static final int STANDARD_GROESSE_DUNGEON_X = 30;
	public static final int STANDARD_GROESSE_DUNGEON_Y = 30;
	public static final int ANZAHL_MAXIMALE_DREHUNGEN_REZEPT = 4;
	public static final Wuerfel WUERFEL = new Wuerfel();
	public static final int MAX_AKTIONEN_HELDEN_PHASE = 2;
	// Kacheldimensionen in X und Y koordinaten:
	public static final int KACHEL_GROESSE_X = 5;
	public static final int KACHEL_GROESSE_Y = 5;

	// Bezeichnungen und Pfade der GUI-Elemente
	public static final String ANWENDUNG_ANWENDUNGS_ICON = "src\\de\\pk\\ressourcen\\bildDateien\\sonstigeBilder\\spadesK.jpg";
	public static final String ANWENDUNG_CREDIT_SZENE = "CreditsSzene";
	public static final String ANWENDUNG_HAUPTMENUE_SZENE = "HauptmenueSzene";
	public static final String ANWENDUNG_OPTIONEN_SZENE = "OptionenSzene";
	public static final String ANWENDUNG_TITEL_SZENE = "TitelSzene";
	public static final String ANWENDUNG_DUNGEON_SZENE = "DungeonSzene";
	public static final String ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE = "SchwierigkeitWaehlenSzene";
	public static final String ANWENDUNG_WELTKARTE_SZENE = "WeltkarteSzene";

	public static final String FXML_DATEI_ENDUNG = ".fxml";
	public static final String FXML_DATEI_PFAD = "/de/pk/view/visuell/szenenLayoutsFXML/";
	public static final String CSS_DATEI_PFAD = "/de/pk/view/visuell/styleSheetsCSS/";
	public static final String CSS_DATEI_PFAD_AUFLOESUNG = "/de/pk/view/visuell/styleSheetsCSS/aufloesungen/";
	public static final String CSS_DATEI_ENDE = ".css";
	public static final String VOLLBILD_DATEI_ZUSATZ = "_VOLLBILD";
	public static final String CSS_SZENEN_SPEZIFISCH_ZUSATZ = "Style";
	public static final String CSS_STANDARD_LAYOUT_SHEET = "/de/pk/view/visuell/styleSheetsCSS/StandardSzenenStyle.css";

	public static final String LOKALISIERUNG_PFAD = "de.pk.ressourcen.lokalisierung.sprache";

}
