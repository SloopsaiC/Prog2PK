
package de.pk.view.visuell;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;

import de.pk.control.app.Main;
import de.pk.control.spiel.einstellungen.Einstellungen;
import de.pk.utils.Spielkonstanten;
import de.pk.utils.lokalisierung.Lokalisierbar;
import de.pk.utils.lokalisierung.LokalisierungsKeys;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * Die Klasse AnwendungFX ist die Hauptklasse der GUI und des views. Sie
 * verwaltet alle Szenen im Spiel, stellt Methoden zum Wechseln zwischen
 * unterschiedlichen Szenen sowie zur Anpassung einer eingestellten Aufloesung
 * bereit und definiert grundlegende Eigenschaften des Fensters und der Stage an
 * sich.
 *
 * @author Dylan
 */
public class AnwendungFX extends Application
{

	/**
	 * Die SZENEN_MAP beinhaltet alle Szenen, die im Spiel gezeigt werden sollen und
	 * ordnet diese einem Namen als String zu, mit welchem diese dann aufgerufen
	 * werden koennen, um z.B. die aktuelle Szene zu wechseln.
	 */
	private static final HashMap<String, Scene> SZENEN_MAP = new HashMap<>();

	private static final HashMap<String, Lokalisierbar> SZENEN_CONTROLLER_LIST = new HashMap<>();
	/**
	 * Die anwendungsStage ist die Stage des Spiels, auf der sich alle Szenen
	 * abspielen.
	 */
	private static Stage anwendungsStage = null;

	/**
	 * Aktualisiert die Aufloesung des Fensters, indem die Werte fuer alle Groessen,
	 * Abstaende, etc. aus dem css-StyleSheet fuer die aktuell eingestellte
	 * Aufloesung geladen werden.
	 */
	public static void aktualisiereFensterAufloesung()
	{
		AnwendungFX.entferneStyleSheetsVonAllenScenes();
		String eingestellteAufloesung = Einstellungen.getEinstellungen().getAnwendungsAufloesung().toString();
		AnwendungFX.fuegeStyleSheetAllenSzenenHinzu(
				Spielkonstanten.CSS_DATEI_PFAD + eingestellteAufloesung + Spielkonstanten.CSS_DATEI_ENDE);
		AnwendungFX.anwendungsStage.sizeToScene();
		AnwendungFX.anwendungsStage.centerOnScreen();
	}

	/**
	 * Aktualisiert alle Komponenten, die einen Text darstellen oder beinhalten,
	 * hinsichtlich der eingestellten Sprache.
	 */
	public static void aktualisiereSzenenSprache()
	{
		Einstellungen.getEinstellungen().setAnwendungsSprache(Einstellungen.getEinstellungen().getAnwendungsSprache());
	}

	/**
	 * Es wird durch die Controller aller Szenen iteriert um diesem jeweils zu
	 * signalisieren, dass alle Komponenten, die einen Text darstellen oder
	 * beinhalten, ihren Inhalt an die (neu) eingestellte Sprache anpassen sollen.
	 *
	 * @param sprachRessource Aus dieser Ressource werden die neuen Strings geladen.
	 */
	public static void aktualisiereSzenenSprache(ResourceBundle sprachRessource)
	{
		AnwendungFX.anwendungsStage.setTitle(sprachRessource.getString(LokalisierungsKeys.ANWENDUNGS_TITEL_KEY));
		for (Lokalisierbar controller : AnwendungFX.SZENEN_CONTROLLER_LIST.values())
		{
			controller.aktualisiereTextKomponenten(sprachRessource);
		}
	}

	/**
	 * Entfernt alle im Code hinzugefuegten css-StyleSheets von allen Szene der
	 * SZENEN_MAP. Hat keine Auswirkungen auf SytleSheets, die in der fxml-Datei
	 * einer Szene verlinkt wurden!
	 */
	private static void entferneStyleSheetsVonAllenScenes()
	{
		for (Scene szene : AnwendungFX.SZENEN_MAP.values())
		{
			szene.getStylesheets().clear();
		}
	}

	/**
	 * Fuegt alle im Parameter aufgelisteten StyleSheets allen Szenen der SZENEN_MAP
	 * hinzu. Sobald einer Szene ein neuer StyleSheet hinzugefuegt wurde, wird
	 * dieser automatisch und sofort angewendet.
	 *
	 * @param pfadeZuCSSDateien Auf alle Szenen anzuwendende StyleSheets
	 */
	private static void fuegeStyleSheetAllenSzenenHinzu(String... pfadeZuCSSDateien)
	{
		for (String cssPfad : pfadeZuCSSDateien)
		{
			for (Scene szene : AnwendungFX.SZENEN_MAP.values())
			{
				szene.getStylesheets().add(AnwendungFX.class.getResource(cssPfad).toExternalForm());
			}
		}

	}

	/**
	 * Fuegt die FXML-Datei mit dem Namen dateiNameDerFXML der SZENEN_MAP als neue
	 * Szene hinzu. Als String-Name in der SZENEN_MAP dient der dateiNameDerFXML.
	 * Der Pfad wird ueber diesen Dateinamen ermittelt, indem ihm die Endung ".fxml"
	 * angefuegt wird. Voraussetzung ist, dass alle fxmlSzenen-Dateien im selben
	 * package unter {@link Spielkonstanten}.FXML_DATEI_PFAD liegen.
	 *
	 * @param dateiNameDerFXML Der Name der fxml-Datei fuer die hinzuzufuegende
	 *                         Szene
	 */
	public static void fuegeSzeneHinzu(String dateiNameDerFXML)
	{
		try
		{
			FXMLLoader loader = new FXMLLoader(AnwendungFX.class.getResource(
					Spielkonstanten.FXML_DATEI_PFAD + dateiNameDerFXML + Spielkonstanten.FXML_DATEI_ENDUNG));
			AnwendungFX.SZENEN_MAP.put(dateiNameDerFXML, new Scene(loader.load()));
			AnwendungFX.SZENEN_CONTROLLER_LIST.put(dateiNameDerFXML, loader.getController());
		} catch (IOException e)
		{
			e.printStackTrace(); /// TODO: entfernen
			Main.anwendungBeenden();
		}
	}

	public static HashMap<String, Lokalisierbar> getSzenenController()
	{
		return AnwendungFX.SZENEN_CONTROLLER_LIST;
	}

	/**
	 * Hier werden alle Szenen in der SZENEN_MAP registriert und dieser
	 * hinzugefuegt.
	 */
	private static void initSzenen()
	{
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_TITEL_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_HAUPTMENUE_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_CREDIT_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_OPTIONEN_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_DUNGEON_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_SCHWIERIGKEIT_WAEHLEN_SZENE);
		AnwendungFX.fuegeSzeneHinzu(Spielkonstanten.ANWENDUNG_WELTKARTE_SZENE);
	}

	/**
	 * Startet die Anwendung, indem die JavaFX Application Methode launch()
	 * aufgerufen wird.
	 *
	 * @param args
	 * @see javafx.application.Application
	 */
	public static void starteAnwendung(String[] args)
	{
		Application.launch(args);
	}

	/**
	 * Es wird die Szene gewechselt. Die anwendungsStage zeigt dann also die Szene
	 * szenenName.
	 *
	 * @param szenenName Der Name der anzuzeigenden Szene.
	 */
	public static void wechselSzene(String szenenName)
	{
		AnwendungFX.anwendungsStage.setScene(AnwendungFX.SZENEN_MAP.get(szenenName));
	}

	/**
	 * Die Start Methode wird implizit durch das Aufrufen von Apllication.launch()
	 * aufgerufen. Sie startet die eigentliche Anwendung.
	 */
	@Override
	public void start(Stage stage) throws Exception
	{
		AnwendungFX.anwendungsStage = stage;
		AnwendungFX.initSzenen();
		AnwendungFX.aktualisiereSzenenSprache();
		AnwendungFX.aktualisiereFensterAufloesung();
		AnwendungFX.anwendungsStage.getIcons()
				.add(new Image(new File(Spielkonstanten.ANWENDUNG_ANWENDUNGS_ICON).toURI().toURL().toExternalForm()));
		AnwendungFX.anwendungsStage.setResizable(false);
		AnwendungFX.anwendungsStage.setOnCloseRequest(windowEvent -> Main.anwendungBeenden());
		AnwendungFX.anwendungsStage.setScene(AnwendungFX.SZENEN_MAP.get(Spielkonstanten.ANWENDUNG_TITEL_SZENE));
		AnwendungFX.anwendungsStage.show();
	}

}